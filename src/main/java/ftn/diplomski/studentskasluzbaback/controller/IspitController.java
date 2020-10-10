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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(value = "/ispit", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class IspitController {

    @Autowired
    private IspitService ispitService;

    @PreAuthorize("hasAuthority('create_ispit')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> postIspit(@RequestBody IspitDTO ispitDTO) {
        if(ispitService.checkNewIspit(ispitDTO) != null){
            return new ResponseEntity<>(ispitService.checkNewIspit(ispitDTO), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(ispitService.saveNewIspit(ispitDTO), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('update_ispit')")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@RequestBody IspitDTO ispitDTO) {
        if(ispitService.checkNewIspit(ispitDTO) != null){
            return new ResponseEntity<>(ispitService.checkNewIspit(ispitDTO), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(ispitService.updateIspit(ispitDTO), HttpStatus.OK);
    }

    /* Uklonjena mogucnost da profesor updejtuje ispit
    @PreAuthorize("hasAuthority('update_ispit')")
    @PutMapping(value = "/profesorUpdate",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateIspitProfesor(@RequestBody IspitProfesorDTO ispitProfesorDTO) {
        return new ResponseEntity<>(ispitService.updateIspitProfesor(ispitProfesorDTO), HttpStatus.OK);
    }*/

    @PreAuthorize("hasAuthority('read_students_of_ispit')")
    @GetMapping(value="/{id}/student",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> studentiKojiSuPrijaviliIspit(@PathVariable("id")Long id) {
        return new ResponseEntity<>(ispitService.getStudenteZaRezultate(id), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('read_ispit')")
    @GetMapping(value="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getIspit(@PathVariable("id")Long id) {
        return new ResponseEntity<>(new IspitProfesorDTO(ispitService.getOne(id)), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('download_students_of_ispit')")
    @GetMapping(value="/{id}/student/download",produces ="application/vnd.ms-excel")
    public ResponseEntity<?> studentiKojiSuPrijaviliIspitDownload(@PathVariable("id")Long id) throws IOException {
        return new ResponseEntity<>(ispitService.downloadStudenteZaRezultate(id), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('upload_results')")
    @PostMapping(value="/{id}/student/upload")
    public ResponseEntity<?> studentiKojiSuPrijaviliIspitUpload(@PathVariable("id")Long id,@RequestParam("file") MultipartFile file) throws IOException {
        return new ResponseEntity<>(ispitService.uploadStudenteZaRezultate(id,file), HttpStatus.OK);
    }
}
