package com.indocyber;

import java.time.LocalDateTime;

public class Vaccination {
    private String name;
    private LocalDateTime vaccineTime;
    private String location;

    public Vaccination() {
    }

    public Vaccination(String name, LocalDateTime vaccineTime, String location) {
        this.name = name;
        this.vaccineTime = vaccineTime;
        this.location = location;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public LocalDateTime getVaccineTime() {
        return vaccineTime;
    }
    public void setVaccineTime(LocalDateTime vaccineTime) {
        this.vaccineTime = vaccineTime;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
}
