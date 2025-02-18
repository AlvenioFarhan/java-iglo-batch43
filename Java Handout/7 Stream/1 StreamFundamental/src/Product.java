public class Product {
    private Long id;
    private String name;
    private Integer categoryId;
    private Double price;

    public Product(Long id, String name, Integer categoryId, Double price) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
        this.price = price;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return String.format("ID:%s, Name:%s, Category:%s, Price:%s",this.id, this.name, this.categoryId, this.price);
    }
}
