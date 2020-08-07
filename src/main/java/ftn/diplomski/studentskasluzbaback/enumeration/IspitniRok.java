package ftn.diplomski.studentskasluzbaback.enumeration;

public enum IspitniRok {
    JAN("Januarski"),FEB("Februarski"),APR("Aprilski"),JUN("Junski"),JUL("Julski"),SEP("Septembarski"),OKT("Oktobarski"),DO("Dodatni");

    private final String fieldDescription;

    IspitniRok(String value) {
        fieldDescription = value;
    }

    public String getFieldDescription() {
        return fieldDescription;
    }
}
