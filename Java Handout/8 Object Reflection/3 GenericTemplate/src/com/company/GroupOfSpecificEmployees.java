package com.company;

import classLibrary.Employee;

import java.util.List;

public class GroupOfSpecificEmployees<T extends Employee> extends GroupOfEmployees<T> {

    public GroupOfSpecificEmployees(List<T> employees) {
        super(employees);
    }

    public void printAllWorkingDuration(){
        for(Employee employee : this.getEmployees()){
            System.out.printf("Durations: %s months\n", employee.getWorkingMonthDuration());
        }
    }
}
