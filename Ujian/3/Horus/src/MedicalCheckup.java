public class MedicalCheckup {
    private String codeMedicalCheckup;
    private String namaMedicalCheckup;

    public MedicalCheckup() {
    }

    public MedicalCheckup(String namaMedicalCheckup) {
        this.namaMedicalCheckup = namaMedicalCheckup;
    }

    public MedicalCheckup(String codeMedicalCheckup, String namaMedicalCheckup) {
        this.codeMedicalCheckup = codeMedicalCheckup;
        this.namaMedicalCheckup = namaMedicalCheckup;
    }

    public String getCodeMedicalCheckup() {
        return codeMedicalCheckup;
    }

    public void setCodeMedicalCheckup(String codeMedicalCheckup) {
        this.codeMedicalCheckup = codeMedicalCheckup;
    }

    public String getNamaMedicakCheckup() {
        return namaMedicalCheckup;
    }

    public void setNamaMedicakCheckup(String namaMedicalCheckup) {
        this.namaMedicalCheckup = namaMedicalCheckup;
    }

    public void printAllMedicalCheckup(){
        System.out.printf("Code: %s, Name: %s\n", codeMedicalCheckup, namaMedicalCheckup);
    }
}
