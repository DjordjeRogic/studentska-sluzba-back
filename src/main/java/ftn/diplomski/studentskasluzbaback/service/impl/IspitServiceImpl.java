package ftn.diplomski.studentskasluzbaback.service.impl;

import ftn.diplomski.studentskasluzbaback.dto.IspitDTO;
import ftn.diplomski.studentskasluzbaback.dto.IspitProfesorDTO;
import ftn.diplomski.studentskasluzbaback.dto.StudentRezultatDTO;
import ftn.diplomski.studentskasluzbaback.enumeration.IspitniRok;
import ftn.diplomski.studentskasluzbaback.model.*;
import ftn.diplomski.studentskasluzbaback.repository.IspitRepository;
import ftn.diplomski.studentskasluzbaback.service.*;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

@Service
public class IspitServiceImpl implements IspitService {

    @Autowired
    private IspitRepository ispitRepository;

    @Autowired
    private SmerPredmetService smerPredmetService;

    @Autowired
    private SkolskaGodinaService skolskaGodinaService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private ProfesorService  profesorService;

    @Override
    public IspitDTO saveNewIspit(IspitDTO ispitDTO) {
        SmerPredmet smerPredmet = smerPredmetService.findOne(ispitDTO.getProgramId());
        SkolskaGodina skolskaGodina = skolskaGodinaService.getTrenutnaSkolskaGodina();


        Ispit ispit = new Ispit();

        ispit.setDatum(LocalDate.parse(ispitDTO.getDatum()));
        ispit.setMestoOdrzavanja(ispitDTO.getMestoOdrzavanja());
        ispit.setSkolskaGodina(skolskaGodina);
        ispit.setSmerPredmet(smerPredmet);
        ispit.setRok(IspitniRok.valueOf(ispitDTO.getRok()));
        if(!ispitDTO.getVremeOdrzavanja().isEmpty())
            ispit.setVremeOdrzavanja(LocalTime.parse(ispitDTO.getVremeOdrzavanja()));

        Profesor profesor = profesorService.findProfesor(ispitDTO.getProfesor().getId());
        ispit.setProfesor(profesor);
        Ispit saved = ispitRepository.save(ispit);
        ispitDTO.setId(saved.getId());

        return new IspitDTO(saved);
    }

    @Override
    public String checkNewIspit(IspitDTO ispitDTO) {
        SmerPredmet smerPredmet = smerPredmetService.findOne(ispitDTO.getProgramId());
        SkolskaGodina skolskaGodina = skolskaGodinaService.getTrenutnaSkolskaGodina();

        if(ispitDTO.getRok() == null){
            return "Rok mora biti izabran.";
        }

        if(ispitDTO.getId() == null) {
            for (Ispit ispit : smerPredmet.getIspiti()) {
                if (ispit.getDatum().isAfter(skolskaGodina.getPocetakGodine()) && ispit.getDatum().isBefore(skolskaGodina.getKrajGodine()) && ispit.getRok().equals(IspitniRok.valueOf(ispitDTO.getRok()))) {
                    return "Ispit u tom roku vec postoji!";
                }
            }
        }else{
            Ispit ispitExists= ispitRepository.getOne(ispitDTO.getId());
            for (Ispit ispit : smerPredmet.getIspiti()) {

                if(ispit.equals(ispitExists))
                    continue;

                if (ispit.getDatum().isAfter(skolskaGodina.getPocetakGodine()) && ispit.getDatum().isBefore(skolskaGodina.getKrajGodine()) && ispit.getRok().equals(IspitniRok.valueOf(ispitDTO.getRok()))) {
                    return "Ispit u tom roku vec postoji!";
                }
            }
        }

        IspitniRok ispitniRok = IspitniRok.valueOf(ispitDTO.getRok());
        LocalDate localDate = LocalDate.parse(ispitDTO.getDatum());

        if(ispitDTO.getRok().equals(IspitniRok.JAN.toString()) || ispitDTO.getRok().equals(IspitniRok.FEB.toString())){
            if(localDate.getMonthValue() >2){
                return "Ispit u januarsko-februarskom roku se moze zakazati samo u januaru ili februaru";
            }
        }

        if(ispitDTO.getRok().equals(IspitniRok.APR.toString())){
            if(localDate.getMonthValue() != 4 ){
                return "Ispit u aprilskom roku se moze zakazati samo u aprilu";
            }
        }

        if(ispitDTO.getRok().equals(IspitniRok.JUN.toString()) || ispitDTO.getRok().equals(IspitniRok.JUL.toString())){
            if(localDate.getMonthValue() <6 || localDate.getMonthValue() > 7 ){
                return "Ispit u junsko-julskom roku se moze zakazati samo u junu ili julu";
            }
        }
        if(ispitDTO.getRok().equals(IspitniRok.SEP.toString()) ){
            if(localDate.getMonthValue() <8  || localDate.getMonthValue() >9 ){
                return "Ispit u septembarskom roku se moze zakazati samo u avgustu ili septembru";
            }
        }
        if(ispitDTO.getRok().equals(IspitniRok.OKT.toString()) ){
            if(localDate.getMonthValue() <9  || localDate.getMonthValue() >9 ){
                return "Ispit u oktobarskom roku se moze zakazati samo u septembru";
            }
        }
        return null;
    }

