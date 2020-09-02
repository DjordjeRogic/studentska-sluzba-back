package ftn.diplomski.studentskasluzbaback.service;

import ftn.diplomski.studentskasluzbaback.dto.IspitProfesorDTO;
import ftn.diplomski.studentskasluzbaback.dto.ProfesorDTO;
import ftn.diplomski.studentskasluzbaback.dto.SmerPredmetDTO;
import ftn.diplomski.studentskasluzbaback.model.Predmet;
import ftn.diplomski.studentskasluzbaback.model.Profesor;

import java.util.ArrayList;

public interface ProfesorService {

    ArrayList<ProfesorDTO> getAllProfesors();
    ProfesorDTO saveNewProfesor(ProfesorDTO profesorDTO);
    String checkNewProfesor(ProfesorDTO profesorDTO);
    Profesor findProfesor(Long id);

    ProfesorDTO deleteProfesor(Long id);
    String proveriDaLiProfesorMozeBitiObrisan(Long id);
    ProfesorDTO updateProfesor(ProfesorDTO profesorDTO);
    ArrayList<SmerPredmetDTO> getStudijskeProgrameKojeUlogovanProfesorPredaje();
    ArrayList<IspitProfesorDTO> getIspiteKodUlogovanogProfesora();
    ArrayList<IspitProfesorDTO> getIspitiOdProfesoraZaUnosOcene();
    ArrayList<SmerPredmetDTO> getPredmetiOdProfesora();
}
