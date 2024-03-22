public enum Relligion {
    ISLAM("Islam"),
    KRISTEN_KATOLIK("Kristen Katolik"),
    KRISTEN_PROTESTAN("Kristen Protestan"),
    BUDDHA("Buddha"),
    HINDU("Hindu"),
    KONGHUCHU("Konghuchu");

    private String label;

    Relligion(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
