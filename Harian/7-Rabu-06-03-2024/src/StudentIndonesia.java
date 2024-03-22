import java.time.LocalDate;

public class StudentIndonesia {

    private University university;
    private String name;
    private String birthCity;
    private String gender;
    private LocalDate birthDate;
    private static String Country;
    private Relligion relligion;
    private BloodType bloodType;


    public static String getCountryCode(){
        System.out.println("Country code kami adalah ID");
        return "ID";
    }

    public void printInformasiStudent(){
        System.out.printf("Nama: %s \nGender: %s \nCountry: %s",
                this.name, this.getGender(), StudentIndonesia.getCountry());
    }

    public static void printInformasiStudentIndonesia(){
//        System.out.printf("Country: %s, Name: %s\n", StudentIndonesia.getCountry(), getName());
    }



    //-------------------------------------------------------------------------------



    public StudentIndonesia(String name, String birthCity, String gender, LocalDate birthDate) {
        this.name = name;
        this.birthCity = birthCity;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public static String getCountry() {
        return Country;
    }

    public static void setCountry(String country) {
        Country = country;
    }

    public String getRelligion() {
        return this.relligion.getLabel();
    }

    public void setRelligion(Relligion relligion) {
        this.relligion = relligion;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }
}
