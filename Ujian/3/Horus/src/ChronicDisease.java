import java.time.format.DateTimeFormatter;

public class ChronicDisease{
    private String namaPenyakit;
    private String keteranganPenyakit;


    public ChronicDisease() {
    }

    public ChronicDisease(String namaPenyakit, String keteranganPenyakit) {
        this.namaPenyakit = namaPenyakit;
        this.keteranganPenyakit = keteranganPenyakit;
    }

    public String getNamaPenyakit() {
        return namaPenyakit;
    }

    public void setNamaPenyakit(String namaPenyakit) {
        this.namaPenyakit = namaPenyakit;
    }

    public String getKeteranganPenyakit() {
        return keteranganPenyakit;
    }

    public void setKeteranganPenyakit(String keteranganPenyakit) {
        this.keteranganPenyakit = keteranganPenyakit;
    }

    //print penyakit kritis
    public void printAllDataChronicDisiase(){
        System.out.printf("Name: %s, Description %s\n", namaPenyakit, keteranganPenyakit);
    }

}
