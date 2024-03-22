package institution;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private String nama;
    private String penjurusan;
    private Integer poin;
    private List<Enrollment> enrollments = new ArrayList<>();
    private Tutor tutor;

    public Subject() {
    }

    public Subject(String nama, String penjurusan, Integer poin) {
        this.nama = nama;
        this.penjurusan = penjurusan;
        this.poin = poin;
    }

    public Subject(String nama, String penjurusan, Integer poin, List<Enrollment> enrollments, Tutor tutor) {
        this.nama = nama;
        this.penjurusan = penjurusan;
        this.poin = poin;
        this.enrollments = enrollments;
        this.tutor = tutor;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPenjurusan() {
        return penjurusan;
    }

    public void setPenjurusan(String penjurusan) {
        this.penjurusan = penjurusan;
    }

    public Integer getPoin() {
        return poin;
    }

    public void setPoin(Integer poin) {
        this.poin = poin;
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

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public String getSummary(){
        return String.format("%s in %s", nama, penjurusan);
    }

    public void printSummary(){
        System.out.println(getSummary());
    }
}
