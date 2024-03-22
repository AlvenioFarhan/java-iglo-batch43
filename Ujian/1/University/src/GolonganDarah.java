public enum GolonganDarah {
    AB("AB"),
    A("A"),
    B("B"),
    O("O");

    private String label;

    GolonganDarah(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
