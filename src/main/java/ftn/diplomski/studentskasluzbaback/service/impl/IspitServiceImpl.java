package ftn.diplomski.studentskasluzbaback.service.impl;

import ftn.diplomski.studentskasluzbaback.dto.IspitDTO;
import ftn.diplomski.studentskasluzbaback.enumeration.IspitniRok;
import ftn.diplomski.studentskasluzbaback.model.Ispit;
import ftn.diplomski.studentskasluzbaback.model.SkolskaGodina;
import ftn.diplomski.studentskasluzbaback.model.SmerPredmet;
import ftn.diplomski.studentskasluzbaback.repository.IspitRepository;
import ftn.diplomski.studentskasluzbaback.service.IspitService;
import ftn.diplomski.studentskasluzbaback.service.SkolskaGodinaService;
import ftn.diplomski.studentskasluzbaback.service.SmerPredmetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class IspitServiceImpl implements IspitService {

    @Autowired
    private IspitRepository ispitRepository;

    @Autowired
    private SmerPredmetService smerPredmetService;

    @Autowired
    private SkolskaGodinaService skolskaGodinaService;


    @Override
    public IspitDTO saveNewIspit(IspitDTO ispitDTO) {
        SmerPredmet smerPredmet = smerPredmetService.findOne(ispitDTO.getProgramId());
        SkolskaGodina skolskaGodina = skolskaGodinaService.getTrenutnaSkolskaGodina();


        Ispit ispit = new Ispit();

        ispit.setDatum(LocalDate.parse(ispitDTO.getDatum()));
        ispit.setMestoOdrzavanja(ispitDTO.getMestoOdrzavanja());
        ispit.setSkolskaGodina(skolskaGodina);
        ispit.setSmerPredmet(smerPredmet);
        ispit.setRok(IspitniRok.valueOf(ispitDTO.getRok()));
        ispit.setVremeOdrzavanja(LocalTime.parse(ispitDTO.getVremeOdrzavanja()));

        Ispit saved = ispitRepository.save(ispit);
        ispitDTO.setId(saved.getId());

        return ispitDTO;
    }

    @Override
    public String checkNewIspit(IspitDTO ispitDTO) {
        SmerPredmet smerPredmet = smerPredmetService.findOne(ispitDTO.getProgramId());
        SkolskaGodina skolskaGodina = skolskaGodinaService.getTrenutnaSkolskaGodina();
        for(Ispit ispit:smerPredmet.getIspiti()){
            if(ispit.getDatum().isAfter(skolskaGodina.getPocetakGodine()) && ispit.getDatum().isBefore(skolskaGodina.getKrajGodine()) && ispit.getRok().equals(IspitniRok.valueOf(ispitDTO.getRok()))){
                return "Ispit u tom roku vec postoji!";
            }
        }

        IspitniRok ispitniRok = IspitniRok.valueOf(ispitDTO.getRok());
        LocalDate localDate = LocalDate.parse(ispitDTO.getDatum());

        if(ispitDTO.equals(IspitniRok.JAN) || ispitDTO.equals(IspitniRok.FEB)){
            if(localDate.getMonthValue() >2){
                return "Ispit u januarsko-februarskom roku se moze zakazati samo u januaru ili februaru";
            }
        }

        if(ispitDTO.equals(IspitniRok.APR)){
            if(localDate.getMonthValue() != 4 ){
                return "Ispit u aprilskom roku se moze zakazati samo u aprilu";
            }
        }

        if(ispitDTO.equals(IspitniRok.JUN) || ispitDTO.equals(IspitniRok.JUL)){
            if(localDate.getMonthValue() <6 || localDate.getMonthValue() > 7 ){
                return "Ispit u junsko-julskom roku se moze zakazati samo u junu ili julu";
            }
        }
        if(ispitDTO.equals(IspitniRok.SEP) ){
            if(localDate.getMonthValue() >7  || localDate.getMonthValue() <10 ){
                return "Ispit u septembarskom roku se moze zakazati samo u avgustu ili septembru";
            }
        }
        if(ispitDTO.equals(IspitniRok.OKT) ){
            if(localDate.getMonthValue() >8  || localDate.getMonthValue() <10 ){
                return "Ispit u oktobarskom roku se moze zakazati samo u septembru";
            }
        }
        return null;
    }
}
