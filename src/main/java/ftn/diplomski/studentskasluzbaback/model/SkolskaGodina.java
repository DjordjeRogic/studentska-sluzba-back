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
}
