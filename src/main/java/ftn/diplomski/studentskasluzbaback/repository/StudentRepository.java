package ftn.diplomski.studentskasluzbaback.repository;

import ftn.diplomski.studentskasluzbaback.model.SkolskaGodina;
import ftn.diplomski.studentskasluzbaback.model.Smer;
import ftn.diplomski.studentskasluzbaback.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {

    List<Student> findAllBySmerAndGodinaUpisa(Smer smer, SkolskaGodina godinaUpisa);

}
