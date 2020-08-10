package ftn.diplomski.studentskasluzbaback.service.impl;

import ftn.diplomski.studentskasluzbaback.dto.IspitDTO;
import ftn.diplomski.studentskasluzbaback.dto.SmerPredmetDTO;
import ftn.diplomski.studentskasluzbaback.enumeration.IspitniRok;
import ftn.diplomski.studentskasluzbaback.model.*;
import ftn.diplomski.studentskasluzbaback.repository.SmerPredmetRepository;
import ftn.diplomski.studentskasluzbaback.service.PredmetService;
import ftn.diplomski.studentskasluzbaback.service.ProfesorService;
import ftn.diplomski.studentskasluzbaback.service.SmerPredmetService;
import ftn.diplomski.studentskasluzbaback.service.SmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
public class SmerPredmetServiceImpl implements SmerPredmetService {

    @Autowired
    private SmerPredmetRepository smerPredmetRepository;

    @Autowired
    private SmerService smerService;

    @Autowired
    private ProfesorService profesorService;

    @Autowired
    private PredmetService predmetService;

    @Autowired
    private SkolskaGodinaServiceImpl skolskaGodinaService;

    @Override
    public SmerPredmet poveziProfesoraSaSmeromIpredmetom(Profesor profesor, Smer smer, Predmet predmet, Integer smestar) {
        return null;
    }

    @Override
    public SmerPredmetDTO kreirajStudijskiProgram(SmerPredmetDTO smerPredmetDTO) {
        SmerPredmet smerPredmet = new SmerPredmet();


        System.out.println("semestar : "+ smerPredmetDTO.getSemestar());
        System.out.println("brojPredavanjaUGodini : "+ smerPredmetDTO.getBrojPredavanjaUGodini());
        System.out.println("brojESBPBodova : "+ smerPredmetDTO.getBrojESBPBodova());
        System.out.println("Smer : "+ smerPredmetDTO.getSmer().getId());
        System.out.println("Profesor : "+ smerPredmetDTO.getProfesor().getId());
        System.out.println("Predmet : "+ smerPredmetDTO.getPredmet().getId());



        Smer smer = smerService.findSmer(smerPredmetDTO.getSmer().getId());
        Predmet predmet = predmetService.findPredmet(smerPredmetDTO.getPredmet().getId());
        Profesor profesor = profesorService.findProfesor(smerPredmetDTO.getProfesor().getId());

        smerPredmet.setSmer(smer);
        smerPredmet.setPredmet(predmet);
        smerPredmet.setProfesor(profesor);
        smerPredmet.setBrojESBPBodova(smerPredmetDTO.getBrojESBPBodova());
        smerPredmet.setBrojPredavanjaUGodini(smerPredmetDTO.getBrojPredavanjaUGodini());
      //  smerPredmet.setSemestar(smerPredmetDTO.getSemestar());
        smerPredmet.setSifraStudijskogPrograma(smerPredmetDTO.getSifraStudijskogPrograma().toUpperCase());
        smerPredmet.setSemestar(smerPredmetDTO.getSemestar());

        SmerPredmet saved = smerPredmetRepository.save(smerPredmet);
        smerPredmetDTO.setId(saved.getId());
        return smerPredmetDTO;
    }

    @Override
    public String checkNewSmerPredmet(SmerPredmetDTO smerPredmetDTO) {

        if(smerPredmetDTO.getPredmet() == null){
            return "Predmet mora biti izabran!";
        }
        if(smerPredmetDTO.getSmer() == null){
            return "Smer mora biti izabran!";
        }
        if(smerPredmetDTO.getProfesor() == null){
            return "Profesor mora biti izabran!";
        }
        if(smerPredmetDTO.getSifraStudijskogPrograma() == null){
            return "Sifra studijskog programa mora biti uneta!";
        }
        if(smerPredmetDTO.getSemestar() == null){
            return "Semestar mora biti unet!";
        }
        if(smerPredmetDTO.getBrojPredavanjaUGodini() == null){
            return "Broj predavanja mora biti unet!";
        }
        if(smerPredmetDTO.getBrojESBPBodova() == null){
            return "ESBP bodovi moraju biti uneti!";
        }
        if(smerPredmetDTO.getBrojPredavanjaUGodini() < 0){
            return "Broj predavanja ne moze biti manji od 0!";
        }
        if(smerPredmetDTO.getBrojESBPBodova()<= 0){
            return "Broj ESBP bodova ne moze biti manji ili jednak 0";
        }
        if((smerService.getBrojESBPzaSemestar(smerPredmetDTO.getSmer().getId(),smerPredmetDTO.getSemestar())+smerPredmetDTO.getBrojESBPBodova()) > 60){
            return "Semestar ne moze imati vise od 60 ESBP bodova!";
        }

        return null;
    }

