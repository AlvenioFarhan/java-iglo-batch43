import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Patient {
    private String idPatient;
    private String namaPatient;
    private LocalDate birthDate;
    private List<MedicalCheckup> medicalCheckupList;


    public Patient() {
    }

    public Patient(List<MedicalCheckup> medicalCheckupList) {
        this.medicalCheckupList = medicalCheckupList;
    }

    public Patient(String idPatient, String namaPatient, LocalDate birthDate) {
        this.idPatient = idPatient;
        this.namaPatient = namaPatient;
        this.birthDate = birthDate;
    }


    public String getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(String idPatient) {
        this.idPatient = idPatient;
    }

    public String getNamaPatient() {
        return namaPatient;
    }

    public void setNamaPatient(String namaPatient) {
        this.namaPatient = namaPatient;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    //print semua data patient di menu tambah patient
    public void printAllDataMenuPatient() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.printf("ID: %s, Name: %s, Birth Date: %s, Age: %s\n", idPatient, namaPatient, formatter.format(birthDate), getAge());
    }

    //get usia patient
    public Long getAge() {
        LocalDate hariIni = LocalDate.now();
        Long age = ChronoUnit.YEARS.between(this.birthDate, hariIni);
        return age;
    }

    //method untuk set iuran product
    public void setMedicalCheckupList(List<MedicalCheckup> medicalCheckupList) {
        this.medicalCheckupList = medicalCheckupList;
    }

    public void menambahMedicalCheckup(MedicalCheckup medicalCheckup){
        medicalCheckup.setCodeMedicalCheckup(idPatient);
    }


}
