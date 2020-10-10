package ftn.diplomski.studentskasluzbaback.service.impl;

import ftn.diplomski.studentskasluzbaback.dto.IspitProfesorDTO;
import ftn.diplomski.studentskasluzbaback.dto.ProfesorDTO;
import ftn.diplomski.studentskasluzbaback.dto.SmerPredmetDTO;
import ftn.diplomski.studentskasluzbaback.model.*;
import ftn.diplomski.studentskasluzbaback.repository.ProfesorRepository;
import ftn.diplomski.studentskasluzbaback.service.ProfesorService;
import ftn.diplomski.studentskasluzbaback.service.RoleService;
import ftn.diplomski.studentskasluzbaback.service.SmerPredmetService;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.security.SecureRandom;
import java.sql.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProfesorServiceImpl implements ProfesorService {

    @Autowired
    private ProfesorRepository profesorRepository;

    @Autowired
    private SmerPredmetService smerPredmetService;

    @Autowired
    private RoleService roleService;

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

        List<Role> role = roleService.findByName("ROLE_PROFESOR");
        profesor.setRoles(role);
        String password = generateRandomPassword();

        profesorDTO.setSifra(password);

        // work factor of bcrypt
        int strength = 10;
        // secureRandom() is salt generator
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(strength, new SecureRandom());
        profesor.setPassword(bCryptPasswordEncoder.encode(password));

        Profesor saved = profesorRepository.save(profesor);
        profesorDTO.setId(saved.getId());
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

    @Override
    public Profesor findProfesor(Long id) {
        return profesorRepository.findById(id).orElse(null);
    }

    @Override
    public ProfesorDTO deleteProfesor(Long id) {
        Profesor profesor = profesorRepository.findById(id).orElse(null);
        profesorRepository.delete(profesor);
        return new ProfesorDTO(profesor);
    }

    @Override
    public String proveriDaLiProfesorMozeBitiObrisan(Long id) {
        Profesor profesor = profesorRepository.findById(id).orElse(null);

        if(profesor.getPredmeti() != null) {
            if (profesor.getPredmeti().size() != 0) {
                return "Profesor koji predaje ne moze biti obrisan!";
            }
        }
        return null;
    }

    @Override
    public ProfesorDTO updateProfesor(ProfesorDTO profesorDTO) {
        Profesor profesor = findProfesor(profesorDTO.getId());

        profesor.setEmail(profesorDTO.getEmail());
        profesor.setSifraProfesora(profesorDTO.getSifraProfesora());
        profesor.setName(profesorDTO.getName());
        profesor.setSurname(profesorDTO.getSurname());
        profesorRepository.save(profesor);

        return profesorDTO;
    }

    @Override
    public ArrayList<SmerPredmetDTO> getStudijskeProgrameKojeUlogovanProfesorPredaje() {
        Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
        String email = currentUser.getName();
        Profesor profesor = profesorRepository.findProfesorByEmail(email);
        ArrayList<SmerPredmetDTO> smerPredmetDTOS = new ArrayList<>();

        for(SmerPredmet smerPredmet:profesor.getPredmeti()){
            smerPredmetDTOS.add(new SmerPredmetDTO(smerPredmet));
        }
        return smerPredmetDTOS;
    }

    @Override
    public ArrayList<IspitProfesorDTO> getIspiteKodUlogovanogProfesora() {
        Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
        String email = currentUser.getName();
        Profesor profesor = profesorRepository.findProfesorByEmail(email);
        ArrayList<IspitProfesorDTO> ispiti = new ArrayList<>();

        for(SmerPredmet smerPredmet:profesor.getPredmeti()){
            for(Ispit ispit:smerPredmet.getIspiti()) {
                ispiti.add(new IspitProfesorDTO(ispit));
            }
        }
        return ispiti;
    }

    @Override
    public ArrayList<IspitProfesorDTO> getIspitiOdProfesoraZaUnosOcene() {
        Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
        String email = currentUser.getName();
        Profesor profesor = profesorRepository.findProfesorByEmail(email);
        ArrayList<IspitProfesorDTO> ispiti = new ArrayList<>();

        LocalDate minDate = LocalDate.now().minusDays(20);

        for(SmerPredmet smerPredmet:profesor.getPredmeti()){
            for(Ispit ispit:smerPredmet.getIspiti()) {
                if(ispit.getProfesor().equals(profesor)) {
                    if (!ispit.isUneseniRezultati()) {
                        if (ispit.getDatum().isAfter(minDate) && ispit.getDatum().isBefore(LocalDate.now())) {
                            ispiti.add(new IspitProfesorDTO(ispit));
                        }
                    }
                }
            }
        }
        return ispiti;
    }

    @Override
    public ArrayList<SmerPredmetDTO> getPredmetiOdProfesora() {
        Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
        String email = currentUser.getName();
        Profesor profesor = profesorRepository.findProfesorByEmail(email);
        ArrayList<SmerPredmetDTO> smerPredmetDTOS = new ArrayList<>();

        for(SmerPredmet smerPredmet : profesor.getPredmeti()){
            smerPredmetDTOS.add(new SmerPredmetDTO(smerPredmet));
        }

        return smerPredmetDTOS;
    }

    @Override
    public ProfesorDTO getProfesor(Long id) {
        return new ProfesorDTO(profesorRepository.getOne(id));
    }

    @Override
    public String checkUpdateProfesor(ProfesorDTO profesorDTO) {

        Profesor profesor = profesorRepository.findProfesorByEmail(profesorDTO.getEmail());
        if(profesor != null && !profesor.getId().equals(profesorDTO.getId())){
            return "Profesor sa tim emailom vec postoji!";
        }

        profesor = profesorRepository.findProfesorBySifraProfesora(profesorDTO.getSifraProfesora());
        if(profesor != null && !profesor.getId().equals(profesorDTO.getId())){
            return "Profesor sa tom sifrom vec postoji!";
        }
        return null;
    }

    @Override
    public Profesor save(Profesor profesor) {
        return profesorRepository.save(profesor);
    }


    private String generateRandomPassword(){
        int length = 15;
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
        return generatedString;
    }
}
