package com.company;

import java.time.LocalDate;

public class Student extends Person implements Citizen, Resident{
    private String studentNumber;
    private String fakultas;
    private String id;
    private String familyCardNumber;

    public Student() {
    }

    public Student(String firstName, String lastName, int dependencies, LocalDate tanggalLahir, String studentNumber, String fakultas) {
        super(firstName, lastName, dependencies, tanggalLahir);
        this.studentNumber = studentNumber;
        this.fakultas = fakultas;
    }

    public Student(String firstName, String lastName, int dependencies, LocalDate tanggalLahir, String studentNumber, String fakultas, String id, String familyCardNumber) {
        super(firstName, lastName, dependencies, tanggalLahir);
        this.studentNumber = studentNumber;
        this.fakultas = fakultas;
        this.id = id;
        this.familyCardNumber = familyCardNumber;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getFamilyCardNumber() {
        return this.familyCardNumber;
    }

    @Override
    public void setFamilyCardNumber(String familyCardNumber) {
        this.familyCardNumber = familyCardNumber;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getFakultas() {
        return fakultas;
    }

    public void setFakultas(String fakultas) {
        this.fakultas = fakultas;
    }

    public void enrollSubject(String subjectName, LocalDate enrollDate, double fee){
        System.out.printf("Subject name: %s, enroll date: %s, fee: %s\n", subjectName, enrollDate.toString(), fee);
    }
}
