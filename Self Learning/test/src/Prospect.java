public class Prospect {
    private static int prospectCount = 0;

    private int prospectNumber;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String placeOfBirth;
    private String gender;
    private String occupation;
    private boolean isCustomer;

    public Prospect(String firstName, String lastName, String dateOfBirth, String placeOfBirth, String gender, String occupation) {
        prospectCount++;
        this.prospectNumber = prospectCount;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.placeOfBirth = placeOfBirth;
        this.gender = gender;
        this.occupation = occupation;
        this.isCustomer = false;
    }

    public void setIsCustomer(boolean isCustomer) {
        this.isCustomer = isCustomer;
    }

    public String toString() {
        return "Prospect Number: " + prospectNumber +
                "\nFirst Name: " + firstName +
                "\nLast Name: " + lastName +
                "\nDate of Birth: " + dateOfBirth +
                "\nPlace of Birth: " + placeOfBirth +
                "\nGender: " + gender +
                "\nOccupation: " + occupation +
                "\nIs Customer: " + (isCustomer ? "Yes" : "No");
    }
}
