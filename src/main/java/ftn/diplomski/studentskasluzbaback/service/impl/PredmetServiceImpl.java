package ftn.diplomski.studentskasluzbaback.service.impl;

import ftn.diplomski.studentskasluzbaback.dto.PredmetDTO;
import ftn.diplomski.studentskasluzbaback.enumeration.KategorijaPredmeta;
import ftn.diplomski.studentskasluzbaback.model.Predmet;
import ftn.diplomski.studentskasluzbaback.model.Smer;
import ftn.diplomski.studentskasluzbaback.model.SmerPredmet;
import ftn.diplomski.studentskasluzbaback.repository.PredmetRepository;
import ftn.diplomski.studentskasluzbaback.repository.SmerRepository;
import ftn.diplomski.studentskasluzbaback.service.PredmetService;
import ftn.diplomski.studentskasluzbaback.service.SmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PredmetServiceImpl implements PredmetService {

    @Autowired
    private PredmetRepository predmetRepository;

    @Autowired
    private SmerService smerService;

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

        Predmet saved = predmetRepository.save(predmet);

        predmetDTO.setId(saved.getId());
        predmetDTO.setKategorija(predmet.getKategorija().getFieldDescription());
        return predmetDTO;
    }

    @Override
    public String checkNewPredmet(PredmetDTO predmetDTO) {

        if(predmetDTO.getId() != null){
            if (predmetRepository.findByNaziv(predmetDTO.getNaziv()) != null && predmetRepository.findByNaziv(predmetDTO.getNaziv()).getId() != predmetDTO.getId() )
                return "Predmet sa tim nazivom vec postoji!";

        }else {
            if (predmetRepository.findByNaziv(predmetDTO.getNaziv()) != null)
                return "Predmet sa tim nazivom vec postoji!";

        }
        return null;
    }

    @Override
    public ArrayList<PredmetDTO> getPredmetiKojiNePripadajuSmeru(Long idSmera) {
        List<Predmet> predmeti = predmetRepository.findAll();
        Smer smer = smerService.findSmer(idSmera);

        ArrayList<Predmet> predmetiSmera = new ArrayList<>();
        for(SmerPredmet smerPredmet : smer.getPredmeti()){
            predmetiSmera.add(smerPredmet.getPredmet());
        }

        predmeti.removeAll(predmetiSmera);
        ArrayList<PredmetDTO> predmetDTOS = new ArrayList<>();

        for(Predmet predmet:predmeti){
            predmetDTOS.add(new PredmetDTO(predmet));
        }

        return predmetDTOS;
    }

    @Override
    public Predmet findPredmet(Long id) {
        return predmetRepository.findById(id).orElse(null);
    }

    @Override
    public PredmetDTO updatePredmet(PredmetDTO predmetDTO) {
        Predmet predmet = predmetRepository.getOne(predmetDTO.getId());
        predmet.setNaziv(predmetDTO.getNaziv());
        predmet.setKategorija(KategorijaPredmeta.valueOf(predmetDTO.getKategorija()));
        predmet = predmetRepository.save(predmet);
        return new PredmetDTO(predmet);
    }

    @Override
    public String proveriDaLiMozeBitiObrisan(Long id) {
        String ret ="";

        if(predmetRepository.getOne(id).getSmerovi().size()>0) {
            ret = "Predmet ne moze biti obrisan jer se predaje na: ";

            for(SmerPredmet smerPredmet:predmetRepository.getOne(id).getSmerovi()){
                ret += smerPredmet.getSmer().getNaziv()+", ";
            }
            ret = ret.substring(0,ret.length()-2);
            return ret;
        }
        return null;
    }

    @Override
    public void deletePredmet(Long id) {
        Predmet predmet = predmetRepository.getOne(id);
        predmetRepository.delete(predmet);
    }
}
