package ftn.diplomski.studentskasluzbaback.service.impl;

import ftn.diplomski.studentskasluzbaback.dto.ProfesorDTO;
import ftn.diplomski.studentskasluzbaback.model.Profesor;
import ftn.diplomski.studentskasluzbaback.repository.ProfesorRepository;
import ftn.diplomski.studentskasluzbaback.service.ProfesorService;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProfesorServiceImpl implements ProfesorService {

    @Autowired
    private ProfesorRepository profesorRepository;

    @Override
    public ArrayList<ProfesorDTO> getAllProfesors() {
        List<Profesor> profesorList =  profesorRepository.findAll();
        ArrayList<ProfesorDTO> profesorDTOArrayList = new ArrayList<>();

        for(Profesor profesor:profesorList){
            profesorDTOArrayList.add(new ProfesorDTO(profesor));
        }

        return profesorDTOArrayList;
    }

    @Override
    public ProfesorDTO saveNewProfesor(ProfesorDTO profesorDTO) {

        Profesor profesor = new Profesor();

        profesor.setName(profesorDTO.getName());
        profesor.setSurname(profesorDTO.getSurname());
        profesor.setEmail(profesorDTO.getEmail());
        profesor.setSifraProfesora(profesorDTO.getSifraProfesora());
        profesor.setRole("ROLE_PROFESOR");


        String password = generateRandomPassword();

        profesorDTO.setSifra(password);

        // work factor of bcrypt
        int strength = 10;
        // secureRandom() is salt generator
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(strength, new SecureRandom());
        profesor.setPassword(bCryptPasswordEncoder.encode(password));

        profesorRepository.save(profesor);

        //TODO
        // Potencijalno slanje emaila profesoru koji je registrovan da zna da moze da se uloguje.
        // Takodje mozda ne bi bilo lose da mu se posalje sifra koja je generisana da ne mora da kontaktira admina

        return profesorDTO;
    }

    @Override
    public String checkNewProfesor(ProfesorDTO profesorDTO) {


        if(profesorRepository.findProfesorByEmail(profesorDTO.getEmail()) != null){
            return "Profesor sa tim emailom vec postoji!";
        }


        if(profesorRepository.findProfesorBySifraProfesora(profesorDTO.getSifraProfesora()) != null){
            return "Profesor sa tom sifrom vec postoji!";
        }

        return null;
    }


    private String generateRandomPassword(){
        int length = 15;
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
        return generatedString;
    }
}
