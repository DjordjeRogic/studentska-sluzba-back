package ftn.diplomski.studentskasluzbaback.model;

import ftn.diplomski.studentskasluzbaback.enumeration.IspitniRok;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
public class Ispit {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private IspitniRok rok;

    @Column
    private LocalDate datum;

    @Column
    private String mestoOdrzavanja;

    @Column
    private LocalTime vremeOdrzavanja;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private SkolskaGodina skolskaGodina;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private SmerPredmet smerPredmet;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Student> studentiKojiSuPrijavili;

    public Ispit() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public IspitniRok getRok() {
        return rok;
    }

    public void setRok(IspitniRok rok) {
        this.rok = rok;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public String getMestoOdrzavanja() {
        return mestoOdrzavanja;
    }

    public void setMestoOdrzavanja(String mestoOdrzavanja) {
        this.mestoOdrzavanja = mestoOdrzavanja;
    }

    public SkolskaGodina getSkolskaGodina() {
        return skolskaGodina;
    }

    public void setSkolskaGodina(SkolskaGodina skolskaGodina) {
        this.skolskaGodina = skolskaGodina;
    }

    public SmerPredmet getSmerPredmet() {
        return smerPredmet;
    }

    public void setSmerPredmet(SmerPredmet smerPredmet) {
        this.smerPredmet = smerPredmet;
    }

    public LocalTime getVremeOdrzavanja() {
        return vremeOdrzavanja;
    }

    public void setVremeOdrzavanja(LocalTime vremeOdrzavanja) {
        this.vremeOdrzavanja = vremeOdrzavanja;
    }
}


