package ftn.diplomski.studentskasluzbaback.model;

import javax.persistence.*;

@Entity
public class SmerPredmet {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Integer semestar;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Smer smer;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Predmet predmet;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Profesor profesor;

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

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
}
