package ftn.diplomski.studentskasluzbaback.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@DiscriminatorValue("STUDENT")
public class Student extends User {

    @Column(name = "brojIndexa")
    private String brojIndexa;

    @Column(name = "semestar")
    private Integer semestar;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Ocena> ocene;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private SkolskaGodina godinaUpisa;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Smer smer;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "ispit_student_prijavio",
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ispit_id", referencedColumnName = "id"))
    private Set<Ispit> prijavljeniIspiti;

    public Student() {
    }

    public String getBrojIndexa() {
        return brojIndexa;
    }

    public void setBrojIndexa(String brojIndexa) {
        this.brojIndexa = brojIndexa;
    }

    public Set<Ocena> getOcene() {
        return ocene;
    }

    public void setOcene(Set<Ocena> ocene) {
        this.ocene = ocene;
    }

    public SkolskaGodina getGodinaUpisa() {
        return godinaUpisa;
    }

    public void setGodinaUpisa(SkolskaGodina godinaUpisa) {
        this.godinaUpisa = godinaUpisa;
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

    public Set<Ispit> getPrijavljeniIspiti() {
        return prijavljeniIspiti;
    }

    public void setPrijavljeniIspiti(Set<Ispit> prijavljeniIspiti) {
        this.prijavljeniIspiti = prijavljeniIspiti;
    }
}

