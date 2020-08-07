package ftn.diplomski.studentskasluzbaback.controller;


import ftn.diplomski.studentskasluzbaback.dto.CurrentUser;
import ftn.diplomski.studentskasluzbaback.dto.ProfesorDTO;
import ftn.diplomski.studentskasluzbaback.model.User;
import ftn.diplomski.studentskasluzbaback.service.impl.ProfesorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/profesor", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class ProfesorController {
    @Autowired
    private ProfesorServiceImpl profesorService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getProfesori() {
        System.out.println("Profesori");
        return new ResponseEntity<>(profesorService.getAllProfesors(), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> postProfesor(@RequestBody ProfesorDTO profesorDTO) {
        System.out.println("Add Profesor");

        String checkMessage = profesorService.checkNewProfesor(profesorDTO);
        if(checkMessage != null){
            return new ResponseEntity<>(checkMessage, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(profesorService.saveNewProfesor(profesorDTO), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteProfesor(@PathVariable("id")Long id) {
        System.out.println("Delete profesor");
        if(profesorService.proveriDaLiProfesorMozeBitiObrisan(id) != null){
            return new ResponseEntity<>(profesorService.proveriDaLiProfesorMozeBitiObrisan(id), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(profesorService.deleteProfesor(id), HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateProfesor(@RequestBody ProfesorDTO profesorDTO) {
        System.out.println("Add Profesor");

        String checkMessage = profesorService.checkNewProfesor(profesorDTO);
        if(checkMessage != null){
            return new ResponseEntity<>(checkMessage, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(profesorService.updateProfesor(profesorDTO), HttpStatus.OK);
    }
}
