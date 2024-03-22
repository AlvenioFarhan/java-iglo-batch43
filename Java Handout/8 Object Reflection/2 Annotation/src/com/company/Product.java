package com.company;

@UpdateSchedule(dayOfMonth=1, month="April", year=2022)
@UpdateSchedule(dayOfMonth=15, month="April", year=2022)
@UpdateSchedule(dayOfMonth=1, month="May", year=2022)
@EntityType(relationalType = "Detail")
public class Product {
    @ColumnDataType(name="VARCHAR", length = 20, nullable = false, constraint = "UNIQUE")private String code;
    @ColumnDataType(name="VARCHAR", length = 50, nullable = false) private String name;
    @ColumnDataType(name="VARCHAR", length = 500) private String description;
    @ColumnDataType(name="MONEY")private Double price;

    public Product() {
    }

    public Product(String code, String name, String description, Double price) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
