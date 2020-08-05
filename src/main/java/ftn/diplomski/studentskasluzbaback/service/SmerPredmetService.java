package ftn.diplomski.studentskasluzbaback.service;

import ftn.diplomski.studentskasluzbaback.dto.SmerPredmetDTO;
import ftn.diplomski.studentskasluzbaback.model.Predmet;
import ftn.diplomski.studentskasluzbaback.model.Profesor;
import ftn.diplomski.studentskasluzbaback.model.Smer;
import ftn.diplomski.studentskasluzbaback.model.SmerPredmet;

public interface SmerPredmetService {

    SmerPredmet poveziProfesoraSaSmeromIpredmetom(Profesor profesor, Smer smer, Predmet predmet,Integer smestar);
    SmerPredmetDTO kreirajStudijskiProgram(SmerPredmetDTO smerPredmetDTO);
    String checkNewSmerPredmet(SmerPredmetDTO smerPredmetDTO);
}
