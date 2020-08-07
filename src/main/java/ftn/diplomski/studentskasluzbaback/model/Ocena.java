package ftn.diplomski.studentskasluzbaback.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Ocena {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private boolean polozio;

    @Column
    private LocalDate datumPolaganja;

    @Column
    private boolean potpis;

    @Column
    private Integer brojDolazakaNaPredavanja;

    @Column
    private Integer ocena;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private SmerPredmet smerPredmet;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Student student;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isPolozio() {
        return polozio;
    }

    public void setPolozio(boolean polozio) {
        this.polozio = polozio;
    }

    public LocalDate getDatumPolaganja() {
        return datumPolaganja;
    }

    public void setDatumPolaganja(LocalDate datumPolaganja) {
        this.datumPolaganja = datumPolaganja;
    }

    public boolean isPotpis() {
        return potpis;
    }

    public void setPotpis(boolean potpis) {
        this.potpis = potpis;
    }

    public Integer getBrojDolazakaNaPredavanja() {
        return brojDolazakaNaPredavanja;
    }

    public void setBrojDolazakaNaPredavanja(Integer brojDolazakaNaPredavanja) {
        this.brojDolazakaNaPredavanja = brojDolazakaNaPredavanja;
    }

    public Integer getOcena() {
        return ocena;
    }

    public void setOcena(Integer ocena) {
        this.ocena = ocena;
    }

    public SmerPredmet getSmerPredmet() {
        return smerPredmet;
    }

    public void setSmerPredmet(SmerPredmet smerPredmet) {
        this.smerPredmet = smerPredmet;
    }
}
