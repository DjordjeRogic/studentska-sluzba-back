package ftn.diplomski.studentskasluzbaback.service.impl;

import ftn.diplomski.studentskasluzbaback.dto.StudentRezultatDTO;
import ftn.diplomski.studentskasluzbaback.model.*;
import ftn.diplomski.studentskasluzbaback.repository.OcenaRepository;
import ftn.diplomski.studentskasluzbaback.service.IspitService;
import ftn.diplomski.studentskasluzbaback.service.OcenaService;
import ftn.diplomski.studentskasluzbaback.service.SmerPredmetService;
import ftn.diplomski.studentskasluzbaback.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OcenaServiceImpl implements OcenaService {

    @Autowired
    private OcenaRepository ocenaRepository;

    @Autowired
    private StudentService studentService;

    @Autowired
    private SmerPredmetService smerPredmetService;

    @Autowired
    private IspitService ispitService;

    @Override
    public Ocena pronadjiOcenuOdStudentaZaPredmet(Student student, SmerPredmet smerPredmet) {
        return ocenaRepository.findByStudentAndSmerPredmet(student,smerPredmet);
    }

    @Override
    public void unesiOcene(Long id_ispita, ArrayList<StudentRezultatDTO> studentRezultatDTOS) {
        System.out.println("UNOS OCENE");
        Ispit ispit = ispitService.getOne(id_ispita);

        for(StudentRezultatDTO studentRezultatDTO :studentRezultatDTOS) {

            Student student = studentService.findStudent(studentRezultatDTO.getId());
            System.out.println("Studentdto: "+studentRezultatDTO.getId());
            Ocena ocena = pronadjiOcenuOdStudentaZaPredmet(student,ispit.getSmerPredmet());

            if(ocena == null){
                ocena= new Ocena();
                ocena.setBrojDolazakaNaPredavanja(0);
                ocena.setPolozio(false);
                ocena.setPotpis(false);
                ocena.setSmerPredmet(ispit.getSmerPredmet());
                ocena.setStudent(student);
                ocena.setOcena(5);
                ocena.setStudent(student);

            }
            ocena.setBrojBodova(studentRezultatDTO.getBodovi());
            if(studentRezultatDTO.getBodovi()>50){
                ocena.setDatumPolaganja(ispit.getDatum());
                ocena.setPolozio(true);

                System.out.println("Student: "+student.getId());
                ocena.setStudent(student);


                if(studentRezultatDTO.getBodovi()<61){
                    ocena.setOcena(6);
                }else{
                    if(studentRezultatDTO.getBodovi()<71){
                        ocena.setOcena(7);
                    }else{
                        if(studentRezultatDTO.getBodovi()<81){
                            ocena.setOcena(8);
                        }else{
                            if(studentRezultatDTO.getBodovi()<91){
                                ocena.setOcena(9);
                            }else{
                                ocena.setOcena(10);
                            }
                        }
                    }
                }


            }
            ocenaRepository.save(ocena);
        }
        ispit.setUneseniRezultati(true);
        ispitService.saveIspit(ispit);

    }

}
