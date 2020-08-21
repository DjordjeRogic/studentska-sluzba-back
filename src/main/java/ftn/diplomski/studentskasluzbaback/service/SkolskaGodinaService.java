package ftn.diplomski.studentskasluzbaback.service;

import ftn.diplomski.studentskasluzbaback.model.SkolskaGodina;

public interface SkolskaGodinaService {

    SkolskaGodina getTrenutnaSkolskaGodina();

    SkolskaGodina save(SkolskaGodina novaSkolskaGodina);
}
