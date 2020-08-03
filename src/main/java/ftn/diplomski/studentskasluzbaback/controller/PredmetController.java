package ftn.diplomski.studentskasluzbaback.controller;


import ftn.diplomski.studentskasluzbaback.dto.PredmetDTO;
import ftn.diplomski.studentskasluzbaback.dto.ProfesorDTO;
import ftn.diplomski.studentskasluzbaback.service.impl.PredmetServiceImpl;
import ftn.diplomski.studentskasluzbaback.service.impl.ProfesorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/predmet", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class PredmetController {
    @Autowired
    private PredmetServiceImpl predmetService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getPredmeti() {
        System.out.println("Predmeti");
        return new ResponseEntity<>(predmetService.getAllPredmets(), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> postProfesor(@RequestBody PredmetDTO predmetDTO) {
        System.out.println("Add Predmet");

        return new ResponseEntity<>(predmetService.saveNewPredmet(predmetDTO), HttpStatus.OK);
    }
}
