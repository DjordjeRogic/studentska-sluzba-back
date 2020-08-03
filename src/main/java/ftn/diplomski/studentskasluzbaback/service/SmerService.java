package ftn.diplomski.studentskasluzbaback.service;

import ftn.diplomski.studentskasluzbaback.dto.PredmetDTO;
import ftn.diplomski.studentskasluzbaback.dto.SmerDTO;
import ftn.diplomski.studentskasluzbaback.dto.SmerPredmetDTO;

import java.util.ArrayList;

public interface SmerService {

    ArrayList<SmerDTO> getAllSmerovi();
    SmerDTO saveNewSmer(SmerDTO smerDTO);
    String checkNewSmer(SmerDTO smerDTO);
    ArrayList<SmerPredmetDTO> getPredmetiOdSmera(Long id);
    SmerDTO getSmer(Long id);
}
