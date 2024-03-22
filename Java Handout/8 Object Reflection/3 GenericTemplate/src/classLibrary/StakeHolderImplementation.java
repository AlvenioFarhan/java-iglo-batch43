package classLibrary;

import java.time.LocalDate;

public class StakeHolderImplementation extends Person implements Stakeholder {

    private String company;
    private String business;

    public StakeHolderImplementation() {
        super();
    }

    public StakeHolderImplementation(String fullName, LocalDate birthDate, String gender, String company, String business) {
        super(fullName, birthDate, gender);
        this.company = company;
        this.business = business;
    }

    @Override
    public String getCompany() {
        return this.company;
    }

    @Override
    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String getBusiness() {
        return this.business;
    }

    @Override
    public void setBusiness(String business) {
        this.business = business;
    }

    @Override
    public void printCompanyInfo() {
        System.out.printf("Company: %s, Business: %s\n", this.company, this.business);
    }
}
