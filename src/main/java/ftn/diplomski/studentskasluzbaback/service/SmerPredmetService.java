package ftn.diplomski.studentskasluzbaback.service;

import ftn.diplomski.studentskasluzbaback.dto.IspitDTO;
import ftn.diplomski.studentskasluzbaback.dto.SmerPredmetDTO;
import ftn.diplomski.studentskasluzbaback.model.*;

import java.util.ArrayList;

public interface SmerPredmetService {

    SmerPredmet poveziProfesoraSaSmeromIpredmetom(Profesor profesor, Smer smer, Predmet predmet,Integer smestar);
    SmerPredmetDTO kreirajStudijskiProgram(SmerPredmetDTO smerPredmetDTO);
    String checkNewSmerPredmet(SmerPredmetDTO smerPredmetDTO);
    SmerPredmetDTO getOne(Long id);
    ArrayList<IspitDTO> getIspiti(Long id);
    SmerPredmet findOne(Long id);
    ArrayList<Ispit> getTrenutniIspitiStudijskogProgrma(Long id_smerpredmeta);
}
