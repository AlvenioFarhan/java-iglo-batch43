public enum StatusNasabah {
    PROSPECT("Prospect"),
    NASABAH("Nasabah");
    private String label;

    StatusNasabah(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
