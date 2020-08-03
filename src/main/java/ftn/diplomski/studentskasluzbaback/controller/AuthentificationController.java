package ftn.diplomski.studentskasluzbaback.controller;


import ftn.diplomski.studentskasluzbaback.dto.UserTokenState;
import ftn.diplomski.studentskasluzbaback.model.User;
import ftn.diplomski.studentskasluzbaback.security.TokenUtils;
import ftn.diplomski.studentskasluzbaback.security.auth.JwtAuthenticationRequest;
import ftn.diplomski.studentskasluzbaback.service.UserService;
import ftn.diplomski.studentskasluzbaback.service.impl.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.regex.Pattern;

@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthentificationController {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    TokenUtils tokenUtils;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest, HttpServletResponse response) throws AuthenticationException, IOException {
        System.out.println("Pogodio login" );
        if(!checkMail(authenticationRequest.getEmail())) {
            return new ResponseEntity<>("Invalid email", HttpStatus.BAD_REQUEST);
        }

        User user = userService.getUserByEmail(authenticationRequest.getEmail());

        if(user!=null) {

            if(org.springframework.security.crypto.bcrypt.BCrypt.checkpw(authenticationRequest.getPassword(), user.getPassword())){
                //System.out.println("Logged in successfully, email: " + user.getEmail());
            }else{
                return new ResponseEntity<>("Invalid password",HttpStatus.BAD_REQUEST);
            }

            if(!user.isEnabled())
            {
                return new ResponseEntity<>("User not activated",HttpStatus.EXPECTATION_FAILED);
            }

            final Authentication authentication = manager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);

            Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>)
                    SecurityContextHolder.getContext().getAuthentication().getAuthorities();

            //ispis permisija
            /*for (GrantedAuthority authority : authorities) {
                System.out.println("Authority: " + authority.getAuthority());
            }*/

            User user1 = (User) authentication.getPrincipal();
            String jwt = tokenUtils.generateToken(user1.getEmail());
            int expiresIn = tokenUtils.getExpiredIn();

            System.out.println(jwt);
            System.out.println(user.getEmail());

            return ResponseEntity.ok(new UserTokenState(jwt, expiresIn));

        }
        else
        {
            return new ResponseEntity<>("User doesn't exist in the system",HttpStatus.NOT_FOUND);
        }

    }

    public boolean checkMail(String mail) {

        if(!Pattern.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$", mail)){
            return false;
        }

        if(mail.isEmpty()) {
            return false;
        }

        return true;
    }
}
