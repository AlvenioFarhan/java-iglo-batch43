import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

//ABSTRACT
public interface Person {

    Long getAge();
    public String getName();
    public void setName(String name);
    public LocalDate getBirthDate();
    public void setBirthDate(LocalDate birthDate);


}
