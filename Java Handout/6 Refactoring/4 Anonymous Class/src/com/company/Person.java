package com.company;
import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    private List<MobilePhone> phones = new ArrayList<MobilePhone>();

    public Person() {
        setPhones();
    }
    public Person(String name) {
        this.name = name;
        setPhones();
    }

    public void printInformation(){
        System.out.println("Print from super class.");
    }

    public void printName(){
        System.out.printf("Name: %s\n", this.name);
    }

    private void setPhones(){
        phones.add(new MobilePhone("Iphone") {
            @Override
            public String getBrand() {
                return super.getBrand();
            }
            @Override
            public void setBrand(String brand) {
                super.setBrand(brand);
            }
        });
    }

    public List<MobilePhone> getPhones() {
        return phones;
    }
}
