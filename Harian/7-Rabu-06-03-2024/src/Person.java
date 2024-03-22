import java.time.LocalDate;

public class Person {

    private String name;
    private String birthCity;
    private LocalDate birthDate;
    private Gender gender;

    //-------------------------------------------------------------------------
    public void printInfo(){
        System.out.printf("Person ini ber-nama: %s, Gender: %s\n", this.name, this.getGender());
    }

    //-------------------------------------------------------------------------

    public Person(){

    }

    public Person(String name, String birthCity, LocalDate birthDate, Gender gender) {
        this.name = name;
        this.birthCity = birthCity;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthCity() {
        return birthCity;
    }

    public void setBirthCity(String birthCity) {
        this.birthCity = birthCity;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender.getLabel();
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
