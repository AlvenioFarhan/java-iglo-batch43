public enum Agama {
    ISLAM("Islam"),
    KRISTEN("Kristen"),
    HINDU("Hindu"),
    BUDDHA("Buddha"),
    KONGHUCU("Konghucu");

    private String label;

    Agama(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
