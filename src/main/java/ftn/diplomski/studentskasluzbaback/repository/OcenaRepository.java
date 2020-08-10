package ftn.diplomski.studentskasluzbaback.repository;

import ftn.diplomski.studentskasluzbaback.model.Ocena;
import ftn.diplomski.studentskasluzbaback.model.SmerPredmet;
import ftn.diplomski.studentskasluzbaback.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OcenaRepository extends JpaRepository<Ocena,Long> {

    Ocena findByStudentAndSmerPredmet(Student student, SmerPredmet smerPredmet);
}
