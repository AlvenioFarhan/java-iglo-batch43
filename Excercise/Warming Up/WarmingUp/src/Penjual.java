import java.time.LocalDate;

public class Penjual extends Person{

    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String namaToko;
    private Level level;


    public Penjual(String firstName, String lastName, LocalDate birthDate, String namaToko, Level level) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.namaToko = namaToko;
        this.level = level;
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

    public String getNamaToko() {
        return namaToko;
    }

    public void setNamaToko(String namaToko) {
        this.namaToko = namaToko;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
