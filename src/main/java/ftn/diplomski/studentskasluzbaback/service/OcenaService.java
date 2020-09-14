package ftn.diplomski.studentskasluzbaback.service;

import ftn.diplomski.studentskasluzbaback.dto.StudentRezultatDTO;
import ftn.diplomski.studentskasluzbaback.model.Ocena;
import ftn.diplomski.studentskasluzbaback.model.Predmet;
import ftn.diplomski.studentskasluzbaback.model.SmerPredmet;
import ftn.diplomski.studentskasluzbaback.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface OcenaService {
    Ocena pronadjiOcenuOdStudentaZaPredmet(Student student, SmerPredmet smerPredmet);
    void unesiOcene(Long id_ispita,ArrayList<StudentRezultatDTO> studentRezultatDTOS);
    Ocena save(Ocena ocena);

    void kreirajOcene(Student student, int semestar);
}
