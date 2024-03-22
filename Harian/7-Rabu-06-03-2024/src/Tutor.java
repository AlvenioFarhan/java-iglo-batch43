import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Formatter;
import java.util.Locale;

public class Tutor extends Person{

    private Double salary;
    private EmployeementStatus employeementStatus;

    //-------------------------------------------------------------------------

    @Override
    public void printInfo(){
        NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("id","ID"));
        System.out.printf("Person ini ber-nama: %s, Gaji: %s\n", super.getName(), formatter.format(this.salary));
    }


    //-------------------------------------------------------------------------


    public Tutor() {
    }

    public Tutor(String name, String birthCity, LocalDate birthDate, Gender gender, Double salary, EmployeementStatus employeementStatus) {
        super(name, birthCity, birthDate, gender);
        this.salary = salary;
        this.employeementStatus = employeementStatus;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public EmployeementStatus getEmployeementStatus() {
        return employeementStatus;
    }

    public void setEmployeementStatus(EmployeementStatus employeementStatus) {
        this.employeementStatus = employeementStatus;
    }
}
