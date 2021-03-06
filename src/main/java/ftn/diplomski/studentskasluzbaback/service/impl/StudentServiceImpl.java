package ftn.diplomski.studentskasluzbaback.service.impl;

import ftn.diplomski.studentskasluzbaback.dto.IspitStudentDTO;
import ftn.diplomski.studentskasluzbaback.dto.OcenaDTO;
import ftn.diplomski.studentskasluzbaback.dto.StudentDTO;
import ftn.diplomski.studentskasluzbaback.model.*;
import ftn.diplomski.studentskasluzbaback.repository.SmerRepository;
import ftn.diplomski.studentskasluzbaback.repository.StudentRepository;
import ftn.diplomski.studentskasluzbaback.service.*;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final Integer daniOdPrijaveIspita = 10; //koristi se za prikaz prijavljenih ispita kod studenta, koliko dana je proslo od zavrsetka ispita a da student moze da vidi da je taj predmet prijavio

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SmerService smerService;

    @Autowired
    private SkolskaGodinaService skolskaGodinaService;

    @Autowired
    private IspitService ispitService;

    @Autowired
    private OcenaService ocenaService;

    @Autowired
    private SmerPredmetService smerPredmetService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private RoleService roleService;

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

        //TODO DODELI ROLU
        Smer smer = smerService.findSmer(studentDTO.getSmer().getId());

        Student student = new Student();

        student.setName(studentDTO.getName());
        student.setSurname(studentDTO.getSurname());
        student.setEmail(studentDTO.getEmail());
        student.setRole("ROLE_STUDENT");
        student.setSmer(smer);
        student.setEnabled(true);
        student.setSemestar(1);
        String password = generateRandomPassword();
        List<Role> role = roleService.findByName("ROLE_STUDENT");
        student.setRoles(role);

        // work factor of bcrypt
        int strength = 10;
        // secureRandom() is salt generator
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(strength, new SecureRandom());
        student.setPassword(bCryptPasswordEncoder.encode(password));

        SkolskaGodina skolskaGodina = skolskaGodinaService.getTrenutnaSkolskaGodina();

        int brojStudenta = getStudentePoSmeruiGodini(smer,skolskaGodina).size()+1;
        String brIndexa;
        if(brojStudenta <10){
            brIndexa = smer.getSkracenica().toLowerCase()+"0" +brojStudenta +"-"+skolskaGodina.getKrajGodine().getYear();
        }else{
            brIndexa = smer.getSkracenica().toLowerCase() +brojStudenta +"-"+skolskaGodina.getKrajGodine().getYear();
        }



        student.setGodinaUpisa(skolskaGodina);
        student.setBrojIndexa(brIndexa);

        Student saved = studentRepository.save(student);

        ocenaService.kreirajOcene(student,1);

        studentDTO.setId(saved.getId());
        studentDTO.setBrojIndexa(saved.getBrojIndexa());

        //posalji mail studentu
        emailService.otvorenNalogStudentu(student,password);

        return studentDTO;
    }

    @Override
    public String checkNewStudent(StudentDTO profesorDTO) {
        return null;
    }

    @Override
    public String checkPrijavaIspita(IspitStudentDTO ispitStudentDTO) {
        Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
        String email = currentUser.getName();
        Student student = studentRepository.findByEmail(email);
        Ispit ispit = ispitService.getOne(ispitStudentDTO.getId());

        if(student.getPrijavljeniIspiti().contains(ispit)){
            return "Ispit je vec prijavljen!";
        }

        return null;
    }

    @Override
    public ArrayList<IspitStudentDTO> getPrijavljeniIsptiOdStudenta() {
        Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
        String email = currentUser.getName();
        Student student = studentRepository.findByEmail(email);
        ArrayList<IspitStudentDTO> ret = new ArrayList<>();
        for(Ispit ispit:student.getPrijavljeniIspiti()){
            if(ispit.getDatum().isAfter(LocalDate.now().minusDays(daniOdPrijaveIspita))){
                ret.add(new IspitStudentDTO(ispit));
            }
        }
        return ret;
    }

    @Override
    public Integer ocekivaniSemestarZaStudenta(Long id) {
        Student student = studentRepository.getOne(id);
        SkolskaGodina skolskaGodina = skolskaGodinaService.getTrenutnaSkolskaGodina();
        int semestar = (skolskaGodina.getPocetakGodine().getYear() -student.getGodinaUpisa().getPocetakGodine().getYear())*2;
        if(skolskaGodina.getPocetakGodine().getYear() == LocalDate.now().getYear()){
            semestar+=1;
        }else{
            if(LocalDate.now().getMonthValue() <2){
                semestar+=1;
            }else{
                semestar+=2;
            }
        }

        return semestar;
    }

    @Override
    public Student ulogovanStudent() {

        Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
        String email = currentUser.getName();
        Student student = studentRepository.findByEmail(email);
        return student;
    }

    @Override
    public void overiSemestarUlogovan() {
        Student student = ulogovanStudent();
        student.setSemestar(student.getSemestar()+1);
        ocenaService.kreirajOcene(student,student.getSemestar());
        studentRepository.save(student);
    }

    @Override
    public ArrayList<OcenaDTO> getOceneUlogovanogStudenta() {
        Student student = ulogovanStudent();
        ArrayList<OcenaDTO> ocene = new ArrayList<>();
        for(Ocena ocena:student.getOcene()){
            ocene.add(new OcenaDTO(ocena));
        }

        return ocene;
    }

    @Override
    public ArrayList<Student> findAll() {
        return (ArrayList<Student>) studentRepository.findAll();
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    //TODO
    @Override
    public String checkUpdateStudent(StudentDTO studentDTO) {
        return null;
    }

    @Override
    public void deleteStudent(Long id) {
        Student student = studentRepository.getOne(id);
        studentRepository.delete(student);
    }

    @Override
    public StudentDTO updateStudent(StudentDTO studentDTO) {
        Student student = studentRepository.getOne(studentDTO.getId());
        Smer smer = smerService.findSmer(studentDTO.getSmer().getId());
        student.setSmer(smer);
        student.setEmail(studentDTO.getEmail());
        student.setName(studentDTO.getName());
        student.setSurname(studentDTO.getSurname());

        studentRepository.save(student);
        return studentDTO;
    }

    @Override
    public ArrayList<StudentDTO> getAllStudentsPage(int page, int size) {
        Pageable pagable = PageRequest.of(page,size);
        Page<Student> students = studentRepository.findAll(pagable);
        ArrayList<StudentDTO> studentDTOS = new ArrayList<>();

        for(Student student:students){
            studentDTOS.add(new StudentDTO(student));
        }

        return studentDTOS;
    }

    @Override
    public ArrayList<StudentDTO> searchStudentsPagable(String name, String surname, String email, String brojIndexa, int page, int size) {
        if(name.equals("null")){
            name ="";
        }
        if(surname.equals("null")){
            surname ="";
        }
        if(email.equals("null")){
            email ="";
        }
        if(brojIndexa.equals("null")){
            brojIndexa ="";
        }
        Pageable pagable = PageRequest.of(page,size);
        Page<Student> students = studentRepository.search(name,surname,email,brojIndexa,pagable);//.findByNameLikeIgnoreCaseAndSurnameLikeIgnoreCaseAndEmailLikeIgnoreCaseAndBrojIndexaLikeIgnoreCase(name,surname,email,brojIndexa,pagable);
        ArrayList<StudentDTO> studentDTOS = new ArrayList<>();

        for(Student student:students){
            studentDTOS.add(new StudentDTO(student));
        }

        return studentDTOS;
    }

    @Override
    public ArrayList<StudentDTO> searchStudentsAll(String name, String surname, String email, String brojIndexa) {

        if(name.equals("null")){
            name ="";
        }
        if(surname.equals("null")){
            surname ="";
        }
        if(email.equals("null")){
            email ="";
        }
        if(brojIndexa.equals("null")){
            brojIndexa ="";
        }
        List<Student> students = studentRepository.searchAll(name,surname,email,brojIndexa);//.findByNameLikeIgnoreCaseAndSurnameLikeIgnoreCaseAndEmailLikeIgnoreCaseAndBrojIndexaLikeIgnoreCase(name,surname,email,brojIndexa,pagable);
        ArrayList<StudentDTO> studentDTOS = new ArrayList<>();

        for(Student student:students){
            studentDTOS.add(new StudentDTO(student));
        }

        return studentDTOS;

    }

    @Override
    public Student findStudent(Long id) {
        return studentRepository.getOne(id);
    }

    @Override
    public ArrayList<Student> getStudentePoSmeruiGodini(Smer smer, SkolskaGodina skolskaGodina) {
        return (ArrayList<Student>) studentRepository.findAllBySmerAndGodinaUpisaOrderByBrojIndexa(smer,skolskaGodina);
    }

    @Override
    public ArrayList<IspitStudentDTO> getTrenutneIspiteOdUlogvanog() {
        Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
        String email = currentUser.getName();
        Student student = studentRepository.findByEmail(email);

        ArrayList<Ispit> ispiti = smerService.getTrenutneIspiteSmera(student.getSmer().getId());
        ArrayList<IspitStudentDTO> ret = new ArrayList<>();

        for(Ispit ispit: ispiti){
            SmerPredmet smerPredmet =smerPredmetService.findOne(ispit.getSmerPredmet().getId());
            Ocena ocena = ocenaService.pronadjiOcenuOdStudentaZaPredmet(student,smerPredmet);
            if(ocena != null){
                if(ocena.getDatumPolaganja() != null){
                    //taj ispit je vec polozen
                    continue;
                }
            }
            if(student.getPrijavljeniIspiti().contains(ispit)){
                continue;
            }
            if(ispit.getSmerPredmet().getSemestar() > student.getSemestar()) {
                continue;
            }
            ret.add(new IspitStudentDTO(ispit));
        }

        return ret;
    }

    @Override
    public IspitStudentDTO prijaviIspit(IspitStudentDTO ispitStudentDTO) {
        Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
        String email = currentUser.getName();
        Student student = studentRepository.findByEmail(email);
        Ispit ispit = ispitService.getOne(ispitStudentDTO.getId());
        student.getPrijavljeniIspiti().add(ispit);
        studentRepository.save(student);
        return ispitStudentDTO;
    }

    @Override
    public IspitStudentDTO odjaviIspit(IspitStudentDTO ispitStudentDTO) {
        Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
        String email = currentUser.getName();
        Student student = studentRepository.findByEmail(email);
        Ispit ispit = ispitService.getOne(ispitStudentDTO.getId());
        student.getPrijavljeniIspiti().remove(ispit);
        studentRepository.save(student);
        return ispitStudentDTO;
    }


    private String generateRandomPassword(){
        int length = 15;
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
        return generatedString;
    }
}
