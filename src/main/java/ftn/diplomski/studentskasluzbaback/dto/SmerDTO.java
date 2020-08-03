package ftn.diplomski.studentskasluzbaback.dto;

import ftn.diplomski.studentskasluzbaback.enumeration.ObrazovnoPolje;
import ftn.diplomski.studentskasluzbaback.model.Smer;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class SmerDTO {

    private Long id;

    private String naziv;

    private String skracenica;

    private Integer trajanjeUSemestrima;

    private String obrazovnoPolje;

    private String nazivDiplome;

    public SmerDTO() {
    }

    public SmerDTO(Long id, String naziv, String skracenica, Integer trajanjeUSemestrima, String obrazovnoPolje, String nazivDiplome) {
        this.id = id;
        this.naziv = naziv;
        this.skracenica = skracenica;
        this.trajanjeUSemestrima = trajanjeUSemestrima;
        this.obrazovnoPolje = obrazovnoPolje;
        this.nazivDiplome = nazivDiplome;
    }

    public SmerDTO(Smer smer) {
        this.id = smer.getId();
        this.naziv = smer.getNaziv();
        this.skracenica = smer.getSkracenica();
        this.trajanjeUSemestrima = smer.getTrajanjeUSemestrima();
        this.obrazovnoPolje = smer.getObrazovnoPolje().getFieldDescription();
        this.nazivDiplome = smer.getNazivDiplome();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getSkracenica() {
        return skracenica;
    }

    public void setSkracenica(String skracenica) {
        this.skracenica = skracenica;
    }

    public Integer getTrajanjeUSemestrima() {
        return trajanjeUSemestrima;
    }

    public void setTrajanjeUSemestrima(Integer trajanjeUSemestrima) {
        this.trajanjeUSemestrima = trajanjeUSemestrima;
    }

    public String getObrazovnoPolje() {
        return obrazovnoPolje;
    }

    public void setObrazovnoPolje(String obrazovnoPolje) {
        this.obrazovnoPolje = obrazovnoPolje;
    }

    public String getNazivDiplome() {
        return nazivDiplome;
    }

    public void setNazivDiplome(String nazivDiplome) {
        this.nazivDiplome = nazivDiplome;
    }
}
