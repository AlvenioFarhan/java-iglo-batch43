package classLibrary;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Person {
    private String fullName;
    private LocalDate birthDate;
    private String gender;

    public Person() {
    }

    public Person(String fullName, LocalDate birthDate, String gender) {
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public long calculateAge(){
        return ChronoUnit.YEARS.between(this.birthDate, LocalDate.now());
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
