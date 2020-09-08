package ftn.diplomski.studentskasluzbaback.service.impl;

import ftn.diplomski.studentskasluzbaback.model.User;
import ftn.diplomski.studentskasluzbaback.repository.UserRepository;
import ftn.diplomski.studentskasluzbaback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class UserServiceImpl implements UserService {

    @Lazy
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void changePassword(String oldPassword, String newPassword,Long id) {

        User user = userRepository.getOne(id);
        String email = user.getEmail();

        if (authenticationManager != null) {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, oldPassword));
        } else {
            return;
        }


        // work factor of bcrypt
        int strength = 10;
        // secureRandom() is salt generator
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(strength, new SecureRandom());
        user.setPassword(bCryptPasswordEncoder.encode(newPassword));
        userRepository.save(user);

    }
}
