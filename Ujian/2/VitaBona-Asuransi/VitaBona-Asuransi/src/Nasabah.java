import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;

public class Nasabah extends Person{
    private String nomorNasabah;
    private String nomorKTP;
    private String statusKK;
    private MetodePembayaran metodePembayaran;
    private LinkedList<Polis> polis = new LinkedList<>();


    public Nasabah() {
    }

    public Nasabah(Prospect prospect, String nomorKTP, String statusKK, MetodePembayaran metodePembayaran) {
        super(prospect.getNamaDepan(), prospect.getNamaBelakang(), prospect.getTanggalLahir(), prospect.getTempatLahir(), prospect.getGender(), prospect.getPekerjaan());
        this.nomorKTP = nomorKTP;
        this.statusKK = statusKK;
        this.metodePembayaran = metodePembayaran;
    }


    public String getNomorNasabah() {
        return nomorNasabah;
    }

    public void setNomorNasabah(String nomorNasabah) {
        this.nomorNasabah = nomorNasabah;
    }

    public String getNomorKTP() {
        return nomorKTP;
    }

    public void setNomorKTP(String nomorKTP) {
        this.nomorKTP = nomorKTP;
    }

    public String getStatusKK() {
        return statusKK;
    }

    public void setStatusKK(String statusKK) {
        this.statusKK = statusKK;
    }

    public MetodePembayaran getMetodePembayaran() {
        return metodePembayaran;
    }

    public void setMetodePembayaran(MetodePembayaran metodePembayaran) {
        this.metodePembayaran = metodePembayaran;
    }

    public LinkedList<Polis> getPolis() {
        return polis;
    }

    public void setPolis(LinkedList<Polis> polis) {
        this.polis = polis;
    }

    //Membuat nomor nasabah
    public String generateNomorNasabah(Integer nomorProspect){
        LocalDate hariIni = LocalDate.now();
        String format = hariIni.format(DateTimeFormatter.ofPattern("MM/yyy"));
        String nomorNasabah = format + "/" + nomorProspect;
        return nomorNasabah;
    }

    public void printDataNasabah(){
        System.out.printf("No: %s, %s, %s, %s (%s), %s \nKTP: %s, Status di KK: %s, Payment Method: %s\n",
                getNomorNasabah(), getNamaLengkap(), getGender().getLabel(), getTanggalLahir(),getPekerjaan(),
                getTempatLahir(), nomorKTP, statusKK, metodePembayaran.getLabel());
    }

    //Print All Data Nasabah
    public void printAllDataMenuCustomerLengkap(){
        System.out.printf("No: %s, %s, %s, %s (%s), %s \nKTP: %s, Status di KK: %s, Payment Method: %s\n",
                getNomorNasabah(), getNamaLengkap(), getGender().getLabel(), getStringTanggalLahir(),
                getTempatLahir(), getPekerjaan(), nomorKTP, statusKK, metodePembayaran.getLabel());
        System.out.println("=====================================================================");
    }

    public void printAllDataCustomerPolicy(){
        System.out.println("=======================CUSTOMER INFO===============================");
        System.out.printf("No: %s, %s, %s, %s (%s), %s \nKTP: %s, Status di KK: %s, Payment Method: %s\n",
                getNomorNasabah(), getNamaLengkap(), getGender().getLabel(), getStringTanggalLahir(),
                getTempatLahir(), getPekerjaan(), nomorKTP, statusKK, metodePembayaran.getLabel());
        System.out.println("=====================================================================");
        for (Polis policy : polis){
            policy.printDataPolis();
        }
    }


}
