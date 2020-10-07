package ftn.diplomski.studentskasluzbaback.controller;

import ftn.diplomski.studentskasluzbaback.dto.SmerDTO;
import ftn.diplomski.studentskasluzbaback.dto.SmerPredmetDTO;
import ftn.diplomski.studentskasluzbaback.dto.StudentDolasciDTO;
import ftn.diplomski.studentskasluzbaback.dto.StudentRezultatDTO;
import ftn.diplomski.studentskasluzbaback.service.IspitService;
import ftn.diplomski.studentskasluzbaback.service.SmerPredmetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping(value = "/studijskiProgram", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class SmerPredmetController {

    @Autowired
    private SmerPredmetService smerPredmetService;

    @Autowired
    private IspitService ispitService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> postStudijskiProgram(@RequestBody SmerPredmetDTO smerPredmetDTO) {
        if(smerPredmetService.checkNewSmerPredmet(smerPredmetDTO) != null){
            return new ResponseEntity<>(smerPredmetService.checkNewSmerPredmet(smerPredmetDTO), HttpStatus.BAD_REQUEST);
        }
        SmerPredmetDTO smerPredmetDTO1 = smerPredmetService.kreirajStudijskiProgram(smerPredmetDTO);
        return new ResponseEntity<>(smerPredmetDTO1, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getProgram(@PathVariable("id")Long id) {
        return new ResponseEntity<>(smerPredmetService.getOne(id), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}/profesori",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getProfesoriSaPrograma(@PathVariable("id")Long id) {
        return new ResponseEntity<>(smerPredmetService.getProfesori(id), HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateStudijskiProgram(@RequestBody SmerPredmetDTO smerPredmetDTO) {
        System.out.println(smerPredmetDTO.getBrojESBPBodova());
        if(smerPredmetService.checkUpdate(smerPredmetDTO) != null){
            return new ResponseEntity<>(smerPredmetService.checkUpdate(smerPredmetDTO), HttpStatus.BAD_REQUEST);
        }
        SmerPredmetDTO smerPredmetDTO1 = smerPredmetService.update(smerPredmetDTO);
        return new ResponseEntity<>(smerPredmetDTO1, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteStudijskiProgram(@PathVariable("id")Long id) {
        if(smerPredmetService.checkDelete(id) != null){
            return new ResponseEntity<>(smerPredmetService.checkDelete(id), HttpStatus.BAD_REQUEST);
        }
        smerPredmetService.deleteSmerPredmet(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}/ispit/{id_ispita}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> removeIspitPrograma(@PathVariable("id")Long id,@PathVariable("id_ispita")Long id_ispita) {
        if(ispitService.checkRemoveIspti(id_ispita) != null){
            return new ResponseEntity<>(ispitService.checkRemoveIspti(id_ispita), HttpStatus.BAD_REQUEST);
        }
        ispitService.removeIspit(id_ispita);
        smerPredmetService.removeIspitOdPredmeta(id,id_ispita);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/{id}/ispit",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getIspitiStudjiskogPrograma(@PathVariable("id")Long id) {
        return new ResponseEntity<>(smerPredmetService.getIspiti(id), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}/student/dolasci",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getStudentiStudjiskogPrograma(@PathVariable("id")Long id) {
        return new ResponseEntity<>(smerPredmetService.getStudentiDolasci(id), HttpStatus.OK);
    }

    @GetMapping(value="/{id}/student/dolasci/download",produces ="application/vnd.ms-excel")
    public ResponseEntity<?> studentiKojiSuPrijaviliIspitDownload(@PathVariable("id")Long id) throws IOException {
        return new ResponseEntity<>(smerPredmetService.downloadStudenteZaDolaske(id), HttpStatus.OK);
    }

    @PostMapping(value="/{id}/student/dolasci/upload")
    public ResponseEntity<?> studentiKojiSuPrijaviliIspitUpload(@PathVariable("id")Long id,@RequestParam("file") MultipartFile file) throws IOException {
        return new ResponseEntity<>(smerPredmetService.uploadStudenteZaDolaske(id,file), HttpStatus.OK);
    }

    @PutMapping(value = "{id}/dolasci", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> postIspit(@PathVariable("id")Long id, @RequestBody ArrayList<StudentDolasciDTO> studentDolasciDTOS) {
        smerPredmetService.unesiDolaske(id,studentDolasciDTOS);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
