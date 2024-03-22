package institution;

public enum Gender {
    L ("Laki-laki"),
    P ("Perempuan");

    private String label;

    Gender(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }


}
