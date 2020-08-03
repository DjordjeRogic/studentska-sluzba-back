package ftn.diplomski.studentskasluzbaback.service.impl;

import ftn.diplomski.studentskasluzbaback.dto.PredmetDTO;
import ftn.diplomski.studentskasluzbaback.enumeration.KategorijaPredmeta;
import ftn.diplomski.studentskasluzbaback.model.Predmet;
import ftn.diplomski.studentskasluzbaback.repository.PredmetRepository;
import ftn.diplomski.studentskasluzbaback.service.PredmetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PredmetServiceImpl implements PredmetService {

    @Autowired
    private PredmetRepository predmetRepository;

    @Override
    public ArrayList<PredmetDTO> getAllPredmets() {
        List<Predmet> predmetList =  predmetRepository.findAll();
        ArrayList<PredmetDTO> predmetDTOS = new ArrayList<>();

        for(Predmet predmet:predmetList){
            predmetDTOS.add(new PredmetDTO(predmet));
        }

        return predmetDTOS;
    }

    @Override
    public PredmetDTO saveNewPredmet(PredmetDTO predmetDTO) {
        Predmet predmet = new Predmet();

        predmet.setNaziv(predmetDTO.getNaziv());
        predmet.setKategorija(KategorijaPredmeta.valueOf(predmetDTO.getKategorija()));
        predmet.setBrojESBPBodova(predmetDTO.getBrojESBPBodova());
        predmet.setBrojPredavanjaUGodini(predmetDTO.getBrojPredavanjaUGodini());

        Predmet saved = predmetRepository.save(predmet);

        predmetDTO.setId(saved.getId());
        predmetDTO.setKategorija(predmet.getKategorija().getFieldDescription());
        return predmetDTO;
    }

    @Override
    public String checkNewPredmet(PredmetDTO profesorDTO) {
        return null;
    }
}
