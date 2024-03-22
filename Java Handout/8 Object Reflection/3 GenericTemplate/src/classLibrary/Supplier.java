package classLibrary;

import java.time.LocalDate;

public class Supplier extends StakeHolderImplementation{

    private String contactJobTitle;

    public Supplier() {
    }

    public Supplier(String fullName, LocalDate birthDate, String gender, String company, String business, String contactJobTitle) {
        super(fullName, birthDate, gender, company, business);
        this.contactJobTitle = contactJobTitle;
    }

    public void supplierContact(){
        System.out.printf("Hubungi %s (%s) sebagai perwakilan dari %s\n", this.getFullName(), this.contactJobTitle, this.getCompany());
    }

}
