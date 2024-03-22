public enum JenisProduk {

    KH("Kesehatan"),
    JW("Jiwa"),
    KR("Kendaraan");

    private String label;

    JenisProduk(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
