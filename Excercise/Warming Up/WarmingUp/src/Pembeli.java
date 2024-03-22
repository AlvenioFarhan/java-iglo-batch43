import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Pembeli extends Person{

    private Integer nomor;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Double cash;

    private Alamat alamat;

    //----------------------------------------------------------------

    //Nomor 3
    public void changeFirstName(Pembeli pembeli, String namaDepanBaru){
        pembeli.setFirstName(namaDepanBaru);
    }

    //Nomor 4
    public void getInformation(){
        System.out.printf("Nomor: %s, Nama Lengkap: %s %s\n", this.nomor, this.firstName, this.lastName);
    }

    //Nomor 5
    public Long getUmur(){
        LocalDate hariIni = LocalDate.now();
        Long umur = ChronoUnit.YEARS.between(this.birthDate, hariIni);
        return umur;
    }

    //Nomor 6
    public void formatterUang(){
        NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("id","ID"));
        System.out.printf("%s, Cash saat ini : %s\n", this.firstName, formatter.format(this.cash));
    }

    //Nomor 7
    public void printInformation(){
        NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("id","ID"));
        System.out.printf("Customer nomor: %s, %s %s. Sekarang berumur %s tahun dengan digital Cash %s\n", this.nomor,
                this.firstName, this.lastName, getUmur(), formatter.format(this.cash));
    }

    //Nomor 10
    public void printAlamatInformation() {
        System.out.printf("%s %s tinggal di %s, %s, %s, %s\n", this.firstName, this.lastName,
                getAlamat().getNegara(), getAlamat().getState(), getAlamat().getKota(), getAlamat().getAddress());
    }


    //----------------------------------------------------------------



    public Pembeli() {
    }

    public Pembeli(Integer nomor, String firstName, String lastName, LocalDate birthDate, Double cash) {
        this.nomor = nomor;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.cash = cash;
    }

    public Integer getNomor() {
        return nomor;
    }

    public void setNomor(Integer nomor) {
        this.nomor = nomor;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

    public Alamat getAlamat() {
        return alamat;
    }

    public void setAlamat(Alamat alamat) {
        this.alamat = alamat;
    }



}
