package classLibrary;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;

public class Staff extends Employee{
    private double allowance;

    public Staff() {
    }

    public Staff(String fullName, LocalDate birthDate, String gender, String employeeNumber, LocalDate hireDate, Double salary, double allowance) {
        super(fullName, birthDate, gender, employeeNumber, hireDate, salary);
        this.allowance = allowance;
    }

    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }

    public void paymentSlip(){
        double takeHomePay = this.getSalary() + this.allowance;
        String formatted = NumberFormat.getCurrencyInstance(new Locale("id", "ID")).format(takeHomePay);
        System.out.printf("Take home pay: %s\n", formatted);
    }
}
