package institution;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Student extends Person{
    private String nik;
    private LocalDate tanggalMasuk;
    private LocalDate tanggalLulus;
    private List<Enrollment> enrollments = new ArrayList<>();

    public Student() {
        super();
    }

    public Student(String namaDepan, String namaBelakang, LocalDate tanggalLahir, String kotaLahir, Gender jenisKelamin, String nomorKtp, Religion agama, BloodType golonganDarah, String nik, LocalDate tanggalMasuk) {
        super(namaDepan, namaBelakang, tanggalLahir, kotaLahir, jenisKelamin, nomorKtp, agama, golonganDarah);
        this.nik = nik;
        this.tanggalMasuk = tanggalMasuk;
    }

    public Student(String namaDepan, String namaBelakang, LocalDate tanggalLahir, String kotaLahir, Gender jenisKelamin, String nomorKtp, Religion agama, BloodType golonganDarah, String nik, LocalDate tanggalMasuk, LocalDate tanggalLulus) {
        super(namaDepan, namaBelakang, tanggalLahir, kotaLahir, jenisKelamin, nomorKtp, agama, golonganDarah);
        this.nik = nik;
        this.tanggalMasuk = tanggalMasuk;
        this.tanggalLulus = tanggalLulus;
    }

    public Student(String namaDepan, String namaBelakang, LocalDate tanggalLahir, String kotaLahir, Gender jenisKelamin, String nomorKtp, Religion agama, BloodType golonganDarah, String nik, LocalDate tanggalMasuk, LocalDate tanggalLulus, List<Enrollment> enrollments) {
        super(namaDepan, namaBelakang, tanggalLahir, kotaLahir, jenisKelamin, nomorKtp, agama, golonganDarah);
        this.nik = nik;
        this.tanggalMasuk = tanggalMasuk;
        this.tanggalLulus = tanggalLulus;
        this.enrollments = enrollments;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public LocalDate getTanggalMasuk() {
        return tanggalMasuk;
    }

    public void setTanggalMasuk(LocalDate tanggalMasuk) {
        this.tanggalMasuk = tanggalMasuk;
    }

    public LocalDate getTanggalLulus() {
        return tanggalLulus;
    }

    public void setTanggalLulus(LocalDate tanggalLulus) {
        this.tanggalLulus = tanggalLulus;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    public void addEnrollment(Enrollment enrollment){
        enrollments.add(enrollment);
    }

    public String getTanggalMasukDanDurasi(){
        var formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        Period durasi;
        if(tanggalLulus != null){
            durasi = Period.between(tanggalMasuk, tanggalLulus);
        } else {
            durasi = Period.between(tanggalMasuk, LocalDate.now());
        }
        return String.format("%s (%s tahun, %s bulan, %s hari)",
            formatter.format(tanggalMasuk), durasi.getYears(), durasi.getMonths(), durasi.getDays());
    }

    @Override
    public void printSummary() {
        System.out.printf("NIK: %s, Name: %s\n", getNik(), getNamaLengkap());
    }

    @Override
    public void printDetail() {
        super.printDetail();
        System.out.printf("Entry Date (Duration): %s\n\n", getTanggalMasukDanDurasi());
        System.out.println("Enrollment Information:\n");
        for(var enrollment : enrollments){
            enrollment.printSummary();
        }
    }
}
