package com.company;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Person {
    public String firstName;
    private String lastName;
    private int dependencies;
    private LocalDate tanggalLahir;

    public Person() {
    }

    public Person(String firstName, String lastName, int dependencies, LocalDate tanggalLahir) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dependencies = dependencies;
        this.tanggalLahir = tanggalLahir;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getDependencies() {
        return dependencies;
    }
    public void setDependencies(int dependencies) {
        this.dependencies = dependencies;
    }
    public LocalDate getTanggalLahir() {
        return tanggalLahir;
    }
    public void setTanggalLahir(LocalDate tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public long calculateAge(){
        return ChronoUnit.YEARS.between(this.tanggalLahir, LocalDate.now());
    }

    public double calculateAge(LocalDate targetedDate){
        return ChronoUnit.YEARS.between(this.tanggalLahir, targetedDate);
    }

    public void printName(){
        System.out.printf("\nName: %s %s", firstName, lastName);
    }
}