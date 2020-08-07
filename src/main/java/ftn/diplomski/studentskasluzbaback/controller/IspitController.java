package ftn.diplomski.studentskasluzbaback.controller;
import ftn.diplomski.studentskasluzbaback.dto.IspitDTO;
import ftn.diplomski.studentskasluzbaback.dto.PredmetDTO;
import ftn.diplomski.studentskasluzbaback.repository.IspitRepository;
import ftn.diplomski.studentskasluzbaback.service.IspitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/ispit", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class IspitController {

    @Autowired
    private IspitService ispitService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> postIspit(@RequestBody IspitDTO ispitDTO) {
        System.out.println("Add Ispit");

        if(ispitService.checkNewIspit(ispitDTO) != null){
            return new ResponseEntity<>(ispitService.checkNewIspit(ispitDTO), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(ispitService.saveNewIspit(ispitDTO), HttpStatus.OK);
    }
}
