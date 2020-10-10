package ftn.diplomski.studentskasluzbaback.controller;


import ftn.diplomski.studentskasluzbaback.dto.PredmetDTO;
import ftn.diplomski.studentskasluzbaback.dto.ProfesorDTO;
import ftn.diplomski.studentskasluzbaback.service.impl.PredmetServiceImpl;
import ftn.diplomski.studentskasluzbaback.service.impl.ProfesorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/predmet", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class PredmetController {
    @Autowired
    private PredmetServiceImpl predmetService;

    @PreAuthorize("hasAuthority('read_all_predmets')")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getPredmeti() {
        return new ResponseEntity<>(predmetService.getAllPredmets(), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('create_predmet')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> postPredmet(@RequestBody PredmetDTO predmetDTO) {
        String checkMessage = predmetService.checkNewPredmet(predmetDTO);
        if(checkMessage != null){
            return new ResponseEntity<>(checkMessage, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(predmetService.saveNewPredmet(predmetDTO), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('update_predmet')")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updatePredmet(@RequestBody PredmetDTO predmetDTO) {
        String checkMessage = predmetService.checkNewPredmet(predmetDTO);
        if(checkMessage != null){
            return new ResponseEntity<>(checkMessage, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(predmetService.updatePredmet(predmetDTO), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('delete_predmet')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deletePredmet(@PathVariable("id") Long id) {
        String checkMessage = predmetService.proveriDaLiMozeBitiObrisan(id);
        if(checkMessage != null){
            return new ResponseEntity<>(checkMessage, HttpStatus.BAD_REQUEST);
        }
        predmetService.deletePredmet(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('read_predmet_not_beloning_to_smer')")
    @GetMapping(value="/nePripadaSmeru/{id_smera}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getPredmetiKojiNePripadajuSmeru(@PathVariable("id_smera")Long id) {
        return new ResponseEntity<>(predmetService.getPredmetiKojiNePripadajuSmeru(id), HttpStatus.OK);
    }
}
