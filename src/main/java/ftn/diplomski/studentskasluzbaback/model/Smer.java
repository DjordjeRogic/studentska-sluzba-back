package ftn.diplomski.studentskasluzbaback.model;

import ftn.diplomski.studentskasluzbaback.enumeration.ObrazovnoPolje;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Smer {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="naziv")
    private String naziv;

    @Column(name="skracenica")
    private String skracenica;

    @Column(name="trajanjeUSemestrima")
    private Integer trajanjeUSemestrima;

    @Column(name="obrazovnoPolje")
    private ObrazovnoPolje obrazovnoPolje;

    @Column(name="nazivDiplome")
    private String nazivDiplome;

    @OneToMany(mappedBy = "smer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<SmerPredmet> predmeti;

    @OneToMany(mappedBy = "smer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Student> studenti;

    public Smer() {
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

    public ObrazovnoPolje getObrazovnoPolje() {
        return obrazovnoPolje;
    }

    public void setObrazovnoPolje(ObrazovnoPolje obrazovnoPolje) {
        this.obrazovnoPolje = obrazovnoPolje;
    }

    public String getNazivDiplome() {
        return nazivDiplome;
    }

    public void setNazivDiplome(String nazivDiplome) {
        this.nazivDiplome = nazivDiplome;
    }

    public Set<SmerPredmet> getPredmeti() {
        return predmeti;
    }

    public void setPredmeti(Set<SmerPredmet> predmeti) {
        this.predmeti = predmeti;
    }

    public Set<Student> getStudenti() {
        return studenti;
    }

    public void setStudenti(Set<Student> studenti) {
        this.studenti = studenti;
    }
}
