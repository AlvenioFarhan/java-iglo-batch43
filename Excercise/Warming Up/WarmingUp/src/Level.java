public enum Level {
    CHROME("Chrome"),
    SILVER("Silver"),
    GOLD("Gold"),
    PLATINUM("Platinum");

    private String label;

    Level(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
