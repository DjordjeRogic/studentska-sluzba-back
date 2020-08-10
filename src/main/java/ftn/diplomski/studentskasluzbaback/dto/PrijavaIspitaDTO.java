package ftn.diplomski.studentskasluzbaback.dto;

import java.util.ArrayList;

public class PrijavaIspitaDTO {
    ArrayList<IspitStudentDTO> ispiti;

    public PrijavaIspitaDTO(ArrayList<IspitStudentDTO> ispiti) {
        this.ispiti = ispiti;
    }

    public PrijavaIspitaDTO() {
    }

    public ArrayList<IspitStudentDTO> getIspiti() {
        return ispiti;
    }

    public void setIspiti(ArrayList<IspitStudentDTO> ispiti) {
        this.ispiti = ispiti;
    }
}
