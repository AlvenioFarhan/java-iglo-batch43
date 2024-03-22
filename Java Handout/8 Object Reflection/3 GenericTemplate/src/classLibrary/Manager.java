package classLibrary;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Manager extends Employee{
    private Double bonus;
    private List<Staff> subordinates = new ArrayList<Staff>();

    public Manager() {
    }

    public Manager(String fullName, LocalDate birthDate, String gender, String employeeNumber, LocalDate hireDate, Double salary, Double bonus) {
        super(fullName, birthDate, gender, employeeNumber, hireDate, salary);
        this.bonus = bonus;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    public List<Staff> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(List<Staff> subordinates) {
        this.subordinates = subordinates;
    }

    public void paymentSlip(){
        double takeHomePay = this.getSalary() * (1 - (this.bonus / 100));
        String formatted = NumberFormat.getCurrencyInstance(new Locale("id", "ID")).format(takeHomePay);
        System.out.printf("Take home pay: %s\n", formatted);
    }
}
