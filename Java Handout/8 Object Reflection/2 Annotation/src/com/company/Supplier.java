package com.company;

import java.lang.annotation.Native;

@Marked
@EntityType
public class Supplier {
    private String companyName;
    private String contactName;

    /*
        @Native adalah built-in annotation yang digunakan untuk melabelkan constant/final field, bahwa deklarasi
        final field ini berasal dari native librarynya, bukan tambahan.
    */
    @Native private static final String COUNTRY = "Indonesia";

    @MethodType("Constructor")
    public Supplier() {
    }

    @MethodType("Constructor")
    public Supplier(String companyName, String contactName) {
        this.companyName = companyName;
        this.contactName = contactName;
    }

    @MethodType("GetterSetter")
    @Category("getter")
    public String getCompanyName() {
        return companyName;
    }

    @MethodType("GetterSetter")
    @Category("setter")
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @MethodType("GetterSetter")
    @Category("getter")
    public String getContactName() {
        return contactName;
    }

    @MethodType("GetterSetter")
    @Category("setter")
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    @MethodType("Additional")
    public void printInfo(){
        System.out.printf("Company %s, Contact %s\n", this.companyName, this.contactName);
    }
}
