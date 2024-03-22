package com.indocyber;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String idNumber;
    private LocalDate birthDate;
    private Integer[] bloodPressure;
    private List<Vaccination> vaccinations = new ArrayList<Vaccination>();
    private String emailAddress;
    private String phoneNumber;

    public Person() {
    }
    public Person(String name, String idNumber, LocalDate birthDate, Integer[] bloodPressure, List<Vaccination> vaccinations, String emailAddress, String phoneNumber) {
        this.name = name;
        this.idNumber = idNumber;
        this.birthDate = birthDate;
        this.bloodPressure = bloodPressure;
        this.vaccinations = vaccinations;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getIdNumber() {
        return idNumber;
    }
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    public Integer[] getBloodPressure() {
        return bloodPressure;
    }
    public void setBloodPressure(Integer[] bloodPressure) {
        this.bloodPressure = bloodPressure;
    }
    public List<Vaccination> getVaccinations() {
        return vaccinations;
    }
    public void setVaccinations(List<Vaccination> vaccinations) {
        this.vaccinations = vaccinations;
    }
    public void addVaccination(Vaccination vaccination){
        this.vaccinations.add(vaccination);
    }
    public String getEmailAddress() {
        return emailAddress;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void sendInvitation(EmailNotificationHandler handler, Vaccination vaccination){
        System.out.printf("Send to: %s... Undangan untuk %s\n", this.phoneNumber, this.name);
        handler.sendEmailNotification(this.emailAddress, this.name, vaccination);
    }

    public void sendInvitation(ChatNotificationHandler handler){
        handler.sendChatNotification(this.name);
        System.out.println("Silahkan click link ini untuk informasi lebih detail https://...");
    }

    public boolean checkValidForBooster(CheckBloodPressureHandler handler, Integer[] bloodPressure){
        this.setBloodPressure(bloodPressure);
        int totalVaccine = this.vaccinations.size();
        return (totalVaccine >= 1) && handler.isPassed(this.bloodPressure);
    }
}
