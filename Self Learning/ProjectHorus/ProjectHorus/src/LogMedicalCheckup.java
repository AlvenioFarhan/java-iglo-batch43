import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;

public class LogMedicalCheckup {
private String namaPasien;
private LocalDateTime tanggalCheckUp;
private Integer durasi;
private String namaDokter;
private String jenisPelayanan;

    public LogMedicalCheckup(String namaPasien, Integer durasi, LocalDateTime tanggalCheckUp, String namaDokter) {
        this.namaPasien = namaPasien;
        this.tanggalCheckUp = tanggalCheckUp;
        this.durasi = durasi;
        this.namaDokter = namaDokter;
    }

    public LogMedicalCheckup(String namaPasien, LocalDateTime tanggalCheckUp, Integer durasi, String namaDokter, String jenisPelayanan) {
        this.namaPasien = namaPasien;
        this.tanggalCheckUp = tanggalCheckUp;
        this.durasi = durasi;
        this.namaDokter = namaDokter;
        this.jenisPelayanan = jenisPelayanan;
    }

    public String getNamaPasien() {
        return namaPasien;
    }

    public void setNamaPasien(String namaPasien) {
        this.namaPasien = namaPasien;
    }

    public LocalDateTime getTanggalCheckUp() {
        return tanggalCheckUp;
    }

    public void setTanggalCheckUp(LocalDateTime tanggalCheckUp) {
        this.tanggalCheckUp = tanggalCheckUp;
    }

    public Integer getDurasi() {
        return durasi;
    }

    public void setDurasi(Integer durasi) {
        this.durasi = durasi;
    }

    public String getNamaDokter() {
        return namaDokter;
    }

    public void setNamaDokter(String namaDokter) {
        this.namaDokter = namaDokter;
    }

    public String getJenisPelayanan() {
        return jenisPelayanan;
    }

    public void setJenisPelayanan(String jenisPelayanan) {
        this.jenisPelayanan = jenisPelayanan;
    }

    public LocalDateTime getTanggalSelesai(){
        LocalDateTime dateTimeTambahDurasi = tanggalCheckUp.plusMinutes(durasi);
        return dateTimeTambahDurasi;
    }
}
