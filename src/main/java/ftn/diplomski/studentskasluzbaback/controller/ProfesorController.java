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

    @PreAuthorize("hasAuthority('read_all_profesors')")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getProfesori() {
        return new ResponseEntity<>(profesorService.getAllProfesors(), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('read_profesor')")
    @GetMapping(value ="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getProfesor(@PathVariable("id")Long id) {
        return new ResponseEntity<>(profesorService.getProfesor(id), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('create_profesor')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> postProfesor(@RequestBody ProfesorDTO profesorDTO) {
        String checkMessage = profesorService.checkNewProfesor(profesorDTO);
        if(checkMessage != null){
            return new ResponseEntity<>(checkMessage, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(profesorService.saveNewProfesor(profesorDTO), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('delete_profesor')")
    @DeleteMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteProfesor(@PathVariable("id")Long id) {
        if(profesorService.proveriDaLiProfesorMozeBitiObrisan(id) != null){
            return new ResponseEntity<>(profesorService.proveriDaLiProfesorMozeBitiObrisan(id), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(profesorService.deleteProfesor(id), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('update_profesor')")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateProfesor(@RequestBody ProfesorDTO profesorDTO) {
        String checkMessage = profesorService.checkUpdateProfesor(profesorDTO);
        if(checkMessage != null){
            return new ResponseEntity<>(checkMessage, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(profesorService.updateProfesor(profesorDTO), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('read_profesors_ispits')")
    @GetMapping(value = "/ulogovan/predmet/ispit",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getIspitiOdProfesora() {
        return new ResponseEntity<>(profesorService.getIspiteKodUlogovanogProfesora(), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('read_profesors_finished_ispits')")
    @GetMapping(value = "/ulogovan/predmet/ispit/zaUnosRezultata",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getZavrseniIspitiOdProfesora() {
        return new ResponseEntity<>(profesorService.getIspitiOdProfesoraZaUnosOcene(), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('read_profesors_predmets')")
    @GetMapping(value = "/ulogovan/predmet",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getPredmetiOdProfesora() {
        return new ResponseEntity<>(profesorService.getPredmetiOdProfesora(), HttpStatus.OK);
    }
}
