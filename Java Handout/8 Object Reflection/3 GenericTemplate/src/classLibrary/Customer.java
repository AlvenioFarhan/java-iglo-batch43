package classLibrary;

import java.time.LocalDate;

public class Customer extends StakeHolderImplementation{

    public String deliveryAddress;

    public Customer() {
    }

    public Customer(String fullName, LocalDate birthDate, String gender, String company, String business, String deliveryAddress) {
        super(fullName, birthDate, gender, company, business);
        this.deliveryAddress = deliveryAddress;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public void sendTo(){
        System.out.printf("Send to %s, in %s (%s)\n", this.getFullName(), this.deliveryAddress, this.getCompany());
    }
}
