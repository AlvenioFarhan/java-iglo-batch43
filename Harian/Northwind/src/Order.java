import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedList;
import java.util.Locale;

public class Order {

    //Many to Many --> Product <-> Order
    //One to Many --> Order <-> OrderDetail
    private  LinkedList<OrderDetail> orderDetails;

    private Integer orderId;
    private LinkedList<Customer> customers;
    private LinkedList<Employee> employees;
    private LocalDate orderDate;
    private LocalDate requiredDate;
    private LocalDate shippedDate;
    private LinkedList<Shipper> shippers;
    private Double freight;
    private String shipName;
    private String shipAddress;
    private String shipCity;
    private String shipRegion;
    private String shipPostalCode;
    private String shipCountry;

    //----------------------------------------------------------------------

    public Double getTotalOrderCost(){
        Double orderCost = this.freight;

        for (OrderDetail orderDetail: this.orderDetails){
            orderCost += orderDetail.getSubTotal();
        }
        return orderCost;
    }


    //mendapatkan dan mengembalikan format Tanggal Order
    public String getTanggalOrder(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dateFormat = formatter.format(this.orderDate);
        return dateFormat;
    }


    //----------------------------------------------------------------------

    public Order(LinkedList<OrderDetail> orderDetails, Integer orderId, LinkedList<Customer> customerId,
                 LinkedList<Employee> employeeID, LocalDate orderDate, LocalDate requiredDate,
                 LocalDate shippedDate, LinkedList<Shipper> shipVia, Double freight, String shipName,
                 String shipAddress, String shipCity, String shipRegion, String shipPostalCode,
                 String shipCountry) {
        this.orderDetails = orderDetails;
        this.orderId = orderId;
        this.customers = customerId;
        this.employees = employeeID;
        this.orderDate = orderDate;
        this.requiredDate = requiredDate;
        this.shippedDate = shippedDate;
        this.shippers = shipVia;
        this.freight = freight;
        this.shipName = shipName;
        this.shipAddress = shipAddress;
        this.shipCity = shipCity;
        this.shipRegion = shipRegion;
        this.shipPostalCode = shipPostalCode;
        this.shipCountry = shipCountry;
    }


    //----------------------------------------------------------------------


    public LinkedList<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(LinkedList<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public LinkedList<Customer> getCustomerId() {
        return customers;
    }

    public void setCustomerId(LinkedList<Customer> customerId) {
        this.customers = customerId;
    }

    public LinkedList<Employee> getEmployeeID() {
        return employees;
    }

    public void setEmployeeID(LinkedList<Employee> employeeID) {
        this.employees = employeeID;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(LocalDate requiredDate) {
        this.requiredDate = requiredDate;
    }

    public LocalDate getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(LocalDate shippedDate) {
        this.shippedDate = shippedDate;
    }

    public LinkedList<Shipper> getShipVia() {
        return shippers;
    }

    public void setShipVia(LinkedList<Shipper> shipVia) {
        this.shippers = shipVia;
    }

    public Double getFreight() {
        return freight;
    }

    public void setFreight(Double freight) {
        this.freight = freight;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public String getShipCity() {
        return shipCity;
    }

    public void setShipCity(String shipCity) {
        this.shipCity = shipCity;
    }

    public String getShipRegion() {
        return shipRegion;
    }

    public void setShipRegion(String shipRegion) {
        this.shipRegion = shipRegion;
    }

    public String getShipPostalCode() {
        return shipPostalCode;
    }

    public void setShipPostalCode(String shipPostalCode) {
        this.shipPostalCode = shipPostalCode;
    }

    public String getShipCountry() {
        return shipCountry;
    }

    public void setShipCountry(String shipCountry) {
        this.shipCountry = shipCountry;
    }
}
