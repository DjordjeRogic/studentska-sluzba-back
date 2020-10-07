package ftn.diplomski.studentskasluzbaback.controller;


import ftn.diplomski.studentskasluzbaback.model.Ispit;
import ftn.diplomski.studentskasluzbaback.model.SkolskaGodina;
import ftn.diplomski.studentskasluzbaback.model.Student;
import ftn.diplomski.studentskasluzbaback.service.IspitService;
import ftn.diplomski.studentskasluzbaback.service.SkolskaGodinaService;
import ftn.diplomski.studentskasluzbaback.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.ArrayList;

@EnableScheduling
@RestController
public class SkolskaGodinaController {

    @Autowired
    private SkolskaGodinaService skolskaGodinaService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private IspitService ispitService;

    @Scheduled(cron = "${pocetakSkolskeGodine.cron}")
    @Transactional
    public void otvoriNovuSkolskuGodinu(){
        SkolskaGodina skolskaGodina= skolskaGodinaService.getTrenutnaSkolskaGodina();
        SkolskaGodina novaSkolskaGodina = new SkolskaGodina();

        novaSkolskaGodina.setPocetakGodine(skolskaGodina.getPocetakGodine().plusYears(1));
        novaSkolskaGodina.setKrajGodine(skolskaGodina.getKrajGodine().plusYears(1));
        novaSkolskaGodina.setPocetakOvereLetnjeg(skolskaGodina.getPocetakOvereLetnjeg().plusYears(1));
        novaSkolskaGodina.setKrajOvereLetnjeg(skolskaGodina.getKrajOvereLetnjeg().plusYears(1));
        novaSkolskaGodina.setPocetakOvereZimskog(skolskaGodina.getPocetakOvereZimskog().plusYears(1));
        novaSkolskaGodina.setKrajOvereZimskog(skolskaGodina.getKrajOvereZimskog().plusYears(1));

        novaSkolskaGodina = skolskaGodinaService.save(novaSkolskaGodina);
        for(Ispit ispit : skolskaGodina.getIspiti()){
            Ispit newIspit = new Ispit();
            newIspit.setUneseniRezultati(false);
            newIspit.setRok(ispit.getRok());
            newIspit.setSmerPredmet(ispit.getSmerPredmet());
            newIspit.setSkolskaGodina(novaSkolskaGodina);
            newIspit.setDatum(ispit.getDatum().plusYears(1));
            newIspit = ispitService.saveIspit(newIspit);
            skolskaGodina.getIspiti().add(newIspit);
        }

        skolskaGodinaService.save(novaSkolskaGodina);

        //ako student nije overio zimski semestar on se vraca u prosli zimski
        ArrayList<Student> students = studentService.findAll();
        for(Student student:students){
            if(student.getSemestar()%2 != 0){
                student.setSemestar(student.getSemestar()-1);
                studentService.save(student);
            }

        }
    }
}
