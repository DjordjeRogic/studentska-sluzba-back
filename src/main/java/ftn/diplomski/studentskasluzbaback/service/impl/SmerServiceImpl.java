package ftn.diplomski.studentskasluzbaback.service.impl;

import ftn.diplomski.studentskasluzbaback.dto.PredmetDTO;
import ftn.diplomski.studentskasluzbaback.dto.ProfesorDTO;
import ftn.diplomski.studentskasluzbaback.dto.SmerDTO;
import ftn.diplomski.studentskasluzbaback.dto.SmerPredmetDTO;
import ftn.diplomski.studentskasluzbaback.enumeration.ObrazovnoPolje;
import ftn.diplomski.studentskasluzbaback.model.Profesor;
import ftn.diplomski.studentskasluzbaback.model.Smer;
import ftn.diplomski.studentskasluzbaback.model.SmerPredmet;
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
}
