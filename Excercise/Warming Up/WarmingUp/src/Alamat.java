import java.time.LocalDate;

public class Alamat extends Pembeli{

    private String negara;
    private String state;
    private String kota;
    private String address;
    private Pembeli pembeli;



    //----------------------------------------------------------------

    //Nomor 10
    @Override
    public void printAlamatInformation(){
        System.out.printf("%s %s tinggal di %s, %s, %s, %s\n", super.getFirstName(), super.getLastName(),
                this.negara, this.state, this.kota, this.address);
    }



    //----------------------------------------------------------------


    public Alamat() {
    }

    public Alamat(String negara, String state, String kota, String address) {
        this.negara = negara;
        this.state = state;
        this.kota = kota;
        this.address = address;
    }

    public Alamat(Integer nomor, String firstName, String lastName, LocalDate birthDate, Double cash,
                  String negara, String state, String kota, String address, Pembeli pembeli) {
        super(nomor, firstName, lastName, birthDate, cash);
        this.negara = negara;
        this.state = state;
        this.kota = kota;
        this.address = address;
        this.pembeli = pembeli;
    }

    public String getNegara() {
        return negara;
    }

    public void setNegara(String negara) {
        this.negara = negara;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Pembeli getPembeli() {
        return pembeli;
    }

    public void setPembeli(Pembeli pembeli) {
        this.pembeli = pembeli;
    }
}
