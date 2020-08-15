package ftn.diplomski.studentskasluzbaback.controller;
import ftn.diplomski.studentskasluzbaback.dto.IspitDTO;
import ftn.diplomski.studentskasluzbaback.dto.IspitProfesorDTO;
import ftn.diplomski.studentskasluzbaback.dto.PredmetDTO;
import ftn.diplomski.studentskasluzbaback.dto.ProfesorDTO;
import ftn.diplomski.studentskasluzbaback.repository.IspitRepository;
import ftn.diplomski.studentskasluzbaback.service.IspitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(value = "/ispit", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class IspitController {

    @Autowired
    private IspitService ispitService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> postIspit(@RequestBody IspitDTO ispitDTO) {
        System.out.println("Add Ispit");

        if(ispitService.checkNewIspit(ispitDTO) != null){
            return new ResponseEntity<>(ispitService.checkNewIspit(ispitDTO), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(ispitService.saveNewIspit(ispitDTO), HttpStatus.OK);
    }

    @PutMapping(value = "/profesorUpdate",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateIspitProfesor(@RequestBody IspitProfesorDTO ispitProfesorDTO) {
        System.out.println("Update ispit prof");

        return new ResponseEntity<>(ispitService.updateIspitProfesor(ispitProfesorDTO), HttpStatus.OK);
    }

    @GetMapping(value="/{id}/student",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> studentiKojiSuPrijaviliIspit(@PathVariable("id")Long id) {
        System.out.println("Studenti rezultati");
        return new ResponseEntity<>(ispitService.getStudenteZaRezultate(id), HttpStatus.OK);
    }

    @GetMapping(value="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getIspit(@PathVariable("id")Long id) {
        System.out.println("Get one ispit");
        return new ResponseEntity<>(new IspitProfesorDTO(ispitService.getOne(id)), HttpStatus.OK);
    }


    @GetMapping(value="/{id}/student/download",produces ="application/vnd.ms-excel")
    public ResponseEntity<?> studentiKojiSuPrijaviliIspitDownload(@PathVariable("id")Long id) throws IOException {
        System.out.println("Studenti rezultati");

        return new ResponseEntity<>(ispitService.downloadStudenteZaRezultate(id), HttpStatus.OK);
    }

    @PostMapping(value="/{id}/student/upload")
    public ResponseEntity<?> studentiKojiSuPrijaviliIspitUpload(@PathVariable("id")Long id,@RequestParam("file") MultipartFile file) throws IOException {
        System.out.println("Studenti rezultati");

        return new ResponseEntity<>(ispitService.uploadStudenteZaRezultate(id,file), HttpStatus.OK);
    }
}
