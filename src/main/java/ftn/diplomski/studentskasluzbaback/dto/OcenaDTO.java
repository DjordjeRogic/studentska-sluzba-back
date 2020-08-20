package ftn.diplomski.studentskasluzbaback.dto;

import ftn.diplomski.studentskasluzbaback.model.Ocena;
import ftn.diplomski.studentskasluzbaback.model.SmerPredmet;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OcenaDTO {

    private Long id;

    private boolean polozio;

    private String datumPolaganja;

    private boolean potpis;

    private Integer brojDolazakaNaPredavanja;

    private Integer ocena;

    private String nazivPredmeta;

    private String sifraPredmeta;

    private double brojaBodova;

    private int semestar;

    public OcenaDTO() {
    }


    public OcenaDTO(Long id, boolean polozio, String datumPolaganja, boolean potpis, Integer brojDolazakaNaPredavanja, Integer ocena, String nazivPredmeta, String sifraPredmeta, double brojaBodova, int semestar) {
        this.id = id;
        this.polozio = polozio;
        this.datumPolaganja = datumPolaganja;
        this.potpis = potpis;
        this.brojDolazakaNaPredavanja = brojDolazakaNaPredavanja;
        this.ocena = ocena;
        this.nazivPredmeta = nazivPredmeta;
        this.sifraPredmeta = sifraPredmeta;
        this.brojaBodova = brojaBodova;
        this.semestar = semestar;
    }

    public OcenaDTO(Ocena ocena) {
        this.id = ocena.getId();
        this.polozio = ocena.isPolozio();
        if (ocena.getDatumPolaganja() != null) {
            this.datumPolaganja = ocena.getDatumPolaganja().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        }else{
            this.datumPolaganja="";
        }
        this.potpis = ocena.isPotpis();
        this.brojDolazakaNaPredavanja = ocena.getBrojDolazakaNaPredavanja();
        this.ocena = ocena.getOcena();
        this.nazivPredmeta = ocena.getSmerPredmet().getPredmet().getNaziv();
        this.sifraPredmeta = ocena.getSmerPredmet().getSifraStudijskogPrograma();
        this.brojaBodova = ocena.getBrojBodova();
        this.semestar = ocena.getSmerPredmet().getSemestar();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isPolozio() {
        return polozio;
    }

    public void setPolozio(boolean polozio) {
        this.polozio = polozio;
    }

    public String getDatumPolaganja() {
        return datumPolaganja;
    }

    public void setDatumPolaganja(String datumPolaganja) {
        this.datumPolaganja = datumPolaganja;
    }

    public double getBrojaBodova() {
        return brojaBodova;
    }

    public void setBrojaBodova(double brojaBodova) {
        this.brojaBodova = brojaBodova;
    }

    public boolean isPotpis() {
        return potpis;
    }

    public void setPotpis(boolean potpis) {
        this.potpis = potpis;
    }

    public Integer getBrojDolazakaNaPredavanja() {
        return brojDolazakaNaPredavanja;
    }

    public void setBrojDolazakaNaPredavanja(Integer brojDolazakaNaPredavanja) {
        this.brojDolazakaNaPredavanja = brojDolazakaNaPredavanja;
    }

    public Integer getOcena() {
        return ocena;
    }

    public void setOcena(Integer ocena) {
        this.ocena = ocena;
    }

    public String getNazivPredmeta() {
        return nazivPredmeta;
    }

    public void setNazivPredmeta(String nazivPredmeta) {
        this.nazivPredmeta = nazivPredmeta;
    }

    public String getSifraPredmeta() {
        return sifraPredmeta;
    }

    public void setSifraPredmeta(String sifraPredmeta) {
        this.sifraPredmeta = sifraPredmeta;
    }

    public int getSemestar() {
        return semestar;
    }

    public void setSemestar(int semestar) {
        this.semestar = semestar;
    }
}