package ftn.diplomski.studentskasluzbaback.controller;

import ftn.diplomski.studentskasluzbaback.dto.IspitDTO;
import ftn.diplomski.studentskasluzbaback.dto.StudentRezultatDTO;
import ftn.diplomski.studentskasluzbaback.service.impl.OcenaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping(value = "/ocena", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class OcenaController {

    @Autowired
    private OcenaServiceImpl ocenaService;

    @PutMapping(value = "/ispit/{id}/rezultatiIspita", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> postIspit(@PathVariable("id")Long id,@RequestBody ArrayList<StudentRezultatDTO> studentRezultatDTOS) {
        System.out.println("Add Ispit");

        ocenaService.unesiOcene(id,studentRezultatDTOS);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
