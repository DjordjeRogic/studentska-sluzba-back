package ftn.diplomski.studentskasluzbaback.service.impl;

import ftn.diplomski.studentskasluzbaback.model.Ocena;
import ftn.diplomski.studentskasluzbaback.model.Predmet;
import ftn.diplomski.studentskasluzbaback.model.SmerPredmet;
import ftn.diplomski.studentskasluzbaback.model.Student;
import ftn.diplomski.studentskasluzbaback.repository.OcenaRepository;
import ftn.diplomski.studentskasluzbaback.service.OcenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OcenaServiceImpl implements OcenaService {

    @Autowired
    private OcenaRepository ocenaRepository;

    @Override
    public Ocena pronadjiOcenuOdStudentaZaPredmet(Student student, SmerPredmet smerPredmet) {
        return ocenaRepository.findByStudentAndSmerPredmet(student,smerPredmet);
    }
}
