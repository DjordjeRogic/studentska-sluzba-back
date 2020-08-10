package ftn.diplomski.studentskasluzbaback.service;

import ftn.diplomski.studentskasluzbaback.dto.IspitStudentDTO;
import ftn.diplomski.studentskasluzbaback.dto.ProfesorDTO;
import ftn.diplomski.studentskasluzbaback.dto.StudentDTO;
import ftn.diplomski.studentskasluzbaback.model.Profesor;
import ftn.diplomski.studentskasluzbaback.model.SkolskaGodina;
import ftn.diplomski.studentskasluzbaback.model.Smer;
import ftn.diplomski.studentskasluzbaback.model.Student;

import java.util.ArrayList;

public interface StudentService {

    ArrayList<StudentDTO> getAllStudents();
    StudentDTO saveNewStudent(StudentDTO studentDTO);
    Student findStudent(Long id);
    ArrayList<Student> getStudentePoSmeruiGodini(Smer smer, SkolskaGodina skolskaGodina);
    ArrayList<IspitStudentDTO> getTrenutneIspiteOdUlogvanog();
    IspitStudentDTO prijaviIspit(IspitStudentDTO ispitStudentDTO);
    IspitStudentDTO odjaviIspit(IspitStudentDTO ispitStudentDTO);
    String checkNewStudent(StudentDTO studentDTO);
    String checkPrijavaIspita(IspitStudentDTO ispitStudentDTO);
    ArrayList<IspitStudentDTO> getPrijavljeniIsptiOdStudenta();
}
