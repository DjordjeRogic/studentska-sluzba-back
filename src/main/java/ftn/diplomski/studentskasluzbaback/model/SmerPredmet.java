package ftn.diplomski.studentskasluzbaback.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class SmerPredmet {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="sifraStudijskogPrograma",unique = true)
    private String sifraStudijskogPrograma;

    @Column(name="brojPredavanjaUGodini")
    private Integer brojPredavanjaUGodini;

    @Column(name="brojESBPBodova")
    private Integer brojESBPBodova;

    @Column(name="semestar")
    private Integer semestar;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Smer smer;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Predmet predmet;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "profesor_smerpredmet",
            joinColumns = @JoinColumn(name = "smer_predmet_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "profesor_id", referencedColumnName = "id"))
    private Set<Profesor> profesori = new HashSet<>();

    @OneToMany(mappedBy = "smerPredmet", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Ispit> ispiti;

    @OneToMany(mappedBy = "smerPredmet", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Ocena> ocene;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSemestar() {
        return semestar;
    }

    public void setSemestar(Integer semestar) {
        this.semestar = semestar;
    }

    public Smer getSmer() {
        return smer;
    }

    public void setSmer(Smer smer) {
        this.smer = smer;
    }

    public Predmet getPredmet() {
        return predmet;
    }

    public void setPredmet(Predmet predmet) {
        this.predmet = predmet;
    }

    public Set<Profesor> getProfesori() {
        return profesori;
    }

    public void setProfesori(Set<Profesor> profesori) {
        this.profesori = profesori;
    }

    public String getSifraStudijskogPrograma() {
        return sifraStudijskogPrograma;
    }

    public void setSifraStudijskogPrograma(String sifraStudijskogPrograma) {
        this.sifraStudijskogPrograma = sifraStudijskogPrograma;
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

    public Set<Ispit> getIspiti() {
        return ispiti;
    }

    public void setIspiti(Set<Ispit> ispiti) {
        this.ispiti = ispiti;
    }

    public Set<Ocena> getOcene() {
        return ocene;
    }

    public void setOcene(Set<Ocena> ocene) {
        this.ocene = ocene;
    }



}
