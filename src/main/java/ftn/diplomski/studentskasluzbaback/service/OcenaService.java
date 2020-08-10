package ftn.diplomski.studentskasluzbaback.service;

import ftn.diplomski.studentskasluzbaback.model.Ocena;
import ftn.diplomski.studentskasluzbaback.model.Predmet;
import ftn.diplomski.studentskasluzbaback.model.SmerPredmet;
import ftn.diplomski.studentskasluzbaback.model.Student;
import org.springframework.stereotype.Service;

@Service
public interface OcenaService {
    Ocena pronadjiOcenuOdStudentaZaPredmet(Student student, SmerPredmet smerPredmet);
}
