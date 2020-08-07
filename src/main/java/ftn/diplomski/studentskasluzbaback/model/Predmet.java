package ftn.diplomski.studentskasluzbaback.model;

import ftn.diplomski.studentskasluzbaback.enumeration.KategorijaPredmeta;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Predmet {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="naziv")
    private String naziv;

    @Column(name="kategorija")
    private KategorijaPredmeta kategorija;

    @OneToMany(mappedBy = "predmet", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<SmerPredmet> smerovi;

    public Predmet() {
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

    public KategorijaPredmeta getKategorija() {
        return kategorija;
    }

    public void setKategorija(KategorijaPredmeta kategorija) {
        this.kategorija = kategorija;
    }

}
