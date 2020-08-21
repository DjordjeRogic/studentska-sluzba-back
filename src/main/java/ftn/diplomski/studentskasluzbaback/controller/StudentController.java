package ftn.diplomski.studentskasluzbaback.controller;

import ftn.diplomski.studentskasluzbaback.dto.*;
import ftn.diplomski.studentskasluzbaback.model.SkolskaGodina;
import ftn.diplomski.studentskasluzbaback.model.Student;
import ftn.diplomski.studentskasluzbaback.service.SkolskaGodinaService;
import ftn.diplomski.studentskasluzbaback.service.impl.ProfesorServiceImpl;
import ftn.diplomski.studentskasluzbaback.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;


@RestController
@RequestMapping(value = "/student", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class StudentController {
    @Autowired
    private StudentServiceImpl studentService;

    @Autowired
    private SkolskaGodinaService skolskaGodinaService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllStudenti() {
        System.out.println("Studenti");
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getStudent(@PathVariable("id")Long id) {
        System.out.println("Student");
        return new ResponseEntity<>(new StudentDTO(studentService.findStudent(id)), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> postProfesor(@RequestBody StudentDTO studentDTO) {
        System.out.println("Add Student");

        String checkMessage = studentService.checkNewStudent(studentDTO);
        if(checkMessage != null){
            return new ResponseEntity<>(checkMessage, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(studentService.saveNewStudent(studentDTO), HttpStatus.OK);
    }

    @GetMapping(value = "/ulogovan/predmeti/trenutniIspiti",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getTrenutniIspitiSmera() {
        System.out.println("Trenutni isoiti od smera:");
        ArrayList<IspitStudentDTO> ret = studentService.getTrenutneIspiteOdUlogvanog();
        return new ResponseEntity<>(ret, HttpStatus.OK);
    }
    @GetMapping(value = "/ispit/prijavljen",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getPrijavljeniIspiti() {
        System.out.println("Trenutni isoiti od smera:");
        ArrayList<IspitStudentDTO> ret = studentService.getPrijavljeniIsptiOdStudenta();
        return new ResponseEntity<>(ret, HttpStatus.OK);
    }


    @PutMapping(value = "/ispit/prijavi",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> prijaviIspit(@RequestBody PrijavaIspitaDTO prijavaIspitaDTO) {
        System.out.println("Prijavi");
        for(IspitStudentDTO ispitStudentDTO :prijavaIspitaDTO.getIspiti()) {
            studentService.prijaviIspit(ispitStudentDTO);
        }
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @PutMapping(value = "/ispit/odjavi",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> odjaviIspit(@RequestBody PrijavaIspitaDTO prijavaIspitaDTO) {
        System.out.println("Odjavi");
        for(IspitStudentDTO ispitStudentDTO :prijavaIspitaDTO.getIspiti()) {
            studentService.odjaviIspit(ispitStudentDTO);
        }
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @GetMapping(value = "/semestar/overen",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> checkOverenSemestar() {

        //TODO Provera datuma
        System.out.println("SEMESTAR:");

        SkolskaGodina skolskaGodina = skolskaGodinaService.getTrenutnaSkolskaGodina();
        if(LocalDate.now().isAfter(skolskaGodina.getPocetakOvereLetnjeg()) && LocalDate.now().isBefore(skolskaGodina.getKrajOvereLetnjeg())){

            Student student = studentService.ulogovanStudent();
            System.out.println(student.getName());
            Integer ocekivanSmesetar = studentService.ocekivaniSemestarZaStudenta(student.getId());
            if(student.getSemestar() != ocekivanSmesetar){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            return new ResponseEntity<>("Pocela je overa letnjeg semestra",HttpStatus.OK);

        }

        if(LocalDate.now().isAfter(skolskaGodina.getPocetakOvereZimskog()) && LocalDate.now().isBefore(skolskaGodina.getKrajOvereZimskog())){

            Student student = studentService.ulogovanStudent();
            System.out.println(student.getName());
            Integer ocekivanSmesetar = studentService.ocekivaniSemestarZaStudenta(student.getId());
            if(student.getSemestar() != ocekivanSmesetar){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            return new ResponseEntity<>("Pocela je overa zimskog semestra",HttpStatus.OK);

        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping(value = "/semestar/overi",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> overiSemestar() {

        //TODO Provera datuma, provera stanja na racunu


        studentService.overiSemestarUlogovan();
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @GetMapping(value = "/ocena",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getOcene() {
        System.out.println("Ocene od studenta");
        ArrayList<OcenaDTO> ret = studentService.getOceneUlogovanogStudenta();
        return new ResponseEntity<>(ret, HttpStatus.OK);
    }
}


