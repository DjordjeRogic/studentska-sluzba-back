package ftn.diplomski.studentskasluzbaback.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity(name="skolskaGodina")
public class SkolskaGodina {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="pocetakGodine")
    private LocalDate pocetakGodine;

    @Column(name="krajGodine")
    private LocalDate krajGodine;

    @Column
    private  LocalDate pocetakOvereZimskog;

    @Column
    private  LocalDate krajOvereZimskog;

    @Column
    private  LocalDate pocetakOvereLetnjeg;

    @Column
    private  LocalDate krajOvereLetnjeg;

    @OneToMany(mappedBy = "skolskaGodina", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Ispit> ispiti;

    @OneToMany(mappedBy = "godinaUpisa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Student> upisaniStudetnti;

    public SkolskaGodina() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getPocetakGodine() {
        return pocetakGodine;
    }

    public void setPocetakGodine(LocalDate pocetakGodine) {
        this.pocetakGodine = pocetakGodine;
    }

    public LocalDate getKrajGodine() {
        return krajGodine;
    }

    public void setKrajGodine(LocalDate krajGodine) {
        this.krajGodine = krajGodine;
    }

    public Set<Ispit> getIspiti() {
        return ispiti;
    }

    public void setIspiti(Set<Ispit> ispiti) {
        this.ispiti = ispiti;
    }

    public LocalDate getPocetakOvereZimskog() {
        return pocetakOvereZimskog;
    }

    public void setPocetakOvereZimskog(LocalDate pocetakOvereZimskog) {
        this.pocetakOvereZimskog = pocetakOvereZimskog;
    }

    public LocalDate getKrajOvereZimskog() {
        return krajOvereZimskog;
    }

    public void setKrajOvereZimskog(LocalDate krajOvereZimskog) {
        this.krajOvereZimskog = krajOvereZimskog;
    }

    public LocalDate getPocetakOvereLetnjeg() {
        return pocetakOvereLetnjeg;
    }

    public void setPocetakOvereLetnjeg(LocalDate pocetakOvereLetnjeg) {
        this.pocetakOvereLetnjeg = pocetakOvereLetnjeg;
    }

    public LocalDate getKrajOvereLetnjeg() {
        return krajOvereLetnjeg;
    }

    public void setKrajOvereLetnjeg(LocalDate krajOvereLetnjeg) {
        this.krajOvereLetnjeg = krajOvereLetnjeg;
    }

    public Set<Student> getUpisaniStudetnti() {
        return upisaniStudetnti;
    }

    public void setUpisaniStudetnti(Set<Student> upisaniStudetnti) {
        this.upisaniStudetnti = upisaniStudetnti;
    }
}
