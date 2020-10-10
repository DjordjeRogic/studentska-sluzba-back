package ftn.diplomski.studentskasluzbaback.controller;

import ftn.diplomski.studentskasluzbaback.dto.CurrentUser;
import ftn.diplomski.studentskasluzbaback.dto.SifraDTO;
import ftn.diplomski.studentskasluzbaback.model.User;
import ftn.diplomski.studentskasluzbaback.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PreAuthorize("hasAuthority('read_user_info')")
    @GetMapping("/currentUser")
    public ResponseEntity<?> user() {
        Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
        String email = currentUser.getName();
        User user = this.userService.getUserByEmail(email);
        CurrentUser currentUserDto = new CurrentUser(user);
        return new ResponseEntity<>(currentUserDto, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('update_password')")
    @PutMapping(value = "/{id}/sifra")
    public ResponseEntity<?> changePassword(@PathVariable("id") Long id,@RequestBody SifraDTO sifraDTO) {
        if(!sifraDTO.getNovaSifra().equals(sifraDTO.getPotvrda())){
            return new ResponseEntity<>("Sifra i potvrda se ne poklapaju ",HttpStatus.BAD_REQUEST);
        }
        userService.changePassword(sifraDTO.getTrenutnaSifra(),sifraDTO.getNovaSifra(),id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
