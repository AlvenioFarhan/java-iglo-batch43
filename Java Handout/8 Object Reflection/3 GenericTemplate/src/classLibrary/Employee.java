package classLibrary;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Employee extends Person{
    private String employeeNumber;
    private LocalDate hireDate;
    private double salary;

    public Employee() {
        super();
    }

    public Employee(String fullName, LocalDate birthDate, String gender, String employeeNumber, LocalDate hireDate, Double salary) {
        super(fullName, birthDate, gender);
        this.employeeNumber = employeeNumber;
        this.hireDate = hireDate;
        this.salary = salary;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void printEmployeeInfo(){
        System.out.printf("Employee number: %s, full name: %s\n", this.employeeNumber, this.getFullName());
    }

    public long getWorkingMonthDuration(){
        return ChronoUnit.MONTHS.between(this.hireDate, LocalDateTime.now());
    }
}
