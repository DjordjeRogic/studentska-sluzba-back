package ftn.diplomski.studentskasluzbaback.enumeration;

public enum ObrazovnoPolje {
    INT("Interdisciplinarno"),TTN("Tehnicko tehnoloske nauke");

    private final String fieldDescription;

    ObrazovnoPolje(String value) {
        fieldDescription = value;
    }

    public String getFieldDescription() {
        return fieldDescription;
    }
}
