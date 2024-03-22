import java.time.LocalDateTime;

public class LogTherapy {
    private String namaPasien;
    private Integer durasi;
    private LocalDateTime tanggalDatang;
    private String namaTreatment;
    private String namaTherapist;

    public LogTherapy(String namaPasien, Integer durasi, LocalDateTime tanggalDatang, String namaTreatment, String namaTherapist) {
        this.namaPasien = namaPasien;
        this.durasi = durasi;
        this.tanggalDatang = tanggalDatang;
        this.namaTreatment = namaTreatment;
        this.namaTherapist = namaTherapist;
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

    public String getNamaTreatment() {
        return namaTreatment;
    }

    public void setNamaTreatment(String namaTreatment) {
        this.namaTreatment = namaTreatment;
    }

    public String getNamaTherapist() {
        return namaTherapist;
    }

    public void setNamaTherapist(String namaTherapist) {
        this.namaTherapist = namaTherapist;
    }

    public LocalDateTime getTanggalSelesai(){
        LocalDateTime waktuTambahDurasi = tanggalDatang.plusMinutes(durasi);
        return waktuTambahDurasi;
    }
}
