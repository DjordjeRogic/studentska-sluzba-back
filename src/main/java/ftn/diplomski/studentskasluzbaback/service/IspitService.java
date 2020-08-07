package ftn.diplomski.studentskasluzbaback.service;

import ftn.diplomski.studentskasluzbaback.dto.IspitDTO;
import ftn.diplomski.studentskasluzbaback.dto.PredmetDTO;
import ftn.diplomski.studentskasluzbaback.model.Ispit;

import java.util.ArrayList;

public interface IspitService {

    IspitDTO saveNewIspit(IspitDTO ispitDTO);
    String checkNewIspit(IspitDTO ispitDTO);
}
