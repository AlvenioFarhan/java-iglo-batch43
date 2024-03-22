import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Person {

    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String birthCity;
    private Gender gender;
    private String nomorKTP;
    private Agama agama;
    private GolonganDarah golonganDarah;

    //---------------------------------------------------------------------


    //method ambil umur
    public Long getUmur(){
        LocalDate hariIni = LocalDate.now();
        Long umur = ChronoUnit.YEARS.between(this.birthDate, hariIni);
        return umur;
    }


    //---------------------------------------------------------------------


    public Person() {
    }

    public Person(String firstName, String lastName, LocalDate birthDate, String birthCity,
                  Gender gender, String nomorKTP) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.birthCity = birthCity;
        this.gender = gender;
        this.nomorKTP = nomorKTP;
    }

    public Person(String firstName, String lastName, LocalDate birthDate, String birthCity,
                  Gender gender, String nomorKTP, Agama agama, GolonganDarah golonganDarah) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.birthCity = birthCity;
        this.gender = gender;
        this.nomorKTP = nomorKTP;
        this.agama = agama;
        this.golonganDarah = golonganDarah;
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

    public String getBirthCity() {
        return birthCity;
    }

    public void setBirthCity(String birthCity) {
        this.birthCity = birthCity;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getNomorKTP() {
        return nomorKTP;
    }

    public void setNomorKTP(String nomorKTP) {
        this.nomorKTP = nomorKTP;
    }

    public Agama getAgama() {
        return agama;
    }

    public void setAgama(Agama agama) {
        this.agama = agama;
    }

    public GolonganDarah getGolonganDarah() {
        return golonganDarah;
    }

    public void setGolonganDarah(GolonganDarah golonganDarah) {
        this.golonganDarah = golonganDarah;
    }

}
