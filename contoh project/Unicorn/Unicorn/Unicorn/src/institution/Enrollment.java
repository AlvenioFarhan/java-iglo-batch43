package institution;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Enrollment {
    private LocalDate start;
    private LocalDate end;
    private Subject subject;
    private Student student;

    public Enrollment(LocalDate start, Subject subject) {
        this.start = start;
        this.subject = subject;
    }

    public Enrollment(LocalDate start, LocalDate end, Subject subject) {
        this.start = start;
        this.end = end;
        this.subject = subject;
    }

    public Enrollment(LocalDate start, LocalDate end, Subject subject, Student student) {
        this.start = start;
        this.end = end;
        this.subject = subject;
        this.student = student;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public String getFormattedStart(){
        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return formatter.format(start);
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public String getFormattedEnd(){
        if(end != null){
            var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return formatter.format(end);
        }
        return "N/A";
    }

    public String getDuration(){
        Period duration;
        if(end != null){
            duration = Period.between(start, end);
        } else {
            duration = Period.between(start, LocalDate.now());
        }
        return String.format("(%s tahun, %s bulan, %s hari)", duration.getYears(), duration.getMonths(), duration.getDays());
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void printSummary(){
        System.out.printf("%s, (%s - %s), %s, + %s poin\n",
            subject.getSummary(), getFormattedStart(), getFormattedEnd(), getDuration(), subject.getPoin());
    }
}
