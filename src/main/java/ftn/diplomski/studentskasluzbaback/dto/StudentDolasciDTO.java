package ftn.diplomski.studentskasluzbaback.dto;

import ftn.diplomski.studentskasluzbaback.model.Ocena;
import ftn.diplomski.studentskasluzbaback.model.Student;

public class StudentDolasciDTO {


    private Long id;
    private String name;
    private String surname;
    private String brojIndexa;
    private int brojDolazaka;

    public StudentDolasciDTO() {
    }

    public StudentDolasciDTO(Long id, String name, String surname, String brojIndexa, int brojDolazaka) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.brojIndexa = brojIndexa;
        this.brojDolazaka = brojDolazaka;
    }

    public StudentDolasciDTO(Ocena ocena) {
        this.id = ocena.getStudent().getId();
        this.name = ocena.getStudent().getName();
        this.surname = ocena.getStudent().getSurname();
        this.brojIndexa = ocena.getStudent().getBrojIndexa();
        this.brojDolazaka = ocena.getBrojDolazakaNaPredavanja();
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

    public String getBrojIndexa() {
        return brojIndexa;
    }

    public void setBrojIndexa(String brojIndexa) {
        this.brojIndexa = brojIndexa;
    }

    public int getBrojDolazaka() {
        return brojDolazaka;
    }

    public void setBrojDolazaka(int brojDolazaka) {
        this.brojDolazaka = brojDolazaka;
    }
}
