package ftn.diplomski.studentskasluzbaback.controller;

import ftn.diplomski.studentskasluzbaback.dto.SmerDTO;
import ftn.diplomski.studentskasluzbaback.dto.SmerPredmetDTO;
import ftn.diplomski.studentskasluzbaback.dto.StudentDolasciDTO;
import ftn.diplomski.studentskasluzbaback.dto.StudentRezultatDTO;
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

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> postStudijskiProgram(@RequestBody SmerPredmetDTO smerPredmetDTO) {
        System.out.println("Add smerPredmet");

        System.out.println(smerPredmetDTO.getBrojESBPBodova());
        if(smerPredmetService.checkNewSmerPredmet(smerPredmetDTO) != null){
            return new ResponseEntity<>(smerPredmetService.checkNewSmerPredmet(smerPredmetDTO), HttpStatus.BAD_REQUEST);
        }

        SmerPredmetDTO smerPredmetDTO1 = smerPredmetService.kreirajStudijskiProgram(smerPredmetDTO);

        return new ResponseEntity<>(smerPredmetDTO1, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getProgram(@PathVariable("id")Long id) {
        System.out.println("Studijski program");
        return new ResponseEntity<>(smerPredmetService.getOne(id), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}/ispit",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getIspitiStudjiskogPrograma(@PathVariable("id")Long id) {
        System.out.println("Studijski program ispiti");
        return new ResponseEntity<>(smerPredmetService.getIspiti(id), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}/student/dolasci",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getStudentiStudjiskogPrograma(@PathVariable("id")Long id) {
        System.out.println("Studijski program ispiti");
        return new ResponseEntity<>(smerPredmetService.getStudentiDolasci(id), HttpStatus.OK);
    }

    @GetMapping(value="/{id}/student/dolasci/download",produces ="application/vnd.ms-excel")
    public ResponseEntity<?> studentiKojiSuPrijaviliIspitDownload(@PathVariable("id")Long id) throws IOException {
        System.out.println("Studenti rezultati");

        return new ResponseEntity<>(smerPredmetService.downloadStudenteZaDolaske(id), HttpStatus.OK);
    }

    @PostMapping(value="/{id}/student/dolasci/upload")
    public ResponseEntity<?> studentiKojiSuPrijaviliIspitUpload(@PathVariable("id")Long id,@RequestParam("file") MultipartFile file) throws IOException {
        System.out.println("Studenti rezultati");

        return new ResponseEntity<>(smerPredmetService.uploadStudenteZaDolaske(id,file), HttpStatus.OK);
    }

    @PutMapping(value = "{id}/dolasci", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> postIspit(@PathVariable("id")Long id, @RequestBody ArrayList<StudentDolasciDTO> studentDolasciDTOS) {
        System.out.println("Add Ispit");

        smerPredmetService.unesiDolaske(id,studentDolasciDTOS);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
