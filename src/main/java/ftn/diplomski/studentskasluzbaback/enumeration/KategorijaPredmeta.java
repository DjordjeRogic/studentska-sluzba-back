package ftn.diplomski.studentskasluzbaback.enumeration;

public enum KategorijaPredmeta {
    AO("Akademsko-opsteobrazovani"),TM("Teorijsko-metodoloski"),NS("Nucno-strucni"),SA("Strucno-aplikativni");

    private final String fieldDescription;

    KategorijaPredmeta(String value) {
        fieldDescription = value;
    }

    public String getFieldDescription() {
        return fieldDescription;
    }
}
