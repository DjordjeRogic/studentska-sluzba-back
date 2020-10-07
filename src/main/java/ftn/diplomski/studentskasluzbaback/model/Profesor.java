package ftn.diplomski.studentskasluzbaback.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@DiscriminatorValue("PROFESOR")
public class Profesor extends User {
    @Column(name="sifraProfesora", unique = true)
    private String sifraProfesora;

    @ManyToMany(mappedBy = "profesori",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<SmerPredmet> predmeti;

    @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Ispit> ispiti;

    public String getSifraProfesora() {
        return sifraProfesora;
    }

    public void setSifraProfesora(String sifraProfesora) {
        this.sifraProfesora = sifraProfesora;
    }

    public Set<SmerPredmet> getPredmeti() {
        return predmeti;
    }

    public void setPredmeti(Set<SmerPredmet> predmeti) {
        this.predmeti = predmeti;
    }
}
