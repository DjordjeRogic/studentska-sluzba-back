package ftn.diplomski.studentskasluzbaback.service;

import ftn.diplomski.studentskasluzbaback.model.User;

public interface UserService {
    User getUserByEmail(String email);
}
