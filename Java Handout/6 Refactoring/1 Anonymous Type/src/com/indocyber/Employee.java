package com.indocyber;

public class Employee extends Person{

    private String employeeNumber;

    public Employee(String name, String gender, String employeeNumber) {
        super(name, gender);
        this.employeeNumber = employeeNumber;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }
}
