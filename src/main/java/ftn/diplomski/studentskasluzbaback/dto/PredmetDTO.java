package ftn.diplomski.studentskasluzbaback.dto;

import ftn.diplomski.studentskasluzbaback.model.Predmet;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class PredmetDTO {

    private Long id;

    private String naziv;

    private String kategorija;

    private Integer brojPredavanjaUGodini;

    private Integer brojESBPBodova;

    public PredmetDTO() {
    }

    public PredmetDTO(Long id, String naziv, String kategorija, Integer brojPredavanjaUGodini, Integer brojESBPBodova) {
        this.id = id;
        this.naziv = naziv;
        this.kategorija = kategorija;
        this.brojPredavanjaUGodini = brojPredavanjaUGodini;
        this.brojESBPBodova = brojESBPBodova;
    }

    public PredmetDTO(Predmet predmet) {
        System.out.println(predmet.getId());
        this.id = predmet.getId();
        System.out.println(predmet.getNaziv());
        this.naziv = predmet.getNaziv();
        System.out.println(predmet.getKategorija().getFieldDescription());
        this.kategorija = predmet.getKategorija().getFieldDescription();
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

    public String getKategorija() {
        return kategorija;
    }

    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }

    public Integer getBrojPredavanjaUGodini() {
        return brojPredavanjaUGodini;
    }

    public void setBrojPredavanjaUGodini(Integer brojPredavanjaUGodini) {
        this.brojPredavanjaUGodini = brojPredavanjaUGodini;
    }

    public Integer getBrojESBPBodova() {
        return brojESBPBodova;
    }

    public void setBrojESBPBodova(Integer brojESBPBodova) {
        this.brojESBPBodova = brojESBPBodova;
    }
}
