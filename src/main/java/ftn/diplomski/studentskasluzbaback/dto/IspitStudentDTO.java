package ftn.diplomski.studentskasluzbaback.dto;

import ftn.diplomski.studentskasluzbaback.model.Ispit;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class IspitStudentDTO {

    private Long id;

    private String rok;

    private String datum;

    private String mestoOdrzavanja;

    private String nazivPredmeta;

    private String sifra;

    private String vremeOdrzavanja;

    private boolean odjava;

    public IspitStudentDTO(Ispit ispit) {
        this.id = ispit.getId();
        this.rok = ispit.getRok().getFieldDescription();
        this.datum = ispit.getDatum().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.mestoOdrzavanja = ispit.getMestoOdrzavanja();
        this.nazivPredmeta = ispit.getSmerPredmet().getPredmet().getNaziv();
        this.sifra = ispit.getSmerPredmet().getSifraStudijskogPrograma();
        if (ispit.getVremeOdrzavanja() != null) {
            this.vremeOdrzavanja = ispit.getVremeOdrzavanja().format(DateTimeFormatter.ofPattern("HH:mm"));
        }else{
            this.vremeOdrzavanja="";
        }

        if(ispit.getDatum().isAfter(LocalDate.now().minusDays(3))) {
            this.odjava = true;
        }
        else {
            this.odjava = false;
        }
    }

    public IspitStudentDTO(Long id, String rok, String datum, String mestoOdrzavanja, String nazivPredmeta, String sifra, String vremeOdrzavanja) {
        this.id = id;
        this.rok = rok;
        this.datum = datum;
        this.mestoOdrzavanja = mestoOdrzavanja;
        this.nazivPredmeta = nazivPredmeta;
        this.sifra = sifra;
        this.vremeOdrzavanja = vremeOdrzavanja;
    }

    public IspitStudentDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRok() {
        return rok;
    }

    public void setRok(String rok) {
        this.rok = rok;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getMestoOdrzavanja() {
        return mestoOdrzavanja;
    }

    public void setMestoOdrzavanja(String mestoOdrzavanja) {
        this.mestoOdrzavanja = mestoOdrzavanja;
    }

    public String getNazivPredmeta() {
        return nazivPredmeta;
    }

    public void setNazivPredmeta(String nazivPredmeta) {
        this.nazivPredmeta = nazivPredmeta;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public String getVremeOdrzavanja() {
        return vremeOdrzavanja;
    }

    public void setVremeOdrzavanja(String vremeOdrzavanja) {
        this.vremeOdrzavanja = vremeOdrzavanja;
    }

    public boolean isOdjava() {
        return odjava;
    }

    public void setOdjava(boolean odjava) {
        this.odjava = odjava;
    }
}