    @Override
    public SmerPredmetDTO getOne(Long id) {
        SmerPredmet smerPredmet = smerPredmetRepository.getOne(id);
        return new SmerPredmetDTO(smerPredmet);
    }

    @Override
    public ArrayList<IspitDTO> getIspiti(Long id) {
        SmerPredmet smerPredmet = smerPredmetRepository.getOne(id);
        ArrayList<IspitDTO> ispitDTOS = new ArrayList<>();
        LocalDate date = LocalDate.now();
        int year = date.getYear();
        if(date.getMonthValue() > 10){ //ako je posle oktobra to je sledeca godina
            year = year+1;
        }

        for(Ispit ispit :smerPredmet.getIspiti()){
            if(ispit.getDatum().getYear() == year ){
                ispitDTOS.add(new IspitDTO(ispit));
            }
        }
        return ispitDTOS;
    }

    @Override
    public SmerPredmet findOne(Long id) {
        return smerPredmetRepository.getOne(id);
    }

    @Override
    public ArrayList<Ispit> getTrenutniIspitiStudijskogProgrma(Long id_smerpredmeta) {
        SmerPredmet smerPredmet = findOne(id_smerpredmeta);
        SkolskaGodina skolskaGodina = skolskaGodinaService.getTrenutnaSkolskaGodina();

        int month = LocalDate.now().getMonthValue();
        LocalDate minDate = LocalDate.now().plusDays(20);


        ArrayList<Ispit> ispits = new ArrayList<>();

        for(Ispit ispit: smerPredmet.getIspiti()){
            if(ispit.getSkolskaGodina().equals(skolskaGodina)){
//                if(ispit.getDatum().isAfter(LocalDate.now()) && ispit.getDatum().isBefore(minDate)){
//                    ispits.add(ispit);
//                }

                //JANUARSKO-FEBRUARSKI
                if(month < 3){
                    if(ispit.getRok().equals(IspitniRok.JAN) || ispit.getRok().equals(IspitniRok.FEB)){
                        ispits.add(ispit);
                    }
                }
                //APRIL
                if(month == 4){
                    if(ispit.getRok().equals(IspitniRok.APR)){
                        ispits.add(ispit);
                    }
                }
                //JUN-JUL
                if(month > 5 && month<8 ){
                    if(ispit.getRok().equals(IspitniRok.JUN) || ispit.getRok().equals(IspitniRok.JUL)){
                        ispits.add(ispit);
                    }
                }
                //AVGUST
                if(month > 7 && month<9 ){
                    if(ispit.getRok().equals(IspitniRok.AVG)){
                        ispits.add(ispit);
                    }
                }
                //SEPTEMBAR
                if(month > 7 && month<10 ){
                    if(ispit.getRok().equals(IspitniRok.JUN) || ispit.getRok().equals(IspitniRok.JUL)){
                        ispits.add(ispit);
                    }
                }
                //OKTOBAR
                if(month > 8 ){
                    if(ispit.getRok().equals(IspitniRok.JUN) || ispit.getRok().equals(IspitniRok.JUL)){
                        ispits.add(ispit);
                    }
                }

                //DODATNI ROKOVI
                if(ispit.getRok().equals(IspitniRok.DO)){
                    if(ispit.getDatum().isAfter(LocalDate.now()) && ispit.getDatum().isBefore(minDate)){
                        ispits.add(ispit);
                    }
                }


            }
        }
        return ispits;
    }
}
