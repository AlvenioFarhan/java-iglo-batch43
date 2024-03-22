import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class MatkulMahasiswa {
    private MataKuliah mataKuliah;
    private Mahasiswa mahasiswa;
    private LocalDate mulaiMatkul;
    private LocalDate selesaiMatkul;

    //------------------------------------------------------------------

    public void printEnrollmentInformation(){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String selesaiMatakuliahTidakNull;
        if (selesaiMatkul != null){
            selesaiMatakuliahTidakNull = selesaiMatkul.format(format);
        }else {
            selesaiMatakuliahTidakNull = "N/A";
        }
        System.out.printf("%s in %s, (%s – %s), (%s), +%s poin\n",
                mataKuliah.getNamaMataKuliah(), mataKuliah.getNamaPenjurusan(),
                this.mulaiMatkul.format(format),
                selesaiMatakuliahTidakNull,
                getMasaMataKuliah(), mataKuliah.getPoint());
    }

    public String getMasaMataKuliah(){
        LocalDate tanggalSelesai = null;
        if (this.selesaiMatkul != null){
            tanggalSelesai = this.selesaiMatkul;
        }else {
            tanggalSelesai = LocalDate.now();
        }
        Period lamaMasaKuliah = Period.between(this.mulaiMatkul, tanggalSelesai);

        int tahun = lamaMasaKuliah.getYears();
        int bulan = lamaMasaKuliah.getMonths();
        int hari = lamaMasaKuliah.getDays();

        String date = tahun + " tahun," + bulan + " bulan," + hari + " hari";

        return date;
    }


    //------------------------------------------------------------------


    public MatkulMahasiswa(MataKuliah mataKuliah, Mahasiswa mahasiswa, LocalDate mulaiMatkul, LocalDate selesaiMatkul) {
        this.mataKuliah = mataKuliah;
        this.mahasiswa = mahasiswa;
        this.mulaiMatkul = mulaiMatkul;
        this.selesaiMatkul = selesaiMatkul;
    }

    public MataKuliah getMataKuliah() {
        return mataKuliah;
    }

    public void setMataKuliah(MataKuliah mataKuliah) {
        this.mataKuliah = mataKuliah;
    }

    public Mahasiswa getMahasiswa() {
        return mahasiswa;
    }

    public void setMahasiswa(Mahasiswa mahasiswa) {
        this.mahasiswa = mahasiswa;
    }

    public LocalDate getMulaiMatkul() {
        return mulaiMatkul;
    }

    public void setMulaiMatkul(LocalDate mulaiMatkul) {
        this.mulaiMatkul = mulaiMatkul;
    }

    public LocalDate getSelesaiMatkul() {
        return selesaiMatkul;
    }

    public void setSelesaiMatkul(LocalDate selesaiMatkul) {
        this.selesaiMatkul = selesaiMatkul;
    }
}
