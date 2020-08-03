package ftn.diplomski.studentskasluzbaback.dto;

import ftn.diplomski.studentskasluzbaback.model.Profesor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ProfesorDTO {

    private Long id;

    private String name;

    private String surname;

    private String email;

    private String sifraProfesora;

    private String sifra;

    public ProfesorDTO(Profesor profesor) {
        this.id = profesor.getId();
        this.name = profesor.getName();
        this.surname = profesor.getSurname();
        this.email = profesor.getEmail();
        this.sifraProfesora = profesor.getSifraProfesora();
    }

    public ProfesorDTO() {
    }

    public ProfesorDTO(Long id, String name, String surname, String email, String sifraProfesora) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.sifraProfesora = sifraProfesora;
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

    public String getSifraProfesora() {
        return sifraProfesora;
    }

    public void setSifraProfesora(String sifraProfesora) {
        this.sifraProfesora = sifraProfesora;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }
}
