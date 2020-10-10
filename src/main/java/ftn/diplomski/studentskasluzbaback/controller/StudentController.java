package ftn.diplomski.studentskasluzbaback.controller;

import ftn.diplomski.studentskasluzbaback.dto.*;
import ftn.diplomski.studentskasluzbaback.model.SkolskaGodina;
import ftn.diplomski.studentskasluzbaback.model.Student;
import ftn.diplomski.studentskasluzbaback.service.EmailService;
import ftn.diplomski.studentskasluzbaback.service.SkolskaGodinaService;
import ftn.diplomski.studentskasluzbaback.service.impl.ProfesorServiceImpl;
import ftn.diplomski.studentskasluzbaback.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("hasAuthority('read_all_students')")
    @GetMapping(value = "/page/{page}/size/{size}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllStudenti(@PathVariable("page")int page,@PathVariable("size")int size) {
        return new ResponseEntity<>(studentService.getAllStudentsPage(page,size), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('read_all_students')")
    @GetMapping(value = "/{name}/{surname}/{email}/{brojIndexa}/page/{page}/size/{size}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> searchStudenti(@PathVariable("name")String name,@PathVariable("surname")String surname,@PathVariable("email")String email,@PathVariable("brojIndexa")String brojIndexa,@PathVariable("page")int page,@PathVariable("size")int size) {
        return new ResponseEntity<>(studentService.searchStudentsPagable(name,surname,email,brojIndexa,page,size), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('read_all_students')")
    @GetMapping(value = "/{name}/{surname}/{email}/{brojIndexa}/size",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> searchSize(@PathVariable("name")String name,@PathVariable("surname")String surname,@PathVariable("email")String email,@PathVariable("brojIndexa")String brojIndexa) {
        return new ResponseEntity<>(studentService.searchStudentsAll(name,surname,email,brojIndexa).size(), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('read_all_students')")
    @GetMapping(value = "/size",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getStudentSize() {
        return new ResponseEntity<>(studentService.getAllStudents().size(), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('read_student')")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getStudent(@PathVariable("id")Long id) {
        return new ResponseEntity<>(new StudentDTO(studentService.findStudent(id)), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('create_student')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> postStudent(@RequestBody StudentDTO studentDTO) {
        String checkMessage = studentService.checkNewStudent(studentDTO);
        if(checkMessage != null){
            return new ResponseEntity<>(checkMessage, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(studentService.saveNewStudent(studentDTO), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('update_student')")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?>updateStudent(@RequestBody StudentDTO studentDTO) {
        String checkMessage = studentService.checkUpdateStudent(studentDTO);
        if(checkMessage != null){
            return new ResponseEntity<>(checkMessage, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(studentService.updateStudent(studentDTO), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('read_students_current_ispits')")
    @GetMapping(value = "/ulogovan/predmeti/trenutniIspiti",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getTrenutniIspitiSmera() {
        ArrayList<IspitStudentDTO> ret = studentService.getTrenutneIspiteOdUlogvanog();
        return new ResponseEntity<>(ret, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('read_students_added_ispits')")
    @GetMapping(value = "/ispit/prijavljen",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getPrijavljeniIspiti() {
        ArrayList<IspitStudentDTO> ret = studentService.getPrijavljeniIsptiOdStudenta();
        return new ResponseEntity<>(ret, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('update_students_ispits')")
    @PutMapping(value = "/ispit/prijavi",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> prijaviIspit(@RequestBody PrijavaIspitaDTO prijavaIspitaDTO) {
        for(IspitStudentDTO ispitStudentDTO :prijavaIspitaDTO.getIspiti()) {
            studentService.prijaviIspit(ispitStudentDTO);
        }
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('update_students_ispits')")
    @PutMapping(value = "/ispit/odjavi",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> odjaviIspit(@RequestBody PrijavaIspitaDTO prijavaIspitaDTO) {
        for(IspitStudentDTO ispitStudentDTO :prijavaIspitaDTO.getIspiti()) {
            studentService.odjaviIspit(ispitStudentDTO);
        }
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('check_student_smester')")
    @GetMapping(value = "/semestar/overen",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> checkOverenSemestar() {

        SkolskaGodina skolskaGodina = skolskaGodinaService.getTrenutnaSkolskaGodina();
        if(LocalDate.now().isAfter(skolskaGodina.getPocetakOvereLetnjeg()) && LocalDate.now().isBefore(skolskaGodina.getKrajOvereLetnjeg())){

            Student student = studentService.ulogovanStudent();
            System.out.println(student.getName());
            Integer ocekivanSmesetar = studentService.ocekivaniSemestarZaStudenta(student.getId());
            if(student.getSemestar() != ocekivanSmesetar){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            return new ResponseEntity<>(HttpStatus.OK);

        }

        if(LocalDate.now().isAfter(skolskaGodina.getPocetakOvereZimskog()) && LocalDate.now().isBefore(skolskaGodina.getKrajOvereZimskog())){

            Student student = studentService.ulogovanStudent();
            Integer ocekivanSmesetar = studentService.ocekivaniSemestarZaStudenta(student.getId());
            if(student.getSemestar() != ocekivanSmesetar){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            return new ResponseEntity<>(HttpStatus.OK);

        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('update_student_smester')")
    @PutMapping(value = "/semestar/overi",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> overiSemestar() {

        //TODO Provera datuma

        studentService.overiSemestarUlogovan();
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('read_ocena')")
    @GetMapping(value = "/ocena",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getOcene() {
        ArrayList<OcenaDTO> ret = studentService.getOceneUlogovanogStudenta();
        return new ResponseEntity<>(ret, HttpStatus.OK);
    }
}


