public enum EmployeementStatus {
    PERMANENT("Permanent", true),
    CONTRACT("Contract", false),
    PART_TIME("Part Time", true),
    CASUAL("Casual", false);

    private String label;
    private Boolean isGetBonus;

    EmployeementStatus(String label, Boolean isGetBonus) {
        this.label = label;
        this.isGetBonus = isGetBonus;
    }

    public String getLabel() {
        return label;
    }

    public Boolean getGetBonus() {
        return isGetBonus;
    }
}
