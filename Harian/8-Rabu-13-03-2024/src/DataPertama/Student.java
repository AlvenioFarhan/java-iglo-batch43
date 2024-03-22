package DataPertama;
import java.time.LocalDate;

public class Student extends Person {
    private Double grade;

    public Student(String name, LocalDate birthDate, Double grade) {
        super(name, birthDate);
        this.grade = grade;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }
}
