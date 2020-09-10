package ftn.diplomski.studentskasluzbaback.repository;

import ftn.diplomski.studentskasluzbaback.model.Smer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmerRepository extends JpaRepository<Smer,Long> {

    Smer findByNaziv(String naziv);
    Smer findBySkracenica(String skracenica);
}
