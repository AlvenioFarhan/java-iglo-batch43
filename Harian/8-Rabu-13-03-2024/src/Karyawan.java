/*
* Aturan Abstract Class:
* 1. Bisa memiliki field
* 2. Bisa memiliki constructor, tapi tidak bisa dipakai untuk instantiate
*   Jadi hanya dipakai untuk inheritence
* 3. Bisa memiliki Full Method
* 4. Bisa memiliki Abstract Method
* 5. Di inherit dengan menggunakan extends
* 6. Karena menggunakan extends, Polymorphism nya  satu parent  banyak child
*       (persis seperti super class)
* 7. Bisa menggunakan static di member yang non Abstract
*
* interface EXTENDS interface
* AbstractClass IMPLEMENTS Interface
* AbstractClass EXTENDS AbstractClass (Super)
*
* Class IMPLEMENTS Interface
* Class EXTENDS AbstractClass (Super)
*
* Class EXTENDS Class (Super)
*
* */

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

//INTERFACE
public abstract class Karyawan implements Person {
    private Double monthlySalary;
    private LocalDate hireDate;
    private LocalDate terminateDate;

    public Karyawan(Double monthlySalary, LocalDate hireDate, LocalDate terminateDate) {
        this.monthlySalary = monthlySalary;
        this.hireDate = hireDate;
        this.terminateDate = terminateDate;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public LocalDate getTerminateDate() {
        return terminateDate;
    }

    public void setTerminateDate(LocalDate terminateDate) {
        this.terminateDate = terminateDate;
    }

    public Double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(Double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public abstract Double hitungAnnualIncome();

    public abstract Double hitungMonthlyTakeHomePay();

    public Long monthWorkingDuration(){
        Long duration = 0l;
        if (terminateDate != null){
            duration = ChronoUnit.MONTHS.between(hireDate, terminateDate);
        }else {
            duration = ChronoUnit.MONTHS.between(hireDate, LocalDate.now());
        }
        return duration;
    }

}
