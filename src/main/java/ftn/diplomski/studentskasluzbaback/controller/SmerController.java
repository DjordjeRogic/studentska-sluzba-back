package ftn.diplomski.studentskasluzbaback.controller;

import ftn.diplomski.studentskasluzbaback.dto.ProfesorDTO;
import ftn.diplomski.studentskasluzbaback.dto.SmerDTO;
import ftn.diplomski.studentskasluzbaback.service.impl.ProfesorServiceImpl;
import ftn.diplomski.studentskasluzbaback.service.impl.SmerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping(value = "/smer", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class SmerController {
    @Autowired
    private SmerServiceImpl smerService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getSmerovi() {
        System.out.println("Smerovi");
        return new ResponseEntity<>(smerService.getAllSmerovi(), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> postSmer(@RequestBody SmerDTO smerDTO) {
        System.out.println("Add Smer");

        //TODO CHECK
       /* String checkMessage = smerService.checkNewSmer(smerDTO);
        if(checkMessage != null){
            return new ResponseEntity<>(checkMessage, HttpStatus.BAD_REQUEST);
        }*/

        return new ResponseEntity<>(smerService.saveNewSmer(smerDTO), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getSmer(@PathVariable("id")Long id) {
        System.out.println("Predmeti od smera");
        return new ResponseEntity<>(smerService.getSmer(id), HttpStatus.OK);
    }
    @GetMapping(path = "/{id}/predemti",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getPredmetiOdSmera(@PathVariable("id")Long id) {
        System.out.println("Predmeti od smera");
        return new ResponseEntity<>(smerService.getPredmetiOdSmera(id), HttpStatus.OK);
    }
}
