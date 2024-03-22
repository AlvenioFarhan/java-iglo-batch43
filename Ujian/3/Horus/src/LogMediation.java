import java.time.LocalDateTime;

public class LogMediation {
    private String idPatient;
    private Integer durasi;
    private LocalDateTime tanggalMasukTreatment;
    private String namaMediation;
    private Integer quantityMediation;


    public LogMediation() {
    }

    public LogMediation(String idPatient, Integer durasi, String namaMediation, Integer quantityMediation) {
        this.idPatient = idPatient;
        this.durasi = durasi;
        this.namaMediation = namaMediation;
        this.quantityMediation = quantityMediation;
    }

    public LogMediation(String idPatient, Integer durasi, LocalDateTime tanggalMasukTreatment, String namaMediation, Integer quantityMediation) {
        this.idPatient = idPatient;
        this.durasi = durasi;
        this.tanggalMasukTreatment = tanggalMasukTreatment;
        this.namaMediation = namaMediation;
        this.quantityMediation = quantityMediation;
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

    public String getNamaMediation() {
        return namaMediation;
    }

    public void setNamaMediation(String namaMediation) {
        this.namaMediation = namaMediation;
    }

    public Integer getQuantityMediation() {
        return quantityMediation;
    }

    public void setQuantityMediation(Integer quantityMediation) {
        this.quantityMediation = quantityMediation;
    }
}
