package institution;

public enum Religion {
    ISLAM("Islam"),
    KATOLIK("Kristen Katolik"),
    PROTESTAN("Kristen Protestan"),
    BUDDHA("Buddha"),
    HINDU("Hindu"),
    KONGHUCHU("Konghuchu");

    private String label;

    Religion(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
