package ftn.diplomski.studentskasluzbaback.dto;

import ftn.diplomski.studentskasluzbaback.model.Predmet;
import ftn.diplomski.studentskasluzbaback.model.SmerPredmet;

public class SmerPredmetDTO {

    private  Long id;
    private SmerDTO smer;
    private PredmetDTO predmet;
    private ProfesorDTO profesor;
    private Integer semestar;
    private Integer brojPredavanjaUGodini;
    private Integer brojESBPBodova;
    private String sifraStudijskogPrograma;

    public SmerPredmetDTO() {
    }

    public SmerPredmetDTO(Long id,SmerDTO smer, PredmetDTO predmet, ProfesorDTO profesor, Integer semestar, Integer brojPredavanjaUGodini, Integer brojESBPBodova,String sifraStudijskogPrograma) {
        this.id = id;
        this.smer = smer;
        this.predmet = predmet;
        this.profesor = profesor;
        this.semestar = semestar;
        this.brojPredavanjaUGodini = brojPredavanjaUGodini;
        this.brojESBPBodova = brojESBPBodova;
        this.sifraStudijskogPrograma=sifraStudijskogPrograma;
    }

    public SmerPredmetDTO(SmerPredmet smerPredmet) {
        System.out.println("DTO SMERPREDMET");
        System.out.println(smerPredmet.getId());
        this.smer = new SmerDTO(smerPredmet.getSmer());
        System.out.println(smerPredmet.getSmer().getNaziv());
        this.predmet = new PredmetDTO(smerPredmet.getPredmet());
        System.out.println(smerPredmet.getPredmet().getNaziv());
        this.profesor = new ProfesorDTO(smerPredmet.getProfesor());
        System.out.println(smerPredmet.getProfesor().getName());
        this.semestar = smerPredmet.getSemestar();
        this.brojPredavanjaUGodini = smerPredmet.getBrojPredavanjaUGodini();
        this.brojESBPBodova = smerPredmet.getBrojESBPBodova();
        this.sifraStudijskogPrograma=smerPredmet.getSifraStudijskogPrograma();
        this.id = smerPredmet.getId();
    }

    public SmerDTO getSmer() {
        return smer;
    }

    public void setSmer(SmerDTO smer) {
        this.smer = smer;
    }

    public PredmetDTO getPredmet() {
        return predmet;
    }

    public void setPredmet(PredmetDTO predmet) {
        this.predmet = predmet;
    }

    public ProfesorDTO getProfesor() {
        return profesor;
    }

    public void setProfesor(ProfesorDTO profesor) {
        this.profesor = profesor;
    }

    public Integer getSemestar() {
        return semestar;
    }

    public void setSemestar(Integer semestar) {
        this.semestar = semestar;
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

    public String getSifraStudijskogPrograma() {
        return sifraStudijskogPrograma;
    }

    public void setSifraStudijskogPrograma(String sifraStudijskogPrograma) {
        this.sifraStudijskogPrograma = sifraStudijskogPrograma;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



}
