import java.time.LocalDateTime;

public class LogMedicalCheckup {
    private String idPatient;
    private Integer durasi;
    private LocalDateTime tanggalMasukTreatment;
    private String namaDokter;
    private String medicalCheckup;

    public LogMedicalCheckup() {
    }

    public LogMedicalCheckup(String idPatient, Integer durasi, String namaDokter, String medicalCheckup) {
        this.idPatient = idPatient;
        this.durasi = durasi;
        this.namaDokter = namaDokter;
        this.medicalCheckup = medicalCheckup;
    }

    public LogMedicalCheckup(String patient, Integer durasi, LocalDateTime tanggalMasukTreatment, String namaDokter, String  medicalCheckup) {
        this.idPatient = patient;
        this.durasi = durasi;
        this.tanggalMasukTreatment = tanggalMasukTreatment;
        this.namaDokter = namaDokter;
        this.medicalCheckup = medicalCheckup;
    }

    public String getPatient() {
        return idPatient;
    }

    public void setPatient(String  patient) {
        this.idPatient = patient;
    }

    public Integer getDurasi() {
        return durasi;
    }

    public void setDurasi(Integer durasi) {
        this.durasi = durasi;
    }

    public LocalDateTime getTanggalMasukTreatment() {
        return tanggalMasukTreatment;
    }

    public void setTanggalMasukTreatment(LocalDateTime tanggalMasukTreatment) {
        this.tanggalMasukTreatment = tanggalMasukTreatment;
    }

    public String getNamaDokter() {
        return namaDokter;
    }

    public void setNamaDokter(String namaDokter) {
        this.namaDokter = namaDokter;
    }

    public String  getMedicalCheckup() {
        return medicalCheckup;
    }

    public void setMedicalCheckup(String medicalCheckup) {
        this.medicalCheckup = medicalCheckup;
    }
}
