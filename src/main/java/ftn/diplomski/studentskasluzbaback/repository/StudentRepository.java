package ftn.diplomski.studentskasluzbaback.repository;

import ftn.diplomski.studentskasluzbaback.model.SkolskaGodina;
import ftn.diplomski.studentskasluzbaback.model.Smer;
import ftn.diplomski.studentskasluzbaback.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {

    List<Student> findAllBySmerAndGodinaUpisaOrderByBrojIndexa(Smer smer, SkolskaGodina godinaUpisa);
    Student findByEmail(String email);

    @Query("select s from Student s where s.name like %?1% and s.surname like %?2% and s.email like %?3%and s.brojIndexa like %?4%")
    Page<Student> search(String name, String surname, String email, String brojIndexa, Pageable pageable);

    @Query("select s from Student s where s.name like %?1% and s.surname like %?2% and s.email like %?3%and s.brojIndexa like %?4%")
    List<Student> searchAll(String name, String surname, String email, String brojIndexa);
}
