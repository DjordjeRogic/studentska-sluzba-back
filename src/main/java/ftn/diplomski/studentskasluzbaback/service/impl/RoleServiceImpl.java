package ftn.diplomski.studentskasluzbaback.service.impl;

import ftn.diplomski.studentskasluzbaback.model.Role;
import ftn.diplomski.studentskasluzbaback.repository.RoleRepository;
import ftn.diplomski.studentskasluzbaback.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> findByName(String name) {
        return roleRepository.findByName(name);
    }
}
