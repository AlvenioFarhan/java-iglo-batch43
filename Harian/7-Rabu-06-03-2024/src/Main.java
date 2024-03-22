import internalPackage.Employee;

import java.time.LocalDate;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        StudentIndonesia.setCountry("Indonesia");

        StudentIndonesia alvenio = new StudentIndonesia("Alvenio", "Semarang", "Laki-laki",
                LocalDate.of(1999,3,31));
//
//        System.out.println(StudentIndonesia.getCountryCode());
//
//        String countryCode = StudentIndonesia.getCountryCode();

        //-------------------------------------------------------------------------

        //nomor reference berbeda, maka dari itu di return
//        Integer jumlahPoint = 10; //Value Type
//        jumlahPoint = tambahLimaPoint(jumlahPoint);
//        System.out.println(jumlahPoint);


        //-------------------------------------------------------------------------

        //void menyimpan, karena sama reference type, maka dari itu pakai void
//        ubahBirthCity("Jakarta", alvenio);
//        System.out.println(alvenio.getBirthCity());


        //-------------------------------------------------------------------------

//        ubahBirthCityStudent(alvenio);
//        ubahNegara();

        //-------------------------------------------------------------------------

        //Enum, hal yang dimana data fix atau tidak bertambah
//        alvenio.setRelligion(Relligion.ISLAM);
//        alvenio.setBloodType(BloodType.O);
//
//        System.out.println(alvenio.getRelligion());


        //-------------------------------------------------------------------------

        // Inheritance
        /*
        * Person
        * firstName
        * lastName
        * birthDate
        * birthCity
        *
        *getAge()
        *
        * Student Inherit Person
        * faculty
        * grade
        *
        * getAge()
        *
        * Tutor Inherit Person
        * salary
        * employeementStatus
        *
        * */

//        Student alex = new Student();
//        alex.setName("Alexander");

//        Tutor brian = new Tutor();
//        brian.setName("Brian Drave");

        Person andy = new Tutor("Andy Hartono", "Jakarta" ,LocalDate.of(1980,5,6),Gender.L,
                10_000_000.0, EmployeementStatus.PERMANENT);

        Student santi = new Student("Santi Jamila", "Semarang", LocalDate.of(1999, 5, 9), Gender.P, "TI", 89.9);

//        Tutor andySebagaiTutor = (Tutor)andy; //Unboxing
//        Person santiSebagaiPerson = santi; //Autoboxing
//
//        System.out.println(andySebagaiTutor.getEmployeementStatus());
//        System.out.println(santiSebagaiPerson.getBirthCity());


        //-------------------------------------------------------------------------

        //Polimorfisme
        Minister sandi = new Minister("Sandiaga Uno", "Jakarta", LocalDate.of(1981,10,2),
                Gender.L,"1292381","Pendidikan");

        Citizen airlangga = getCitizenImportant();

        LinkedList<Person> people = new LinkedList<>();
        people.add(andy);
        people.add(santi);
        people.add(sandi);
        people.add(airlangga);

//        for ( Person person: people){
//            person.printInfo();
//        }

        //-------------------------------------------------------------------------

        //Encapsulation

        Employee jane = new Employee();
//        System.out.println(jane.name);
        System.out.println(jane.nomorKTP);
//        System.out.println(jane.birthDate);
//        System.out.println(jane.Gender);



    }

    public static Citizen getCitizenImportant(){
        Minister airlangga = new Minister("Airlangga", "Jakarta", LocalDate.of(1981,10,2),
                Gender.L,"1292381","Pendidikan");
        return airlangga;
    }


    public static void printNomorKTP(Citizen citizen){
        System.out.println(citizen.getNomorKTP());
    }

    public static void ubahNegara(){
        StudentIndonesia.setCountry("Thailand");
        System.out.println(StudentIndonesia.getCountry());
    }

    public static void ubahBirthCityStudent(StudentIndonesia studentIndonesia){
        System.out.println(studentIndonesia.getName());
        studentIndonesia.setBirthCity("Jakarta");
    }

    public static void ubahBirthCity(String kotaBaru, StudentIndonesia studentIndonesia){
        studentIndonesia.setBirthCity(kotaBaru);
    }

    public static Integer tambahLimaPoint(Integer input){
//        int hasil;
//        hasil = input + 5;
//        return  hasil;
        return + 5;
    }
}