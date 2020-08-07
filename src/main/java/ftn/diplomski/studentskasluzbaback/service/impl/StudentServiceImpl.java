package ftn.diplomski.studentskasluzbaback.service.impl;

import ftn.diplomski.studentskasluzbaback.dto.StudentDTO;
import ftn.diplomski.studentskasluzbaback.model.SkolskaGodina;
import ftn.diplomski.studentskasluzbaback.model.Smer;
import ftn.diplomski.studentskasluzbaback.model.Student;
import ftn.diplomski.studentskasluzbaback.repository.SmerRepository;
import ftn.diplomski.studentskasluzbaback.repository.StudentRepository;
import ftn.diplomski.studentskasluzbaback.service.SkolskaGodinaService;
import ftn.diplomski.studentskasluzbaback.service.SmerService;
import ftn.diplomski.studentskasluzbaback.service.StudentService;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SmerService smerService;

    @Autowired
    private SkolskaGodinaService skolskaGodinaService;

    @Override
    public ArrayList<StudentDTO> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        ArrayList<StudentDTO> studentDTOS = new ArrayList<>();

        for(Student student:students){
            studentDTOS.add(new StudentDTO(student));
        }

        return studentDTOS;
    }

    @Override
    public StudentDTO saveNewStudent(StudentDTO studentDTO) {

        Smer smer = smerService.findSmer(studentDTO.getSmer().getId());

        Student student = new Student();

        student.setName(studentDTO.getName());
        student.setSurname(studentDTO.getSurname());
        student.setEmail(studentDTO.getEmail());
        student.setRole("ROLE_STUDENT");
        student.setSmer(smer);


        String password = generateRandomPassword();


        // work factor of bcrypt
        int strength = 10;
        // secureRandom() is salt generator
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(strength, new SecureRandom());
        student.setPassword(bCryptPasswordEncoder.encode(password));

        SkolskaGodina skolskaGodina = skolskaGodinaService.getTrenutnaSkolskaGodina();

        int brojStudenta = getStudentePoSmeruiGodini(smer,skolskaGodina).size()+1;

        String brIndexa = smer.getSkracenica() +brojStudenta +"-"+skolskaGodina.getKrajGodine().getYear();

        student.setGodinaUpisa(skolskaGodina);
        student.setBrojIndexa(brIndexa);

        Student saved = studentRepository.save(student);
        studentDTO.setId(saved.getId());
        studentDTO.setBrojIndexa(saved.getBrojIndexa());


        return studentDTO;
    }

    @Override
    public String checkNewStudent(StudentDTO profesorDTO) {
        return null;
    }

    @Override
    public Student findStudent(Long id) {
        return null;
    }

    @Override
    public ArrayList<Student> getStudentePoSmeruiGodini(Smer smer, SkolskaGodina skolskaGodina) {
        return (ArrayList<Student>) studentRepository.findAllBySmerAndGodinaUpisa(smer,skolskaGodina);
    }


    private String generateRandomPassword(){
        int length = 15;
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
        return generatedString;
    }
}
