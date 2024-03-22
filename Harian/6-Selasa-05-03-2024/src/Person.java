import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

// Class --> Table
public class Person {
    //Field --> Column
//    public String firstName;
//    private String lastName;
//    public String gender;
//    public LocalDate birthDate;
//
//    //Method
//    public void printHelloWorld(){
//        System.out.println("Hello World!");
//    }
//
//    public void printNameSendiri(){
//        System.out.printf("%s %s\n", this.firstName, this.lastName);
//    }
//
//    public Long getUmur(){
//        LocalDate hariini = LocalDate.now();
//        Long umur = ChronoUnit.YEARS.between(birthDate, hariini);
//        return umur;
//    }
//
//    //Setter lastName
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }

    //------------------------------------------------------------------------------

//    private String firstName;
//    private String lastName;
//    private String middleName;
//
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public String getName(){
//        if (lastName != null){
//            return String.format("%s %s", firstName, lastName);
//        } return firstName;
//    }



    //------------------------------------------------------------------------------

    private String firstName;
    private String lastName;
    private String middleName;
    private String gender;

    public Person(String firstName, String lastName, String middleName, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.gender = gender;
    }

    public Person(String firstName, String lastName, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public String getGender() {
        return gender;
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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
}
