import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Manager extends Karyawan implements WargaNegara, Person{
    private String nomorKTP;
    private String name;
    private LocalDate birthDate;;
    private Double spesialBonus;

    public Manager(Double monthlySalary, LocalDate hireDate, LocalDate terminateDate) {
        super(monthlySalary, hireDate, terminateDate);
    }

    @Override
    public void setNomorKTP(String nomorKTP) {
        this.nomorKTP = nomorKTP;
    }

    @Override
    public String getNomorKTP() {
        return nomorKTP;
    }

    @Override
    public Long getAge() {
        return ChronoUnit.YEARS.between(birthDate,LocalDate.now());
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


    @Override
    public Double hitungAnnualIncome() {
        return 12 * 1.2 * hitungMonthlyTakeHomePay();
    }

    @Override
    public Double hitungMonthlyTakeHomePay() {
        return 1.1 * getMonthlySalary() + spesialBonus;
    }
}
