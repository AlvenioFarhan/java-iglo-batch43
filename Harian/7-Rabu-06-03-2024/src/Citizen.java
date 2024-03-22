import java.time.LocalDate;

public class Citizen extends Person{

    private String nomorKTP;

    public Citizen() {
    }

    public Citizen(String name, String birthCity, LocalDate birthDate, Gender gender, String nomorKTP) {
        super(name, birthCity, birthDate, gender);
        this.nomorKTP = nomorKTP;
    }

    public String getNomorKTP() {
        return nomorKTP;
    }
}
