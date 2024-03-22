package com.company;
import classLibrary.Employee;

import java.util.List;

public class GroupOfEmployees<T extends Employee> {
    private List<T> employees;

    public GroupOfEmployees(List<T> employees) {
        this.employees = employees;
    }

    public List<T> getEmployees() {
        return employees;
    }

    public void setEmployees(List<T> employees) {
        this.employees = employees;
    }

    public void printAllEmployeeInfos(){
        for(T employee : this.employees){
            employee.printEmployeeInfo();
        }
    }

    public void printAllOriginalDataType(){
        for(Employee employee : this.employees){
            Class<?> type = employee.getClass();
            System.out.printf("Original type: %s\n", type.getName());
        }
    }
}
