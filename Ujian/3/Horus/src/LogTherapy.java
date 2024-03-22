import java.time.LocalDateTime;

public class LogTherapy {

    private String idPatient;
    private Integer durasi;
    private LocalDateTime tanggalMasukTreatment;
    private String namaTreatment;
    private String namaTherapyst;


    public LogTherapy() {
    }

    public LogTherapy(String idPatient, Integer durasi, String namaTreatment, String namaTherapyst) {
        this.idPatient = idPatient;
        this.durasi = durasi;
        this.namaTreatment = namaTreatment;
        this.namaTherapyst = namaTherapyst;
    }

    public LogTherapy(String idPatient, Integer durasi, LocalDateTime tanggalMasukTreatment, String namaTreatment, String namaTherapyst) {
        this.idPatient = idPatient;
        this.durasi = durasi;
        this.tanggalMasukTreatment = tanggalMasukTreatment;
        this.namaTreatment = namaTreatment;
        this.namaTherapyst = namaTherapyst;
    }

    public String getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(String idPatient) {
        this.idPatient = idPatient;
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

    public String getNamaTreatment() {
        return namaTreatment;
    }

    public void setNamaTreatment(String namaTreatment) {
        this.namaTreatment = namaTreatment;
    }

    public String getNamaTherapyst() {
        return namaTherapyst;
    }

    public void setNamaTherapyst(String namaTherapyst) {
        this.namaTherapyst = namaTherapyst;
    }
}