    @Override
    public Ispit getOne(Long id) {
        return ispitRepository.getOne(id);
    }

    @Override
    public IspitProfesorDTO updateIspitProfesor(IspitProfesorDTO ispitProfesorDTO) {
        Ispit ispit =ispitRepository.getOne(ispitProfesorDTO.getId());

        if(!ispitProfesorDTO.getVremeOdrzavanja().isEmpty())
            ispit.setVremeOdrzavanja(LocalTime.parse(ispitProfesorDTO.getVremeOdrzavanja()));
        ispit.setMestoOdrzavanja(ispitProfesorDTO.getMestoOdrzavanja());
        ispit=ispitRepository.save(ispit);
        return new IspitProfesorDTO(ispit);
    }

    @Override
    public ArrayList<StudentRezultatDTO> getStudenteZaRezultate(Long id) {
        Ispit ispit = ispitRepository.getOne(id);
        ArrayList<StudentRezultatDTO> studentRezultatDTOS = new ArrayList<>();


        ArrayList<Student> studenti = new ArrayList<>();
        studenti.addAll(ispit.getStudentiKojiSuPrijavili());


        studenti.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getBrojIndexa().compareTo(o2.getBrojIndexa());
            }
        });

        for(Student student: studenti){
            studentRezultatDTOS.add(new StudentRezultatDTO(student));
        }
        return studentRezultatDTOS;
    }

    @Override
    public Ispit saveIspit(Ispit ispit) {
        return ispitRepository.save(ispit);
    }

    @Override
    public byte[] downloadStudenteZaRezultate(Long id_ispita) throws IOException {

        Ispit ispit = ispitRepository.getOne(id_ispita);
        ArrayList<StudentRezultatDTO> studenti = getStudenteZaRezultate(id_ispita);

        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Ispit_"+ispit.getSmerPredmet().getSmer()+"_"+ispit.getSmerPredmet().getPredmet()+"_"+ispit.getDatum());

        HSSFRow rowhead = sheet.createRow(0);
        rowhead.createCell(0).setCellValue("Ime");
        rowhead.createCell(1).setCellValue("Prezime");
        rowhead.createCell(2).setCellValue("Broj indexa");
        rowhead.createCell(3).setCellValue("Bodovi");

        int index = 1;
        for(StudentRezultatDTO student: studenti){
            HSSFRow row = sheet.createRow(index);
            row.createCell(0).setCellValue(student.getName());
            row.createCell(1).setCellValue(student.getSurname());
            row.createCell(2).setCellValue(student.getBrojIndexa());
            row.createCell(3).setCellValue(0);
            index++;
        }

        workbook.write(stream);
        workbook.close();

        return stream.toByteArray();
    }

    @Override
    public ArrayList<StudentRezultatDTO> uploadStudenteZaRezultate(Long id_ispita, MultipartFile file) throws IOException {
        Ispit ispit = ispitRepository.getOne(id_ispita);
        ArrayList<StudentRezultatDTO> studenti = getStudenteZaRezultate(id_ispita);

        HSSFWorkbook rezultati = new HSSFWorkbook(file.getInputStream());

        HSSFSheet sheet = rezultati.getSheetAt(0);
        HSSFRow row = sheet.getRow(0);

        String brojIndexa="";
        double bodovi=0;
        HSSFCell cell =row.getCell(0);
        Iterator<Row> rowIterator = sheet.iterator();
        rowIterator.next();
        while (rowIterator.hasNext()){
            row= (HSSFRow) rowIterator.next();

            //ako nema broja indexa ili bodova preskoci
            if(row.getCell(2) == null || row.getCell(3) == null)
                continue;

            brojIndexa = row.getCell(2).getStringCellValue();
            bodovi = row.getCell(3).getNumericCellValue();

            //nesipravan broj bodova preskoci
            if(bodovi > 100 || bodovi<0)
                continue;

            for(StudentRezultatDTO student: studenti){
                if(student.getBrojIndexa().equals(brojIndexa)){
                    student.setBodovi(bodovi);
                    break;
                }
            }

        }
        return studenti;
    }

    @Override
    public String checkRemoveIspti(Long id) {
        Ispit ispit = ispitRepository.getOne(id);
        if(ispit.getStudentiKojiSuPrijavili().size()>0){
            return "Ispit ne moze biti obrisan jer postoje studenti koji su ga prijavili!";
        }
        return null;
    }

    @Override
    public IspitDTO updateIspit(IspitDTO ispitDTO) {
        Ispit ispit =ispitRepository.getOne(ispitDTO.getId());
        ispit.setDatum(LocalDate.parse(ispitDTO.getDatum()));
        if(!ispitDTO.getVremeOdrzavanja().isEmpty())
            ispit.setVremeOdrzavanja(LocalTime.parse(ispitDTO.getVremeOdrzavanja()));
        ispit.setMestoOdrzavanja(ispitDTO.getMestoOdrzavanja());
        Profesor profesor = profesorService.findProfesor(ispitDTO.getProfesor().getId());
        ispit.setProfesor(profesor);
        ispit = ispitRepository.save(ispit);
        return new IspitDTO(ispit);
    }

    @Override
    public void removeIspit(Long id_ispita) {
        ispitRepository.delete(ispitRepository.getOne(id_ispita));
    }
}
