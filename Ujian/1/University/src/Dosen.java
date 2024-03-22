import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

public class Dosen extends Person{

    private String nikDosen;
    private Double gaji;
    private LocalDate tanggalMulaiBekerja;
//    private LinkedList<MataKuliah> matakuliahDosen;
    private LinkedList<MatkulDosen> mataKuliahDiajar;


    //---------------------------------------------------------------------

    public void printAllDosenData(){

        System.out.printf("NIK: %s, Name: %s %s\n", this.nikDosen, super.getFirstName(),
                super.getLastName());

    }

    public void printTutorInformation(){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd MMMM yyyy");

        System.out.printf("First Name: %s\n", super.getFirstName());
        System.out.printf("Last Name: %s\n", super.getLastName());
        System.out.printf("Gender: %s\n", super.getGender().getLabel());
        System.out.printf("Birth Information: %s, %s (%s tahun)\n",
                super.getBirthCity(), super.getBirthDate().format(format), super.getUmur());
        System.out.printf("Religion: %s\n", super.getAgama().getLabel());
        System.out.printf("Blood Type: %s\n", super.getGolonganDarah().getLabel());
        System.out.printf("ID Card: %s\n", super.getNomorKTP());
        System.out.printf("Hire Date (Duration): %s (%s)\n",
                this.tanggalMulaiBekerja.format(format), getLamaBekerja());
        System.out.println("Competency Information:");
        if (mataKuliahDiajar != null) {
            for (MatkulDosen matkulDosen : this.mataKuliahDiajar) {
                matkulDosen.printCompetencyInformation();
            }
        } else {
            System.out.println("No competency Information available.");
        }

    }

    public String getLamaBekerja(){
        LocalDate hariIni = LocalDate.now();
        Period lamaMasaKuliah = Period.between(this.tanggalMulaiBekerja, hariIni);

        int tahun = lamaMasaKuliah.getYears();
        int bulan = lamaMasaKuliah.getMonths();
        int hari = lamaMasaKuliah.getDays();

        String date = tahun + " tahun," + bulan + " bulan," + hari + " hari";

        return date;
    }


    //---------------------------------------------------------------------


    public Dosen() {
    }

    public Dosen(String firstName, String lastName, LocalDate birthDate, String birthCity, Gender gender,
                     String nomorKTP, Agama agama, GolonganDarah golonganDarah, String nikDosen, Double gaji,
                     LocalDate tanggalMulaiBekerja) {
        super(firstName, lastName, birthDate, birthCity, gender, nomorKTP, agama, golonganDarah);
        this.nikDosen = nikDosen;
        this.gaji = gaji;
        this.tanggalMulaiBekerja = tanggalMulaiBekerja;
    }

    public String getNikDosen() {
        return nikDosen;
    }

    public void setNikDosen(String nikDosen) {
        this.nikDosen = nikDosen;
    }

    public Double getGaji() {
        return gaji;
    }

    public void setGaji(Double gaji) {
        this.gaji = gaji;
    }

    public LocalDate getTanggalMulaiBekerja() {
        return tanggalMulaiBekerja;
    }

    public void setTanggalMulaiBekerja(LocalDate tanggalMulaiBekerja) {
        this.tanggalMulaiBekerja = tanggalMulaiBekerja;
    }

    public LinkedList<MatkulDosen> getMataKuliahDiajar() {
        return mataKuliahDiajar;
    }

    public void setMataKuliahDiajar(LinkedList<MatkulDosen> mataKuliahDiajar) {
        this.mataKuliahDiajar = mataKuliahDiajar;
    }

//    public LinkedList<MataKuliah> getMatakuliahDosen() {
//        return matakuliahDosen;
//    }
//
//    public void setMatakuliahDosen(LinkedList<MataKuliah> matakuliahDosen) {
//        this.matakuliahDosen = matakuliahDosen;
//    }
}
