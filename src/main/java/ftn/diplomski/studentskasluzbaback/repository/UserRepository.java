package ftn.diplomski.studentskasluzbaback.repository;

import ftn.diplomski.studentskasluzbaback.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
