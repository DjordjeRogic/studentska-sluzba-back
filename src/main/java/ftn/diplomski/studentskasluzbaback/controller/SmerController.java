package ftn.diplomski.studentskasluzbaback.controller;

import ftn.diplomski.studentskasluzbaback.dto.SmerDTO;
import ftn.diplomski.studentskasluzbaback.dto.SmerPredmetDTO;
import ftn.diplomski.studentskasluzbaback.service.impl.SmerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/smer", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class SmerController {
    @Autowired
    private SmerServiceImpl smerService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getSmerovi() {
        return new ResponseEntity<>(smerService.getAllSmerovi(), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> postSmer(@RequestBody SmerDTO smerDTO) {
        //TODO CHECK
       /* String checkMessage = smerService.checkNewSmer(smerDTO);
        if(checkMessage != null){
            return new ResponseEntity<>(checkMessage, HttpStatus.BAD_REQUEST);
        }*/
        return new ResponseEntity<>(smerService.saveNewSmer(smerDTO), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteSmer(@PathVariable("id")Long id) {
        String checkMessage = smerService.checkDelete(id);
        if(checkMessage != null){
            return new ResponseEntity<>(checkMessage, HttpStatus.BAD_REQUEST);
        }
        smerService.deleteSmer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateSmer(@RequestBody SmerDTO smerDTO) {
        String checkMessage = smerService.checkUpdate(smerDTO);
        if(checkMessage != null){
            return new ResponseEntity<>(checkMessage, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(smerService.updateSmer(smerDTO), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getSmer(@PathVariable("id")Long id) {
        return new ResponseEntity<>(smerService.getSmer(id), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}/predmeti",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getPredmetiOdSmera(@PathVariable("id")Long id) {
        ArrayList<SmerPredmetDTO> ret = smerService.getPredmetiOdSmera(id);
        return new ResponseEntity<>(ret, HttpStatus.OK);
    }

    @PostMapping(value = "/{id}/predmet",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> dodajPredmetSmeru(@PathVariable("id")Long id) {
        ArrayList<SmerPredmetDTO> ret = smerService.getPredmetiOdSmera(id);
        return new ResponseEntity<>(ret, HttpStatus.OK);
    }


    @GetMapping(value = "/{id}/predmeti/trenutniIspiti",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getTrenutniIspitiSmera(@PathVariable("id")Long id) {
        ArrayList<SmerPredmetDTO> ret = smerService.getPredmetiOdSmera(id);
        return new ResponseEntity<>(ret, HttpStatus.OK);
    }
}
