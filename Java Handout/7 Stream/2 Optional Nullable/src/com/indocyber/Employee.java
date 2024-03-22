package com.indocyber;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Employee implements Person{
    private String name;
    private String jobTitle;
    private LocalDate hireDate;

    public Employee() {
    }

    public Employee(String name, String jobTitle) {
        this.name = name;
        this.jobTitle = jobTitle;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public Long getDuration(){
        return ChronoUnit.YEARS.between(this.hireDate, LocalDate.now());
    }
}
