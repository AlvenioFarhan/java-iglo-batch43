import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Pasien {

    private String idPasien;
    private String namaPasien;
    private LocalDate tanggalLahirPasien;
    private Long usiaPasien;

    public Pasien() {
    }

    public Pasien(String idPasien, String namaPasien, LocalDate tanggalLahirPasien) {
        this.idPasien = idPasien;
        this.namaPasien = namaPasien;
        this.tanggalLahirPasien = tanggalLahirPasien;
    }

    public Pasien(String idPasien, String namaPasien, LocalDate tanggalLahirPasien, Long usiaPasien) {
        this.idPasien = idPasien;
        this.namaPasien = namaPasien;
        this.tanggalLahirPasien = tanggalLahirPasien;
        this.usiaPasien = usiaPasien;
    }

    public String getIdPasien() {
        return idPasien;
    }

    public void setIdPasien(String idPasien) {
        this.idPasien = idPasien;
    }

    public String getNamaPasien() {
        return namaPasien;
    }

    public void setNamaPasien(String namaPasien) {
        this.namaPasien = namaPasien;
    }

    public LocalDate getTanggalLahirPasien() {
        return tanggalLahirPasien;
    }

    public void setTanggalLahirPasien(LocalDate tanggalLahirPasien) {
        this.tanggalLahirPasien = tanggalLahirPasien;
    }

    public Long getUsiaPasien() {
        return usiaPasien;
    }

    public void setUsiaPasien(Long usiaPasien) {
        this.usiaPasien = usiaPasien;
    }

    public Long dapatkanUsiaPasien() {
        Long hasil;
        hasil = ChronoUnit.YEARS.between(tanggalLahirPasien, LocalDate.now());
        return hasil;
    }
}
