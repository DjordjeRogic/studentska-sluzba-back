package ftn.diplomski.studentskasluzbaback.service;

import ftn.diplomski.studentskasluzbaback.dto.IspitDTO;
import ftn.diplomski.studentskasluzbaback.dto.IspitProfesorDTO;
import ftn.diplomski.studentskasluzbaback.dto.StudentRezultatDTO;
import ftn.diplomski.studentskasluzbaback.model.Ispit;

import java.io.IOException;
import java.util.ArrayList;

public interface IspitService {

    IspitDTO saveNewIspit(IspitDTO ispitDTO);
    String checkNewIspit(IspitDTO ispitDTO);
    Ispit getOne(Long id);
    IspitProfesorDTO updateIspitProfesor(IspitProfesorDTO ispitProfesorDTO);
    ArrayList<StudentRezultatDTO> getStudenteZaRezultate(Long id_ispita);
    Ispit saveIspit(Ispit ispit);
    byte[] downloadStudenteZaRezultate(Long id_ispita) throws IOException;
}
