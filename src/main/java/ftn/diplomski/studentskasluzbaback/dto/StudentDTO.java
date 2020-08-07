package ftn.diplomski.studentskasluzbaback.dto;

import ftn.diplomski.studentskasluzbaback.model.Student;

public class StudentDTO {
    private Long id;

    private SmerDTO smer;

    private String name;

    private String surname;

    private String email;

    private String brojIndexa;

    public StudentDTO(Student student){
        this.id = student.getId();
        this.smer = new SmerDTO(student.getSmer());
        this.name = student.getName();
        this.surname=student.getSurname();
        this.email = student.getEmail();
        this.brojIndexa=student.getBrojIndexa();


    }

    public StudentDTO() {
    }

    public StudentDTO(Long id, SmerDTO smer, String name, String surname, String email, String brojIndexa) {
        this.id = id;
        this.smer = smer;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.brojIndexa = brojIndexa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public SmerDTO getSmer() {
        return smer;
    }

    public void setSmer(SmerDTO smer) {
        this.smer = smer;
    }

    public String getBrojIndexa() {
        return brojIndexa;
    }

    public void setBrojIndexa(String brojIndexa) {
        this.brojIndexa = brojIndexa;
    }
}
