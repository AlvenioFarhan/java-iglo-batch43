package com.indocyber;
import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Stream;

public class Main {

    /*
     * Optional adalah generic type yang disediakan java stream, yang gunanya sebagai solusi alternatif
     * untuk memberikan nilai nullable kepada satu variable atau object tanpa harus memberikan
     * null reference kepada object atau variable tersebut.
     *
     * Kenapa memakai Optional? Kenapa tidak dengan null seperti biasa?
     * Karena library Optional memberikan macam-macam feature, seperti fungsi melakukan check, subtitusi value, dan lain sebagainya.
     * Sehingga kita tidak perlu melakukan semua itu secara manual.
     *
     * Optional juga digunakan oleh beberapa framework dan library, sehingga dengan belajar menggunakan optional
     * kita mengerti cara menggunakannya.
     * */
    public static void main(String[] args) {
        introduction();
        probablyNull();
        subtitusi();
        filterCondition();
        chainTheProcesses();
    }

    public static void introduction(){
        /*
        * Karena optional adalah generic type, jadi tidak bisa digunakan untuk tipe data primitive, harus dengan wrapper class atau class.
        * Untuk mengosongkan nilai optional, ketimbang diisi dengan null value, kita menggunakan method empty.
        * Untuk menginput nilai, kita menggunakan method of.
        * */
        Optional<String> emptyWords = Optional.empty();
        Optional<String> words = Optional.of("Hello World");
        Optional<Employee> employeeKosong = Optional.empty();
        Optional<Employee> aldi = Optional.of(new Employee("Aldi", "Programmer"));

        //Pastinya kita juga bisa melakukan polymorphism di dalam optional
        Optional<Person> ben = Optional.of(new Employee("Ben", "Accountant"));

        /*
        * Method isPresent dan isEmpty adalah method yang digunakan untuk check apakah object ini memiliki value atau empty.
        * isPresent dan isEmpty mengembalikan nilai boolean.
        * */
        boolean isEmptyWordsPresent = emptyWords.isPresent();
        boolean isWordsPresent = words.isPresent();
        boolean isEmptyWordsEmpty = emptyWords.isEmpty();
        boolean isWordsEmpty = words.isEmpty();
    }

    public static void probablyNull(){
        Employee sandra = new Employee("Sandra", "Designer");
        Employee nullEmployee = null;

        //Kalau kita lihat, method of sendiri akan langsung mengalami run-time error ketika argument diisi dengan sesuatu yang null
        //Optional<Employee> willBeNull = Optional.of(nullEmployee);

        /*
        * Sebagai solusi, Optional memberikan kita ofNullable method, dimana method tersebut bisa menerima argument null atau yang memiliki value.
        * ofNullable pastinya akan kita gunakan ketika kita mendapatkan satu variable atau object, tetapi kita ragu apakah isinya null atau memiliki value.
        * */
        Optional<Employee> nullableOne = Optional.ofNullable(sandra);
        Optional<Employee> nullableTwo = Optional.ofNullable(nullEmployee);

        System.out.println(nullableOne.isPresent());
        System.out.println(nullableTwo.isPresent());
    }

    public static void subtitusi(){
        /*
        * Salah satu feature dari Optional yang sangat membantu adalah kemampuan subtitusi dengan menggunakan method
        * orElse dan orElseGet.
        *
        * orElse digunakan untuk memilih default satu object atau variable, apabila object atau variable utama yang diset bernilai null.
        * orElseGet adalah versi orElse yang menerima lambda atau menjalankan sebuah function ketika menemukan null.
        * */
        Employee alex = new Employee("Alex", "Auditor");
        Employee reynald = new Employee("Reynald", "Tester");
        Employee nullEmployee = null;

        Employee employeeOne = Optional.ofNullable(alex).orElse(reynald);
        Employee employeeTwo = Optional.ofNullable(nullEmployee).orElse(reynald);
        Employee employeeThree = Optional.ofNullable(nullEmployee).orElseGet(Main::getAndri);

        System.out.println(employeeOne.getName());
        System.out.println(employeeTwo.getName());
        System.out.println(employeeThree.getName());
    }

    public static Employee getAndri(){
        return new Employee("Andri", "Analyst");
    }

    /*
    * Karena optional masih bagian dari stream, kita juga masih bisa menggunakan intermediate dan terminal dari stream operation.
    * */
    public static void filterCondition(){
        Optional<Integer> angka = Optional.of(67);
        boolean isSmaller = angka.filter(parameter -> parameter < 100).isPresent();
        Integer number = angka.filter(parameter -> parameter < 100).get();
        boolean isBigger = angka.filter(parameter -> parameter > 100).isPresent();
    }

    public static void chainTheProcesses(){
        Employee sandra = new Employee("Sandra", "Manager");
        sandra.setHireDate(LocalDate.of(2000, 5, 6));

        Employee bima = new Employee("Bima", "Supervisor");
        bima.setHireDate(LocalDate.of(2021, 11, 12));

        Optional<Employee> sandraOptional = Optional.of(sandra);
        Optional<Employee> bimaOptional = Optional.of(bima);

        boolean isRewarded = sandraOptional
            .map(Employee::getDuration)
            .filter(parameter -> parameter >= 20)
            .isPresent();
        System.out.println(isRewarded);

        sandraOptional.map(Employee::getDuration)
            .filter(parameter -> parameter >= 20)
            .ifPresent(parameter -> System.out.printf("Work for %s years, rewarded\n", parameter));

        bimaOptional.map(Employee::getDuration)
            .filter(parameter -> parameter >= 20)
            .ifPresentOrElse(
                parameter -> System.out.printf("Work for %s years, rewarded.\n", parameter),
                () -> System.out.println("Not yet rewarded.")
            );
    }

}
