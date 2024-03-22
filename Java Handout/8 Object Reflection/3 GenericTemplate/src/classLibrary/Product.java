package classLibrary;

public class Product {
    private Integer id;
    private String name;
    private Integer headerId;

    public Product(Integer id, String name, Integer headerId) {
        this.id = id;
        this.name = name;
        this.headerId = headerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHeaderId() {
        return headerId;
    }

    public void setHeaderId(Integer headerId) {
        this.headerId = headerId;
    }
}
