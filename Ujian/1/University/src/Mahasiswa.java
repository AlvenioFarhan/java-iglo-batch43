import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;

public class Mahasiswa extends Person{

    private String nikMahasiswa;
    private LocalDate tanggalMasukUniv;

    private LinkedList<MatkulMahasiswa> listMatkul;


    //---------------------------------------------------------------------

    //Mengambil Lama Masa Kuliah
    public String getLamaMasaKuliah(){
        LocalDate hariIni = LocalDate.now();
        Period lamaMasaKuliah = Period.between(this.tanggalMasukUniv, hariIni);

        int tahun = lamaMasaKuliah.getYears();
        int bulan = lamaMasaKuliah.getMonths();
        int hari = lamaMasaKuliah.getDays();

        String date = tahun + " tahun," + bulan + " bulan," + hari + " hari";

        return date;
    }


    public void printallStudentData(){

            System.out.printf("NIK: %s, Name: %s %s\n", this.nikMahasiswa, super.getFirstName(),
                    super.getLastName());

    }

    public void printStudentInformation(){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd MMMM yyyy");

        System.out.printf("First Name: %s\n", super.getFirstName());
        System.out.printf("Last Name: %s\n", super.getLastName());
        System.out.printf("Gender: %s\n", super.getGender().getLabel());
        System.out.printf("Birth Information: %s, %s (%s tahun)\n",
                super.getBirthCity(), super.getBirthDate().format(format), super.getUmur());
        System.out.printf("Religion: %s\n", super.getAgama().getLabel());
        System.out.printf("Blood Type: %s\n", super.getGolonganDarah().getLabel());
        System.out.printf("ID Card: %s\n", super.getNomorKTP());
        System.out.printf("Entry Date (Duration): %s (%s)\n",
                this.getTanggalMasukUniv().format(format), getLamaMasaKuliah());
        System.out.println("Enrollment Information:");
        if (this.listMatkul != null) {
            for (MatkulMahasiswa matkulMahasiswa : this.listMatkul) {
                matkulMahasiswa.printEnrollmentInformation();
            }
        } else {
            System.out.println("No enrollment information available.");
        }
    }


    //---------------------------------------------------------------------


    public Mahasiswa() {
    }

    public Mahasiswa(String firstName, String lastName, LocalDate birthDate, String birthCity, Gender gender,
                     String nomorKTP, Agama agama, GolonganDarah golonganDarah, String nikMahasiswa,
                     LocalDate tanggalMasukUniv) {
        super(firstName, lastName, birthDate, birthCity, gender, nomorKTP, agama, golonganDarah);
        this.nikMahasiswa = nikMahasiswa;
        this.tanggalMasukUniv = tanggalMasukUniv;
    }

    public String getNikMahasiswa() {
        return nikMahasiswa;
    }

    public void setNikMahasiswa(String nikMahasiswa) {
        this.nikMahasiswa = nikMahasiswa;
    }

    public LocalDate getTanggalMasukUniv() {
        return tanggalMasukUniv;
    }

    public void setTanggalMasukUniv(LocalDate tanggalMasukUniv) {
        this.tanggalMasukUniv = tanggalMasukUniv;
    }

    public LinkedList<MatkulMahasiswa> getListMatkul() {
        return listMatkul;
    }

    public void setListMatkul(LinkedList<MatkulMahasiswa> listMatkul) {
        this.listMatkul = listMatkul;
    }
}
