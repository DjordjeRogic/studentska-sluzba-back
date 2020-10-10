package ftn.diplomski.studentskasluzbaback.repository;

import ftn.diplomski.studentskasluzbaback.model.Profesor;
import ftn.diplomski.studentskasluzbaback.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role,Long> {
    List<Role> findByName(String name);
}
