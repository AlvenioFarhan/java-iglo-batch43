package institution;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class University {
    private static String nama;
    private static LocalDate tanggalDidirikan;
    private static String negara;
    private static String negaraBagian;
    private static String kota;
    private static Map<String, Subject> subjects = new HashMap<>();
    private static Map<String, Student> students = new HashMap<>();
    private static Map<String, Tutor> tutors = new HashMap<>();

    private static void initializeUniversity(){
        nama = "Unicorn (University of Cornelius)";
        tanggalDidirikan = LocalDate.of(1964, 3, 5);
        negara = "Amerika Serikat";
        negaraBagian = "California";
        kota = "Illonis";
    }

    private static void initializeSubjects(){
        subjects.put("OOP", new Subject("Object Oriented Programming", "Programming", 20 ));
        subjects.put("DS", new Subject("Data Structure", "Programming", 30));
        subjects.put("NF", new Subject("Networking Fundamental", "Networking", 40));
        subjects.put("DF", new Subject("Database Fundamental", "Programming", 30));
        subjects.put("PMP", new Subject("Project Management Professional", "Management and Analytic", 50));
        subjects.put("UML", new Subject("Unified Modelling Language", "Management and Analytic", 40));
        subjects.put("JF", new Subject("Java Fundamental", "Programming", 30));
        subjects.put("ID", new Subject("Infrastructure Design", "Networking", 30));
        subjects.put("NS", new Subject("Networking and Security", "Networking", 30));
    }

    private static void initializeTutors(){
        var antik = new Tutor("Antik", "Haya", LocalDate.of(1999,3,4),
            "Bandung", Gender.P, "12377899676", Religion.ISLAM, BloodType.B, "T701", 12_000_000.0, LocalDate.of(2011,5,7));
        antik.addSkill(subjects.get("ID"));
        antik.addSkill(subjects.get("NS"));

        var cahya = new Tutor("Cahya", "Subroto", LocalDate.of(2001,3,6),
            "Jakarta", Gender.L, "1234534534899676", Religion.ISLAM, BloodType.O, "T808", 15_000_000.0, LocalDate.of(2010,5,7));
        cahya.addSkill(subjects.get("OOP"));
        cahya.addSkill(subjects.get("UML"));

        tutors.put(antik.getNik(), antik);
        tutors.put(cahya.getNik(), cahya);
    }

    private static void initializeStudents(){
        var alex = new Student("Alex", "Wirianata", LocalDate.of(2000,3,5),
            "Pekan Baru", Gender.L, "7491237481", Religion.BUDDHA, BloodType.AB, "A021", LocalDate.of(2022,6,7));
        alex.addEnrollment(new Enrollment(LocalDate.of(2022,8,8), LocalDate.of(2022, 9, 9), subjects.get("PMP")));
        alex.addEnrollment(new Enrollment(LocalDate.of(2022,8,11), subjects.get("DS")));

        var desy = new Student("Desy", "Oktaviani", LocalDate.of(2001,8,5),
            "Medan", Gender.P, "36356345456", Religion.KATOLIK, BloodType.AB, "A022", LocalDate.of(2022,9,9));
        desy.addEnrollment(new Enrollment(LocalDate.of(2022,10,8), LocalDate.of(2022, 11, 9), subjects.get("PMP")));
        desy.addEnrollment(new Enrollment(LocalDate.of(2022,8,11), subjects.get("DF")));

        students.put(alex.getNik(), alex);
        students.put(desy.getNik(), desy);
    }

    public static void initializeData(){
        initializeUniversity();
        initializeSubjects();
        initializeTutors();
        initializeStudents();
    }

    public static void printAllStudentsSummary(){
        for(var student : students.values()){
            student.printSummary();
        }
    }

    public static void printAllTutorsSummary(){
        for(var tutor: tutors.values()){
            tutor.printSummary();
        }
    }

    public static Boolean findAndPrintOneStudent(String nik){
        var selectedStudent = students.get(nik);
        if(selectedStudent == null){
            return false;
        }
        selectedStudent.printDetail();
        return true;
    }

    public static Boolean findAndPrintOneTutor(String nik){
        var selectedTutor = tutors.get(nik);
        if(selectedTutor == null){
            return false;
        }
        selectedTutor.printDetail();
        return true;
    }

    public static void printAbout(){
        var formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        System.out.printf("Universitas ini bernama %s. Sudah didirikan sejak %s di %s, %s, di kota %s.\n",
            nama, formatter.format(tanggalDidirikan), negara, negaraBagian, kota);
    }

    public static void addOneStudent(Student studentBaru){
        students.put(studentBaru.getNik(), studentBaru);
    }

    public static Map<String, Subject> getAllSubjects(){
        return subjects;
    }
}
