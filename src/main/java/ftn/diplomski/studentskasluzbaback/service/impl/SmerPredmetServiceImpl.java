package ftn.diplomski.studentskasluzbaback.service.impl;

import ftn.diplomski.studentskasluzbaback.dto.*;
import ftn.diplomski.studentskasluzbaback.enumeration.IspitniRok;
import ftn.diplomski.studentskasluzbaback.model.*;
import ftn.diplomski.studentskasluzbaback.repository.SmerPredmetRepository;
import ftn.diplomski.studentskasluzbaback.service.*;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

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

    @Autowired
    private StudentService studentService;

    @Autowired
    private OcenaService ocenaService;

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
                        if(ispit.getDatum().isAfter(LocalDate.now()) && ispit.getDatum().isBefore(minDate))
                            ispits.add(ispit);
                    }
                }
                //APRIL
                if(month == 4){
                    if(ispit.getRok().equals(IspitniRok.APR)){
                        if(ispit.getDatum().isAfter(LocalDate.now()) && ispit.getDatum().isBefore(minDate))
                            ispits.add(ispit);
                    }
                }
                //JUN-JUL
                if(month > 5 && month<8 ){
                    if(ispit.getRok().equals(IspitniRok.JUN) || ispit.getRok().equals(IspitniRok.JUL)){
                        if(ispit.getDatum().isAfter(LocalDate.now()) && ispit.getDatum().isBefore(minDate))
                            ispits.add(ispit);
                    }
                }
                //AVGUST
                if(month > 7 && month<9 ){
                    if(ispit.getRok().equals(IspitniRok.AVG)){
                        if(ispit.getDatum().isAfter(LocalDate.now()) && ispit.getDatum().isBefore(minDate))
                            ispits.add(ispit);
                    }
                }
                //SEPTEMBAR
                if(month > 7 && month<10 ){
                    if(ispit.getRok().equals(IspitniRok.JUN) || ispit.getRok().equals(IspitniRok.JUL)){
                        if(ispit.getDatum().isAfter(LocalDate.now()) && ispit.getDatum().isBefore(minDate))
                            ispits.add(ispit);
                    }
                }
                //OKTOBAR
                if(month > 8 ){
                    if(ispit.getRok().equals(IspitniRok.JUN) || ispit.getRok().equals(IspitniRok.JUL)){
                        if(ispit.getDatum().isAfter(LocalDate.now()) && ispit.getDatum().isBefore(minDate))
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

    @Override
    public ArrayList<StudentDolasciDTO> getStudentiDolasci(Long id) {
        SmerPredmet smerPredmet = smerPredmetRepository.getOne(id);
        ArrayList<StudentDolasciDTO> studentDTOS = new ArrayList<>();
        for(Student student: smerPredmet.getSmer().getStudenti()){
            if(student.getSemestar() == smerPredmet.getSemestar()){
                for(Ocena ocena : student.getOcene()) {
                    if(ocena.getSmerPredmet().equals(smerPredmet)) {
                        studentDTOS.add(new StudentDolasciDTO(ocena));
                        break;
                    }
                }
            }
        }
        return studentDTOS;
    }

    @Override
    public byte[] downloadStudenteZaDolaske(Long id) throws IOException {
        SmerPredmet smerPredmet = smerPredmetRepository.getOne(id);
        ArrayList<StudentDolasciDTO> studenti = getStudentiDolasci(id);

        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Dolasci_"+smerPredmet.getSmer().getNaziv()+"_"+smerPredmet.getPredmet().getNaziv());

        HSSFRow rowhead = sheet.createRow(0);
        rowhead.createCell(0).setCellValue("Ime");
        rowhead.createCell(1).setCellValue("Prezime");
        rowhead.createCell(2).setCellValue("Broj indexa");
        rowhead.createCell(3).setCellValue("Dolasci");

        int index = 1;
        for(StudentDolasciDTO student: studenti){
            HSSFRow row = sheet.createRow(index);
            row.createCell(0).setCellValue(student.getName());
            row.createCell(1).setCellValue(student.getSurname());
            row.createCell(2).setCellValue(student.getBrojIndexa());
            row.createCell(3).setCellValue(student.getBrojDolazaka());
            index++;
        }

        workbook.write(stream);
        workbook.close();

        return stream.toByteArray();
    }

    @Override
    public ArrayList<StudentDolasciDTO> uploadStudenteZaDolaske(Long id, MultipartFile file) throws IOException {
        System.out.println("UPLOAD");
        SmerPredmet smerPredmet = smerPredmetRepository.getOne(id);
        ArrayList<StudentDolasciDTO> studenti = getStudentiDolasci(id);

        HSSFWorkbook rezultati = new HSSFWorkbook(file.getInputStream());

        HSSFSheet sheet = rezultati.getSheetAt(0);
        HSSFRow row = sheet.getRow(0);

        System.out.println(row.getCell(0));
        System.out.println(row.getCell(1));
        System.out.println(row.getCell(2));
        System.out.println(row.getCell(3));

        String brojIndexa="";
        int dolasci=0;
        HSSFCell cell =row.getCell(0);
        Iterator<Row> rowIterator = sheet.iterator();
        rowIterator.next();
        while (rowIterator.hasNext()){
            row= (HSSFRow) rowIterator.next();

            //ako nema broja indexa ili bodova preskoci
            if(row.getCell(2) == null || row.getCell(3) == null)
                continue;

            brojIndexa = row.getCell(2).getStringCellValue();
            dolasci = (int) row.getCell(3).getNumericCellValue();

            System.out.println(row.getCell(0));
            System.out.println(row.getCell(1));
            System.out.println(row.getCell(2));
            System.out.println(row.getCell(3));

            //nesipravan broj bodova preskoci
            if(dolasci > smerPredmet.getBrojPredavanjaUGodini() || dolasci<0)
                continue;

            for(StudentDolasciDTO student: studenti){
                if(student.getBrojIndexa().equals(brojIndexa)){
                    student.setBrojDolazaka(dolasci);
                    break;
                }
            }

        }
        return studenti;
    }

    @Override
    public void unesiDolaske(Long id, ArrayList<StudentDolasciDTO> studentDolasciDTOS) {
        SmerPredmet smerPredmet = smerPredmetRepository.getOne(id);

        System.out.println("**DOLASCI**");

        for(StudentDolasciDTO studentDTO: studentDolasciDTOS){
            Student student = studentService.findStudent(studentDTO.getId());
            for(Ocena ocena : student.getOcene()){
                System.out.println(ocena.getId());
                System.out.println(ocena.getSmerPredmet().getPredmet().getNaziv());
                System.out.println(smerPredmet.getPredmet().getNaziv());
                System.out.println(ocena.getBrojDolazakaNaPredavanja());
                System.out.println(studentDTO.getBrojDolazaka());
                if(ocena.getSmerPredmet().equals(smerPredmet)){
                    ocena.setBrojDolazakaNaPredavanja(studentDTO.getBrojDolazaka());
                    ocenaService.save(ocena);
                    break;
                }
            }


        }
        System.out.println("**DOLASCI**");


    }

    @Override
    public String checkUpdate(SmerPredmetDTO smerPredmetDTO) {
        SmerPredmet smerPredmet = smerPredmetRepository.getOne(smerPredmetDTO.getId());


        if(smerPredmetRepository.findBySifraStudijskogPrograma(smerPredmet.getSifraStudijskogPrograma()) != null && smerPredmetRepository.findBySifraStudijskogPrograma(smerPredmet.getSifraStudijskogPrograma())!= smerPredmet){
            return "Studijski program sa tom sifrom vec postoji!";
        }


        return null;
    }

    @Override
    public SmerPredmetDTO update(SmerPredmetDTO smerPredmetDTO) {
        SmerPredmet smerPredmet = smerPredmetRepository.getOne(smerPredmetDTO.getId());
        smerPredmet.setSemestar(smerPredmetDTO.getSemestar());
        smerPredmet.setSifraStudijskogPrograma(smerPredmetDTO.getSifraStudijskogPrograma());
        smerPredmet.setBrojPredavanjaUGodini(smerPredmetDTO.getBrojPredavanjaUGodini());
        Profesor profesor = profesorService.findProfesor(smerPredmetDTO.getProfesor().getId());
        smerPredmet.setProfesor(profesor);

        smerPredmetRepository.save(smerPredmet);
        return smerPredmetDTO;
    }

    @Override
    public String checkDelete(Long id) {
        SmerPredmet smerPredmet = smerPredmetRepository.getOne(id);
        if (smerPredmet.getOcene().size() > 0)
        {
            return "Postoje studenti koji su polozili ili slusaju ovaj program pa on ne moze biti obrisan!";
        }

        if (smerPredmet.getIspiti().size() > 0)
        {
            return "Postoje ispiti na ovom programu pa on ne moze biti obrisan!";
        }
        return null;
    }

    @Override
    public void deleteSmerPredmet(Long id) {
        SmerPredmet smerPredmet = smerPredmetRepository.getOne(id);
        smerPredmetRepository.delete(smerPredmet);
    }

    @Override
    public void removeIspitOdPredmeta(Long id,Long id_ispita) {
        SmerPredmet smerPredmet = smerPredmetRepository.getOne(id);
        for(Ispit ispit: smerPredmet.getIspiti() ){
            if(ispit.getId() == id_ispita){
                smerPredmet.getIspiti().remove(ispit);
                break;
            }
        }
        
    }

}
