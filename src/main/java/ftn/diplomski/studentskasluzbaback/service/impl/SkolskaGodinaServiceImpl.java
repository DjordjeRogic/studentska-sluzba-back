package ftn.diplomski.studentskasluzbaback.service.impl;

import ftn.diplomski.studentskasluzbaback.model.SkolskaGodina;
import ftn.diplomski.studentskasluzbaback.repository.SkolskaGodinaRepository;
import ftn.diplomski.studentskasluzbaback.service.SkolskaGodinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SkolskaGodinaServiceImpl implements SkolskaGodinaService {

    @Autowired
    private SkolskaGodinaRepository skolskaGodinaRepository;

    @Override
    public SkolskaGodina getTrenutnaSkolskaGodina() {
        LocalDate date = LocalDate.now();
        int year = date.getYear();
        if(date.getMonthValue() > 9){ //ako je posle oktobra to je sledeca godina
            year = year+1;
        }

        List<SkolskaGodina> skolskaGodinas = skolskaGodinaRepository.findAll();

        for(SkolskaGodina skolskaGodina : skolskaGodinas){
            if(skolskaGodina.getPocetakGodine().getYear() <= year && skolskaGodina.getKrajGodine().getYear()>=year){
                return skolskaGodina;
            }
        }

        return null;
    }
}
