package com.company;
import java.util.*;

public class Main {

    /*
    * Anonymous Class adalah feature di dalam java dimana kita bisa meng-implementasikan sebuah abstraksi tanpa membuat class terlebih dahulu.
    *
    * Sebenarnya feature anonymous class dibuat berdasarkan pengembangan feature local class / nested class. Jadi bisa dibilang anonymous class adalah
    * nested class yang tidak memiliki nama class atau kita tida perlu defined classnya.
    *
    * Anonymous class diciptakan untuk membuat programmer mengimplementasikan abstraksi (abstract class atau interface) lebih singkat,
    * lebih cepat, dan lebih sedikit syntaxnya, dimana bermanfaat apabila programmer ingin mengimplementasikan abstraksinya sekali saja.
    * Note: apabila ingin pakai berkali-kali ini tidak efektif.
    * */
    public static void main(String[] args) {
        introduction();
        settingField();
        usingClass();
    }

    public static void introduction(){
        /* Student adalah interface yang seharusnya tidak mungkin di-implementasikan tanpa class,
         * pada anonymous ini kita bisa meng-implementasikan dan membuatkan override method tanpa harus membuat class terlebih dahulu.
         * */
        Student student = new Student() {
            @Override
            public void printInformation() {
                System.out.println("This is printInformation method from Student Interface");
            }
        };
        student.printInformation();

        //Karena ini anonymous class, kita tidak akan bisa mendapatkan nama class dengan jelas.
        System.out.println(student.getClass());

        /*
        * Sama seperti object pada umumnya, setelah di construct, kita bisa langsung meng-invoke methodnya.
        * Penggunaan anonymous class juga cukup favourite digunakan seperti ini, dimana kita memiliki kewajiban untuk
        * mengimplementasikan abstraksinya dari sebuah library atau framework, tetapi kita hanya interest untuk meng-override dan
        * menggunakan methodnya 1 kali saja.
        * */
        new Student() {
            @Override
            public void printInformation() {
                System.out.println("Use the method directly");
            }
        }.printInformation();

        /*
        * Contohnya adalah apabila kita melihat sebuah method yang menerima tipe data interface Student, dan
        * code kita hanya ingin membuat 1 buah object yang meng-implementasi dan meng-override method print informasi
        * hanya untuk kepentingan menggunakan method ini satu kali saja.
        *
        * Rasanya cukup membuang waktu dan menulis banyak code apabila kita sengaja membuat class hanya untuk keperluan
        * satu kali ini saja.
        * */
        printStudentInformation(new Student() {
            @Override
            public void printInformation() {
                System.out.println("Use anonymous in parameter.");
            }
        });
    }

    public static void printStudentInformation(Student student){
        student.printInformation();
    }

    public static void settingField(){

        /*
        * Keuntungan lainnya dalam menggunakan anonymous class lainnya adalah dengan memanfaatkan scope of object / variable.
        * Kalau kita lihat di sini, printInformation method bisa menggunakan variable name yang kita declare di luar scope dengan konsep global atau local terhadap scope.
        * */
        String name = "Alexander";

        Employee employee = new Employee() {

            /*Kita juga bisa men-defined field di dalam anonymous class, tapi karena anonymous class yang berasal dari
            * interface tidak memiliki constructor, sehingga cara untuk memberikan value padanya adalah dengan set method atau di assign saat deklarasi.
            *
            * Note!: di sini kita melihat adanya deklarasi static field salary.
            * Di sebagian versi java, static field tidak bisa di deklarasi di dalam anonymous method,
            * di sebagian versinya lagi static field bisa di deklarasi jika disertai final statement,
            * tetapi versi java yang baru tidak ada restriction seperti itu.
            * Saya pribadi sarankan untuk menulis final pada static field dan langsung assign pada saat deklarasi untuk pemakaian.
            * */
            public String employeeNumber;
            public static final double salary = 9000000.0;

            @Override
            public void setEmployeeNumber(String employeeNumber) {
                this.employeeNumber = employeeNumber;
            }
            @Override
            public String getEmployeeNumber() {
                return this.employeeNumber;
            }
            @Override
            public Double getAnnualSalary() {
                return 12 * salary;
            }
            @Override
            public void printInformation(String company) {
                System.out.printf("Name: %s, Company: %s\n", name, company);
            }
        };
        employee.setEmployeeNumber("A123");
        String employeeNumber = employee.getEmployeeNumber();
        Double annualSalary = employee.getAnnualSalary();
        employee.printInformation("Indocyber");
        System.out.printf("Employee number: %s, Annual: %s\n", employeeNumber, annualSalary);
    }

    public static void usingClass(){
        /*
        * Kita juga bisa menggunakan anonymous class untuk meng-extend super class dan abstract class.
        * Di sini kita bisa menggunakan constructor dan extended member.
        * */
        Person person = new Person("Veronica"){
            @Override
            public void printInformation(){
                List<MobilePhone> phones = getPhones();
                for(MobilePhone phone : phones){
                    System.out.println(phone.getBrand());
                }
            }
        };
        System.out.println(person.getName());
        person.setName("Vera");
        person.printName();
        person.printInformation();
        System.out.println(person.getClass());
    }
}
