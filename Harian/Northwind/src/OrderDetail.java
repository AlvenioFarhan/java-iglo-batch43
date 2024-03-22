import java.util.LinkedList;

public class OrderDetail {

    //One to Many --> Order <-> OrderDetail
    private Order orders;

    //One to Many --> Product <-> OrderDetail
    private Product products;

    private  Double unitPrice;
    private Integer quantity;
    private Double discount;


    //----------------------------------------------------------------------

    public Double getSubTotal(){
        return (1 - this.discount) * (this.unitPrice * this.quantity);
    }



    public void printInformasi(){
        System.out.printf("Nama Produk: %s, Tanggal Order: %s, Quantity: %s\n", this.products.getProductName(), this.orders.getOrderDate() ,this.quantity);
    }



    //----------------------------------------------------------------------

    public OrderDetail(Order orders, Product products, Double unitPrice, Integer quantity, Double discount) {
        this.orders = orders;
        this.products = products;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.discount = discount;
    }


    //----------------------------------------------------------------------


    public Order getOrders() {
        return orders;
    }

    public void setOrders(Order orders) {
        this.orders = orders;
    }

    public Product getProducts() {
        return products;
    }

    public void setProducts(Product products) {
        this.products = products;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
