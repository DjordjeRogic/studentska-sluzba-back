package ftn.diplomski.studentskasluzbaback.controller;

import ftn.diplomski.studentskasluzbaback.dto.SmerDTO;
import ftn.diplomski.studentskasluzbaback.dto.SmerPredmetDTO;
import ftn.diplomski.studentskasluzbaback.service.SmerPredmetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
