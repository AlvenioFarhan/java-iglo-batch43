import java.util.LinkedList;

public class CustomerDemographic {

    //Many to Many --> Customer <-> CustomerDemographic
    private LinkedList<Customer> CustomerDemographic;
    
    private Integer customerTypeId;
    private String customerDesc;


    //----------------------------------------------------------------------

    public CustomerDemographic(LinkedList<Customer> customerDemographic,
                               Integer customerTypeId, String customerDesc) {
        CustomerDemographic = customerDemographic;
        this.customerTypeId = customerTypeId;
        this.customerDesc = customerDesc;
    }


    //----------------------------------------------------------------------


    public LinkedList<Customer> getCustomerDemographic() {
        return CustomerDemographic;
    }

    public void setCustomerDemographic(LinkedList<Customer> customerDemographic) {
        CustomerDemographic = customerDemographic;
    }

    public Integer getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(Integer customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public String getCustomerDesc() {
        return customerDesc;
    }

    public void setCustomerDesc(String customerDesc) {
        this.customerDesc = customerDesc;
    }
}
