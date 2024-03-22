import java.time.LocalDateTime;

public class LogMedication {
    private String namaPasien;
    private Integer durasi;
    private LocalDateTime tanggalDatang;
    private String namaMedication;
    private Integer quantityMedication;

    public LogMedication(String namaPasien, Integer durasi, LocalDateTime tanggalDatang, String namaMedication, Integer quantityMedication) {
        this.namaPasien = namaPasien;
        this.durasi = durasi;
        this.tanggalDatang = tanggalDatang;
        this.namaMedication = namaMedication;
        this.quantityMedication = quantityMedication;
    }

    public String getNamaPasien() {
        return namaPasien;
    }

    public void setNamaPasien(String namaPasien) {
        this.namaPasien = namaPasien;
    }

    public Integer getDurasi() {
        return durasi;
    }

    public void setDurasi(Integer durasi) {
        this.durasi = durasi;
    }

    public LocalDateTime getTanggalDatang() {
        return tanggalDatang;
    }

    public void setTanggalDatang(LocalDateTime tanggalDatang) {
        this.tanggalDatang = tanggalDatang;
    }

    public String getNamaMedication() {
        return namaMedication;
    }

    public void setNamaMedication(String namaMedication) {
        this.namaMedication = namaMedication;
    }

    public Integer getQuantityMedication() {
        return quantityMedication;
    }

    public void setQuantityMedication(Integer quantityMedication) {
        this.quantityMedication = quantityMedication;
    }

    public LocalDateTime getTanggalSelesai(){
        LocalDateTime jadwalTambahDurasi = tanggalDatang.plusMinutes(durasi);
        return jadwalTambahDurasi;
    }
}
