package ftn.diplomski.studentskasluzbaback.dto;

import ftn.diplomski.studentskasluzbaback.enumeration.IspitniRok;
import ftn.diplomski.studentskasluzbaback.model.Ispit;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class IspitDTO {

    private Long id;

    private String rok;

    private String datum;

    private String mestoOdrzavanja;

    private Long programId;

    private String vremeOdrzavanja;

    public IspitDTO() {
    }


    public IspitDTO(Long id, String rok, String datum, String mestoOdrzavanja, Long programId, String vremeOdrzavanja) {
        this.id = id;
        this.rok = rok;
        this.datum = datum;
        this.mestoOdrzavanja = mestoOdrzavanja;
        this.programId = programId;
        this.vremeOdrzavanja=vremeOdrzavanja;
    }

    public IspitDTO(Ispit ispit) {
        this.id = ispit.getId();
        System.out.println(ispit.getRok().getFieldDescription());
        System.out.println(ispit.getRok());
        this.rok = ispit.getRok().getFieldDescription();
        this.datum = ispit.getDatum().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.mestoOdrzavanja = ispit.getMestoOdrzavanja();
        this.programId = ispit.getSmerPredmet().getId();
        if (ispit.getVremeOdrzavanja() != null) {
            this.vremeOdrzavanja = ispit.getVremeOdrzavanja().format(DateTimeFormatter.ofPattern("HH:mm"));
        }else{
            this.vremeOdrzavanja="";
        }
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

    public Long getProgramId() {
        return programId;
    }

    public void setProgramId(Long programId) {
        this.programId = programId;
    }

    public String getVremeOdrzavanja() {
        return vremeOdrzavanja;
    }

    public void setVremeOdrzavanja(String vremeOdrzavanja) {
        this.vremeOdrzavanja = vremeOdrzavanja;
    }
}
