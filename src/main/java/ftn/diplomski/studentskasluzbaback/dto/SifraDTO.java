package ftn.diplomski.studentskasluzbaback.dto;

public class SifraDTO {
    private String potvrda;
    private String trenutnaSifra;
    private String novaSifra;

    public SifraDTO() {
    }

    public SifraDTO(String potvrda, String trenutnaSifra, String novaSifra) {
        this.potvrda = potvrda;
        this.trenutnaSifra = trenutnaSifra;
        this.novaSifra = novaSifra;
    }

    public String getPotvrda() {
        return potvrda;
    }

    public void setPotvrda(String potvrda) {
        this.potvrda = potvrda;
    }

    public String getTrenutnaSifra() {
        return trenutnaSifra;
    }

    public void setTrenutnaSifra(String trenutnaSifra) {
        this.trenutnaSifra = trenutnaSifra;
    }

    public String getNovaSifra() {
        return novaSifra;
    }

    public void setNovaSifra(String novaSifra) {
        this.novaSifra = novaSifra;
    }
}
