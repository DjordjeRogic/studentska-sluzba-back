package ftn.diplomski.studentskasluzbaback.service.impl;

import ftn.diplomski.studentskasluzbaback.dto.StudentRezultatDTO;
import ftn.diplomski.studentskasluzbaback.model.Ispit;
import ftn.diplomski.studentskasluzbaback.model.Ocena;
import ftn.diplomski.studentskasluzbaback.model.Student;
import ftn.diplomski.studentskasluzbaback.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private Environment env;


    @Override
    public void otvorenNalogStudentu(Student student, String sifra) {

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(student.getEmail());
        mail.setFrom(env.getProperty("spring.mail.username"));
        mail.setSubject("Otvoren nalog");
        mail.setText("Otvoren vam je nalog na studenskoj sluzbi za broj indexa  "+student.getBrojIndexa()+". Mozete se prijaviti sa ovim emailom i generisanom sifrom \""+sifra+"\" koju mozete promeniti.");
        javaMailSender.send(mail);

    }

    @Override
    public void uneseniRezultatiIspita(Ocena ocena) {

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(ocena.getStudent().getEmail());
        mail.setFrom(env.getProperty("spring.mail.username"));
        mail.setSubject("Otvoren nalog");
        mail.setText("Uneseni su rezultati iz predmeta "+ocena.getSmerPredmet().getPredmet().getNaziv()+". Osvojili ste "+
                ocena.getBrojBodova()+" i upisana vam je ocena "+ocena.getOcena());
        javaMailSender.send(mail);

    }

    @Override
    public void poceoIspitniRok() {

    }
}
