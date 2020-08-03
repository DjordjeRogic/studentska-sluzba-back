package ftn.diplomski.studentskasluzbaback.dto;

import ftn.diplomski.studentskasluzbaback.model.Predmet;
import ftn.diplomski.studentskasluzbaback.model.SmerPredmet;

public class SmerPredmetDTO {

    private SmerDTO smer;
    private PredmetDTO predmet;
    private ProfesorDTO profesor;
    private Integer semestar;

    public SmerPredmetDTO() {
    }

    public SmerPredmetDTO(SmerDTO smer, PredmetDTO predmet, ProfesorDTO profesor, Integer semestar) {
        this.smer = smer;
        this.predmet = predmet;
        this.profesor = profesor;
        this.semestar = semestar;
    }

    public SmerPredmetDTO(SmerPredmet smerPredmet) {
        this.smer = new SmerDTO(smerPredmet.getSmer());
        this.predmet = new PredmetDTO(smerPredmet.getPredmet());
        this.profesor = new ProfesorDTO(smerPredmet.getProfesor());
        this.semestar = smerPredmet.getSemestar();
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
}
