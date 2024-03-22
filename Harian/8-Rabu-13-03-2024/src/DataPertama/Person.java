package DataPertama;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Person {
    private String name;
    private LocalDate birthDate;

    public Person(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    Long getAge(){
        return ChronoUnit.YEARS.between(birthDate,LocalDate.now());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    //-----------------------------------------------------------------------------------


}
