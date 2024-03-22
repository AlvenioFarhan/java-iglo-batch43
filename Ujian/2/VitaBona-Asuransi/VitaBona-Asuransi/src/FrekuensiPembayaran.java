public enum FrekuensiPembayaran {

    B("Bulanan"),
    T("Tahunan");

    private String label;

    FrekuensiPembayaran(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
