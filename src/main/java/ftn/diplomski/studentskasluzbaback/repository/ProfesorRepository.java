package ftn.diplomski.studentskasluzbaback.repository;

import ftn.diplomski.studentskasluzbaback.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Profesor,Long> {

    Profesor findProfesorByEmail(String email);
    Profesor findProfesorBySifraProfesora(String sifraProfesora);

}
