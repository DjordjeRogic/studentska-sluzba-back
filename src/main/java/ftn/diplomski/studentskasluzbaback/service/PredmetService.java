package ftn.diplomski.studentskasluzbaback.service;

import ftn.diplomski.studentskasluzbaback.dto.PredmetDTO;
import ftn.diplomski.studentskasluzbaback.dto.ProfesorDTO;

import java.util.ArrayList;

public interface PredmetService {

    ArrayList<PredmetDTO> getAllPredmets();
    PredmetDTO saveNewPredmet(PredmetDTO profesorDTO);
    String checkNewPredmet(PredmetDTO profesorDTO);
}
