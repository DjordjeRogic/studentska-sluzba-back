package ftn.diplomski.studentskasluzbaback.service;

import ftn.diplomski.studentskasluzbaback.model.Role;

import java.util.List;

public interface RoleService {

   List<Role> findByName(String name);
}
