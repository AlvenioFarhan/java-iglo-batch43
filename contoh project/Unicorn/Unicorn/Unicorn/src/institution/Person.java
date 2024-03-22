package institution;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public abstract class Person {
    private String namaDepan;
    private String namaBelakang;
    private LocalDate tanggalLahir;
    private String kotaLahir;
    private Gender jenisKelamin;
    private String nomorKtp;
    private Religion agama;
    private BloodType golonganDarah;

    public Person() {
    }

    public Person(String namaDepan, String namaBelakang, LocalDate tanggalLahir, String kotaLahir, Gender jenisKelamin, String nomorKtp, Religion agama, BloodType golonganDarah) {
        this.namaDepan = namaDepan;
        this.namaBelakang = namaBelakang;
        this.tanggalLahir = tanggalLahir;
        this.kotaLahir = kotaLahir;
        this.jenisKelamin = jenisKelamin;
        this.nomorKtp = nomorKtp;
        this.agama = agama;
        this.golonganDarah = golonganDarah;
    }

    public String getNamaDepan() {
        return namaDepan;
    }

    public void setNamaDepan(String namaDepan) {
        this.namaDepan = namaDepan;
    }

    public String getNamaBelakang() {
        return namaBelakang;
    }

    public void setNamaBelakang(String namaBelakang) {
        this.namaBelakang = namaBelakang;
    }

    public String getNamaLengkap(){
        return String.format("%s %s", namaDepan, namaBelakang);
    }

    public LocalDate getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(LocalDate tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public Long getUmur(){
        return ChronoUnit.YEARS.between(tanggalLahir, LocalDate.now());
    }

    public String getKotaLahir() {
        return kotaLahir;
    }

    public void setKotaLahir(String kotaLahir) {
        this.kotaLahir = kotaLahir;
    }

    public String getInformasiKelahiran(){
        var formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        return String.format("%s, %s (%s tahun)",
            kotaLahir, formatter.format(tanggalLahir), getUmur());
    }

    public Gender getJenisKelamin() {
        return jenisKelamin;
    }

    public String getLabelJenisKelamin(){
        return jenisKelamin.getLabel();
    }

    public void setJenisKelamin(Gender jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public void setJenisKelaminByHuruf(String kode){
        switch (kode.toUpperCase()){
            case "L":
                jenisKelamin = Gender.L;
                break;
            case "P":
                jenisKelamin = Gender.P;
                break;
            default:
                System.out.println("Input salah, yang diterima hanya L/P");
                break;
        }
    }

    public String getNomorKtp() {
        return nomorKtp;
    }

    public void setNomorKtp(String nomorKtp) {
        this.nomorKtp = nomorKtp;
    }

    public Religion getAgama() {
        return agama;
    }

    public String getLabelAgama(){
        return agama.getLabel();
    }

    public void setAgama(Religion agama) {
        this.agama = agama;
    }

    public BloodType getGolonganDarah() {
        return golonganDarah;
    }

    public void setGolonganDarah(BloodType golonganDarah) {
        this.golonganDarah = golonganDarah;
    }

    public void printDetail(){
        System.out.printf("First Name: %s\nLast Name: %s\nGender: %s\nBirth Information: %s\nReligion: %s\nBlood Type: %s\nID Card: %s\n",
            namaDepan, namaBelakang, getLabelJenisKelamin(), getInformasiKelahiran(),
            getLabelAgama(), golonganDarah.toString(), nomorKtp);
    }

    public abstract void printSummary();
}
