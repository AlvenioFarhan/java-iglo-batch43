import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Prospect extends Person{
    private static Integer prospectCount = 0;
    private Integer nomorProspect;
    private Boolean isNasabah;


    public Prospect() {
    }

    public Prospect(String namaDepan, String namaBelakang, LocalDate tanggalLahir, String tempatLahir, Gender gender, String pekerjaan, Boolean isNasabah) {
        super(namaDepan, namaBelakang, tanggalLahir, tempatLahir, gender, pekerjaan);
        prospectCount++;
        this.nomorProspect = prospectCount;
        this.isNasabah = isNasabah;
    }

    public Integer getNomorProspect() {
        return nomorProspect;
    }

    public void setNomorProspect(Integer nomorProspect) {
        this.nomorProspect = nomorProspect;
    }


    public Boolean getNasabah() {
        return isNasabah;
    }

    public void setNasabah(Boolean nasabah) {
        isNasabah = nasabah;
    }


    //print semua data nasabah dan prospect di menu prospect
    public void printAllDataMenuProspect(){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        System.out.printf("No: %s, %s %s, %s, %s (%s), %s, %s\n", nomorProspect,this.getNamaDepan(), this.getNamaBelakang(),
                this.getGender().getLabel(), this.getTanggalLahir().format(format), this.getTempatLahir(), this.getPekerjaan(),
                isNasabah());
    }

    //cetak data nasabah
    public String isNasabah(){
        if (isNasabah){
            return "Nasabah";
        } else {
            return "Prospect";
        }
    }

}
