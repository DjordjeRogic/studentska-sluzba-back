package ftn.diplomski.studentskasluzbaback.controller;


import ftn.diplomski.studentskasluzbaback.dto.PredmetDTO;
import ftn.diplomski.studentskasluzbaback.dto.ProfesorDTO;
import ftn.diplomski.studentskasluzbaback.service.impl.PredmetServiceImpl;
import ftn.diplomski.studentskasluzbaback.service.impl.ProfesorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/predmet", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class PredmetController {
    @Autowired
    private PredmetServiceImpl predmetService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getPredmeti() {
        return new ResponseEntity<>(predmetService.getAllPredmets(), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> postPredmet(@RequestBody PredmetDTO predmetDTO) {
        String checkMessage = predmetService.checkNewPredmet(predmetDTO);
        if(checkMessage != null){
            return new ResponseEntity<>(checkMessage, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(predmetService.saveNewPredmet(predmetDTO), HttpStatus.OK);
    }


    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updatePredmet(@RequestBody PredmetDTO predmetDTO) {
        String checkMessage = predmetService.checkNewPredmet(predmetDTO);
        if(checkMessage != null){
            return new ResponseEntity<>(checkMessage, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(predmetService.updatePredmet(predmetDTO), HttpStatus.OK);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deletePredmet(@PathVariable("id") Long id) {
        String checkMessage = predmetService.proveriDaLiMozeBitiObrisan(id);
        if(checkMessage != null){
            return new ResponseEntity<>(checkMessage, HttpStatus.BAD_REQUEST);
        }
        predmetService.deletePredmet(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @GetMapping(value="/nePripadaSmeru/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getPredmetiKojiNePripadajuSmeru(@PathVariable("id")Long id) {
        return new ResponseEntity<>(predmetService.getPredmetiKojiNePripadajuSmeru(id), HttpStatus.OK);
    }
}
