import java.time.LocalDate;

public class Student extends Person{ //Person adalah SuperClass

    private String faculty;
    private Double grade;


    //-------------------------------------------------------------------------

    public Student() {
    }

    public Student(String name, String birthCity, LocalDate birthDate, Gender gender, String faculty, Double grade) {
        super(name, birthCity, birthDate, gender);
        this.faculty = faculty;
        this.grade = grade;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }
}
