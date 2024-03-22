package institution;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Tutor extends Person{
    private String nik;
    private Double salary;
    private LocalDate hireDate;
    private LocalDate terminateDate;
    private List<Subject> skills = new ArrayList<>();

    public Tutor(){
        super();
    }

    public Tutor(String namaDepan, String namaBelakang, LocalDate tanggalLahir, String kotaLahir, Gender jenisKelamin, String nomorKtp, Religion agama, BloodType golonganDarah, String nik, Double salary, LocalDate hireDate) {
        super(namaDepan, namaBelakang, tanggalLahir, kotaLahir, jenisKelamin, nomorKtp, agama, golonganDarah);
        this.nik = nik;
        this.salary = salary;
        this.hireDate = hireDate;
    }

    public Tutor(String namaDepan, String namaBelakang, LocalDate tanggalLahir, String kotaLahir, Gender jenisKelamin, String nomorKtp, Religion agama, BloodType golonganDarah, String nik, Double salary, LocalDate hireDate, LocalDate terminateDate) {
        super(namaDepan, namaBelakang, tanggalLahir, kotaLahir, jenisKelamin, nomorKtp, agama, golonganDarah);
        this.nik = nik;
        this.salary = salary;
        this.hireDate = hireDate;
        this.terminateDate = terminateDate;
    }

    public Tutor(String namaDepan, String namaBelakang, LocalDate tanggalLahir, String kotaLahir, Gender jenisKelamin, String nomorKtp, Religion agama, BloodType golonganDarah, String nik, Double salary, LocalDate hireDate, LocalDate terminateDate, List<Subject> skills) {
        super(namaDepan, namaBelakang, tanggalLahir, kotaLahir, jenisKelamin, nomorKtp, agama, golonganDarah);
        this.nik = nik;
        this.salary = salary;
        this.hireDate = hireDate;
        this.terminateDate = terminateDate;
        this.skills = skills;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String formattedSalary(){
        var formatter = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        return formatter.format(salary);
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public String getFormattedHireDate(){
        var formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        return formatter.format(hireDate);
    }

    public LocalDate getTerminateDate() {
        return terminateDate;
    }

    public void setTerminateDate(LocalDate terminateDate) {
        this.terminateDate = terminateDate;
    }

    public String getFormattedTerminatedDate(){
        var formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        return formatter.format(terminateDate);
    }

    public List<Subject> getSkills() {
        return skills;
    }

    public void setSkills(List<Subject> skills) {
        this.skills = skills;
    }

    public void addSkill(Subject subject){
        skills.add(subject);
    }

    public String getTanggalMasukDanDurasi(){
        var formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        Period durasi;
        if(terminateDate != null){
            durasi = Period.between(hireDate, terminateDate);
        } else {
            durasi = Period.between(hireDate, LocalDate.now());
        }
        return String.format("%s (%s tahun, %s bulan, %s hari)",
            formatter.format(hireDate), durasi.getYears(), durasi.getMonths(), durasi.getDays());
    }

    @Override
    public void printSummary() {
        System.out.printf("NIK: %s, Name: %s\n", getNik(), getNamaLengkap());
    }

    @Override
    public void printDetail() {
        super.printDetail();
        System.out.printf("Hire Date (Duration): %s\n\n", getTanggalMasukDanDurasi());
        System.out.println("Competency Information:\n");
        for(var skill : skills){
            skill.printSummary();
        }
    }
}
