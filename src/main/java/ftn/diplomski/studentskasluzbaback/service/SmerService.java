package ftn.diplomski.studentskasluzbaback.service;

import ftn.diplomski.studentskasluzbaback.dto.IspitStudentDTO;
import ftn.diplomski.studentskasluzbaback.dto.PredmetDTO;
import ftn.diplomski.studentskasluzbaback.dto.SmerDTO;
import ftn.diplomski.studentskasluzbaback.dto.SmerPredmetDTO;
import ftn.diplomski.studentskasluzbaback.model.Ispit;
import ftn.diplomski.studentskasluzbaback.model.SkolskaGodina;
import ftn.diplomski.studentskasluzbaback.model.Smer;
import ftn.diplomski.studentskasluzbaback.model.Student;

import java.util.ArrayList;

public interface SmerService {

    ArrayList<SmerDTO> getAllSmerovi();
    SmerDTO saveNewSmer(SmerDTO smerDTO);
    String checkNewSmer(SmerDTO smerDTO);
    ArrayList<SmerPredmetDTO> getPredmetiOdSmera(Long id);
    SmerDTO getSmer(Long id);
    Smer findSmer(Long id);
    Integer getBrojESBPzaSemestar(Long id_smera,Integer brojSemestra);
    ArrayList<Ispit> getTrenutneIspiteSmera(Long id_smera);


    String checkDelete(Long id);

    void deleteSmer(Long id);

    String checkUpdate(SmerDTO smerDTO);

    SmerDTO updateSmer(SmerDTO smerDTO);
}
