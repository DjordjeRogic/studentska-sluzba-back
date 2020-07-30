package ftn.diplomski.studentskasluzbaback.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("PROFESOR")
public class Profesor extends User {
    @Column(name="sifraProfesora")
    private Integer sifraProfesora;
}
