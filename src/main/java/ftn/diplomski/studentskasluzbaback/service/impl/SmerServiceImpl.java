package ftn.diplomski.studentskasluzbaback.service.impl;

import ftn.diplomski.studentskasluzbaback.dto.*;
import ftn.diplomski.studentskasluzbaback.enumeration.ObrazovnoPolje;
import ftn.diplomski.studentskasluzbaback.model.*;
import ftn.diplomski.studentskasluzbaback.repository.SmerRepository;
import ftn.diplomski.studentskasluzbaback.service.SmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SmerServiceImpl implements SmerService {

    @Autowired
    private SmerRepository smerRepository;

    @Autowired
    private SmerPredmetServiceImpl smerPredmetService;

    @Override
    public ArrayList<SmerDTO> getAllSmerovi() {
        List<Smer> smerListmer =  smerRepository.findAll();
        ArrayList<SmerDTO> smerDTOS = new ArrayList<>();

        for(Smer smer:smerListmer){
            smerDTOS.add(new SmerDTO(smer));
        }

        return smerDTOS;
    }

    @Override
    public SmerDTO saveNewSmer(SmerDTO smerDTO) {
        Smer smer = new Smer();

        smer.setNaziv(smerDTO.getNaziv());
        smer.setSkracenica(smerDTO.getSkracenica().toUpperCase());
        smer.setNazivDiplome(smerDTO.getNazivDiplome());
        smer.setObrazovnoPolje(ObrazovnoPolje.valueOf(smerDTO.getObrazovnoPolje()));
        smer.setTrajanjeUSemestrima(smerDTO.getTrajanjeUSemestrima());

        Smer saved = smerRepository.save(smer);
        smerDTO.setId(saved.getId());
        smerDTO.setObrazovnoPolje(saved.getObrazovnoPolje().getFieldDescription());
        return smerDTO;
    }

    @Override
    public String checkNewSmer(SmerDTO smerDTO) {
        return null;
    }

    @Override
    public ArrayList<SmerPredmetDTO> getPredmetiOdSmera(Long id) {
        System.out.println("USAO PREDMETI SMERA");
        Smer smer = smerRepository.findById(id).orElse(null);
        System.out.println("SMER: "+ smer.getNaziv() );
        ArrayList<SmerPredmetDTO> ret = new ArrayList<>();
        for(SmerPredmet smerPredmet: smer.getPredmeti()){
            ret.add(new SmerPredmetDTO(smerPredmet));
        }
        return ret;
    }

    @Override
    public SmerDTO getSmer(Long id) {
        Smer smer = smerRepository.findById(id).orElse(null);
        if(smer == null){
            return new SmerDTO();
        }

        return new SmerDTO(smer);
    }

    @Override
    public Smer findSmer(Long id) {
        return smerRepository.findById(id).orElse(null);
    }

    @Override
    public Integer getBrojESBPzaSemestar(Long id_smera, Integer brojSemestra) {
        Integer rez =0;
        Smer smer = findSmer(id_smera);

        for(SmerPredmet smerPredmet:smer.getPredmeti()){
            if(smerPredmet.getSemestar() == brojSemestra){
                rez+=smerPredmet.getBrojESBPBodova();
            }
        }

        return rez;
    }

    @Override
    public ArrayList<Ispit> getTrenutneIspiteSmera(Long id_smera) {
        Smer smer = smerRepository.getOne(id_smera);
        ArrayList<Ispit> ret = new ArrayList<>();

        for(SmerPredmet smerPredmet : smer.getPredmeti()){
            ArrayList<Ispit> ispiti = smerPredmetService.getTrenutniIspitiStudijskogProgrma(smerPredmet.getId());
            for(Ispit ispit:ispiti){
                ret.add(ispit);
            }
        }

        return ret;
    }

    @Override
    public String checkDelete(Long id) {
        Smer smer =smerRepository.getOne(id);

        if(smer.getStudenti().size()>0)
        {
            return "Smer se ne moze obrisati jer postoje studenti na njemu.";
        }


        return null;
    }

    @Override
    public void deleteSmer(Long id) {
        Smer smer =smerRepository.getOne(id);
        smerRepository.delete(smer);
    }

    @Override
    public String checkUpdate(SmerDTO smerDTO) {

        if(smerRepository.findByNaziv(smerDTO.getNaziv()) != null && smerRepository.findByNaziv(smerDTO.getNaziv()).getId() != smerDTO.getId() ){
            return "Smer sa tim nazivom vec postoji!";
        }

        if(smerRepository.findBySkracenica(smerDTO.getSkracenica()) != null && smerRepository.findBySkracenica(smerDTO.getSkracenica()).getId() != smerDTO.getId() ){
            return "Smer sa tom skracenicom vec postoji!";
        }

        return null;
    }

    @Override
    public SmerDTO updateSmer(SmerDTO smerDTO) {
        Smer smer =smerRepository.getOne(smerDTO.getId());

        smer.setNaziv(smerDTO.getNaziv());
        smer.setTrajanjeUSemestrima(smerDTO.getTrajanjeUSemestrima());
        smer.setObrazovnoPolje(ObrazovnoPolje.valueOf(smerDTO.getObrazovnoPolje()));
        smer.setSkracenica(smerDTO.getSkracenica());

        smer = smerRepository.save(smer);


        return new SmerDTO(smer);
    }
}
