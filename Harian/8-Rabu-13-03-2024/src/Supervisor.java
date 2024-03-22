import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Supervisor extends Karyawan{

    private Double intensive;
    private String name;
    private LocalDate birthDate;

    public Supervisor(Double monthlySalary, LocalDate hireDate, LocalDate terminateDate, Double intensive) {
        super(monthlySalary, hireDate, terminateDate);
        this.intensive = intensive;
    }

    @Override
    public Double hitungAnnualIncome() {
        return 12 * 1.2 * hitungMonthlyTakeHomePay();
    }

    @Override
    public Double hitungMonthlyTakeHomePay() {
        return 1.1 * getMonthlySalary() + intensive;
    }

    @Override
    public Long getAge() {
        return ChronoUnit.YEARS.between(birthDate, LocalDate.now());
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
