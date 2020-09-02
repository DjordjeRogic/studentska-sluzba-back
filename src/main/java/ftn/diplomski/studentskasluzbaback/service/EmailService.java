package ftn.diplomski.studentskasluzbaback.service;

import ftn.diplomski.studentskasluzbaback.dto.StudentRezultatDTO;
import ftn.diplomski.studentskasluzbaback.model.Ispit;
import ftn.diplomski.studentskasluzbaback.model.Ocena;
import ftn.diplomski.studentskasluzbaback.model.Student;

import java.util.ArrayList;

public interface EmailService {

    void otvorenNalogStudentu(Student student,String sifra);
    void uneseniRezultatiIspita(Ocena ocena);
    void poceoIspitniRok();//TODO MOZDA

}
