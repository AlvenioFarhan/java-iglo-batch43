import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

public class MataKuliah {
    private String namaMataKuliah;
    private String namaPenjurusan;
    private Integer point;


    //---------------------------------------------------------------------



    //---------------------------------------------------------------------


    public MataKuliah() {
    }

    public MataKuliah(String namaMataKuliah, String namaPenjurusan, Integer point) {
        this.namaMataKuliah = namaMataKuliah;
        this.namaPenjurusan = namaPenjurusan;
        this.point = point;
    }

    public String getNamaMataKuliah() {
        return namaMataKuliah;
    }

    public void setNamaMataKuliah(String namaMataKuliah) {
        this.namaMataKuliah = namaMataKuliah;
    }

    public String getNamaPenjurusan() {
        return namaPenjurusan;
    }

    public void setNamaPenjurusan(String namaPenjurusan) {
        this.namaPenjurusan = namaPenjurusan;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }
}
