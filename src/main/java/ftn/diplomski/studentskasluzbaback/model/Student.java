package ftn.diplomski.studentskasluzbaback.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("STUDENT")
public class Student extends User {

    @Column(name = "brojIndexa")
    private String brojIndexa;

    @Column(name = "godinaUpisa")
    private Date godinaUpisa;

    @Column(name = "semestar")
    private Integer semestar;
}
