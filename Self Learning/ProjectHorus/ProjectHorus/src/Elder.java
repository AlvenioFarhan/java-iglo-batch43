import java.time.LocalDate;
import java.util.LinkedList;

public class Elder extends Pasien{
    private LinkedList<String> namaPenyakit = new LinkedList<>();
    private LinkedList<String> keterangan = new LinkedList<>();

    public Elder() {
    }

    public Elder(String idPasien, String namaPasien, LocalDate tanggalLahirPasien) {
        super(idPasien, namaPasien, tanggalLahirPasien);
        this.namaPenyakit = namaPenyakit;
        this.keterangan = keterangan;
    }

    public Elder(String idPasien, String namaPasien, LocalDate tanggalLahirPasien, LinkedList<String> namaPenyakit, LinkedList<String> keterangan) {
        super(idPasien, namaPasien, tanggalLahirPasien);
        this.namaPenyakit = namaPenyakit;
        this.keterangan = keterangan;
    }

    public void tambahPenyakit(String namaPenyakit, String keterangan) {
        this.namaPenyakit.add(namaPenyakit);
        this.keterangan.add(keterangan);
    }

    public Elder(String idPasien, String namaPasien, LocalDate tanggalLahir, String namaPenyakit, String keterangan) {
    }

    public LinkedList<String> getNamaPenyakit() {
        return namaPenyakit;
    }

    public void setNamaPenyakit(LinkedList<String> namaPenyakit) {
        this.namaPenyakit = namaPenyakit;
    }

    public LinkedList<String> getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(LinkedList<String> keterangan) {
        this.keterangan = keterangan;
    }
}
