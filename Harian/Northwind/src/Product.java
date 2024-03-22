import java.util.LinkedList;

public class Product {

    //Many to Many --> Product <-> Order
    //One to Many --> Product <-> OrderDetail
    private LinkedList<OrderDetail> orderDetails;

    private Integer productId;
    private String productName;
    private LinkedList<Supplier> suppliers;
    private LinkedList<Category> categories;
    private String quantityPerUnit;
    private Double unitPrice;
    private Integer unitInStock;
    private Integer unitOnOrder;
    private Integer reOrderLevel;
    private Boolean discontinue;


    //----------------------------------------------------------------------

    public void printOrderDetailInformation(){
        for (OrderDetail orderDetail : this.orderDetails){
            orderDetail.printInformasi();
        }
    }



    //----------------------------------------------------------------------

    public Product(LinkedList<OrderDetail> orderDetails, Integer productId, String productName,
                   LinkedList<Supplier> suppliers, LinkedList<Category> categories,
                   String quantityPerUnit, Double unitPrice, Integer unitInStock,
                   Integer unitOnOrder, Integer reOrderLevel, Boolean discontinue) {
        this.orderDetails = orderDetails;
        this.productId = productId;
        this.productName = productName;
        this.suppliers = suppliers;
        this.categories = categories;
        this.quantityPerUnit = quantityPerUnit;
        this.unitPrice = unitPrice;
        this.unitInStock = unitInStock;
        this.unitOnOrder = unitOnOrder;
        this.reOrderLevel = reOrderLevel;
        this.discontinue = discontinue;
    }


    //----------------------------------------------------------------------


    public LinkedList<OrderDetail> getProductOrderDetail() {
        return orderDetails;
    }

    public void setProductOrderDetail(LinkedList<OrderDetail> productOrderDetail) {
        this.orderDetails = productOrderDetail;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public LinkedList<Supplier> getSupplierId() {
        return suppliers;
    }

    public void setSupplierId(LinkedList<Supplier> supplierId) {
        this.suppliers = supplierId;
    }

    public LinkedList<Category> getCategories() {
        return categories;
    }

    public void setCategories(LinkedList<Category> categories) {
        this.categories = categories;
    }

    public String getQuantityPerUnit() {
        return quantityPerUnit;
    }

    public void setQuantityPerUnit(String quantityPerUnit) {
        this.quantityPerUnit = quantityPerUnit;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getUnitInStock() {
        return unitInStock;
    }

    public void setUnitInStock(Integer unitInStock) {
        this.unitInStock = unitInStock;
    }

    public Integer getUnitOnOrder() {
        return unitOnOrder;
    }

    public void setUnitOnOrder(Integer unitOnOrder) {
        this.unitOnOrder = unitOnOrder;
    }

    public Integer getReOrderLevel() {
        return reOrderLevel;
    }

    public void setReOrderLevel(Integer reOrderLevel) {
        this.reOrderLevel = reOrderLevel;
    }

    public Boolean getDiscontinue() {
        return discontinue;
    }

    public void setDiscontinue(Boolean discontinue) {
        this.discontinue = discontinue;
    }
}
