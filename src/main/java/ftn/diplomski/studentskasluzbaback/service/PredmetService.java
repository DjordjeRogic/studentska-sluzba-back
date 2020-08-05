package ftn.diplomski.studentskasluzbaback.service;

import ftn.diplomski.studentskasluzbaback.dto.PredmetDTO;
import ftn.diplomski.studentskasluzbaback.dto.ProfesorDTO;
import ftn.diplomski.studentskasluzbaback.model.Predmet;
import ftn.diplomski.studentskasluzbaback.model.Smer;

import java.util.ArrayList;

public interface PredmetService {

    ArrayList<PredmetDTO> getAllPredmets();
    PredmetDTO saveNewPredmet(PredmetDTO profesorDTO);
    String checkNewPredmet(PredmetDTO profesorDTO);
    ArrayList<PredmetDTO> getPredmetiKojiNePripadajuSmeru(Long idSmera);
    Predmet findPredmet(Long id);
}
