package ftn.diplomski.studentskasluzbaback.service;

import ftn.diplomski.studentskasluzbaback.dto.IspitDTO;
import ftn.diplomski.studentskasluzbaback.dto.SmerPredmetDTO;
import ftn.diplomski.studentskasluzbaback.dto.StudentDTO;
import ftn.diplomski.studentskasluzbaback.dto.StudentDolasciDTO;
import ftn.diplomski.studentskasluzbaback.model.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;

public interface SmerPredmetService {

    SmerPredmet poveziProfesoraSaSmeromIpredmetom(Profesor profesor, Smer smer, Predmet predmet,Integer smestar);
    SmerPredmetDTO kreirajStudijskiProgram(SmerPredmetDTO smerPredmetDTO);
    String checkNewSmerPredmet(SmerPredmetDTO smerPredmetDTO);
    SmerPredmetDTO getOne(Long id);
    ArrayList<IspitDTO> getIspiti(Long id);
    SmerPredmet findOne(Long id);
    ArrayList<Ispit> getTrenutniIspitiStudijskogProgrma(Long id_smerpredmeta);
    ArrayList<StudentDolasciDTO> getStudentiDolasci(Long id);

    byte[] downloadStudenteZaDolaske(Long id) throws IOException;

    ArrayList<StudentDolasciDTO> uploadStudenteZaDolaske(Long id, MultipartFile file) throws IOException;

    void unesiDolaske(Long id, ArrayList<StudentDolasciDTO> studentDolasciDTOS);
}
