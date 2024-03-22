package com.indocyber;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    /*
    * Pada topic kali ini kita akan belajar menggunakan java bukan sebagai OOP, tetapi sebagai functional programming.
    * Lain dengan OOP dimana seluruh pemrograman berpusat pada object, functional programming berpusat pada function.
    * */
    public static void main(String[] args) {
	    classicUse();
        lambdaExpression();
        syntacticSugar();
        withReturnValue();
    }

    public static void classicUse(){
        Person alex = getExamplePerson();
        Vaccination newVaccination = new Vaccination("Pfizer", LocalDateTime.of(2022, 6, 13, 14, 45), "Faskes B");

        /*
         * Java tidak bisa membuat semacam "function pointer" ke dalam satu variable atau object, sehingga pointer fungsi tersebut digantikan oleh
         * sebuah interface. (Tolong lihat contoh Functional Interface terlebih dahulu)
         *
         * Karena sebenarnya yang di harapkan dari method sendInvitation adalah sebuah function as an object,
         * sama seperti callback pada javascript.
         * */
        EmailNotificationHandler handler = new EmailNotificationHandler() {
            @Override
            public void sendEmailNotification(String emailAddress, String name, Vaccination vaccination) {
                String formattedTanggal = DateTimeFormatter.ofPattern("dd MMMM yyyy").format(vaccination.getVaccineTime());
                System.out.printf("Send: %s... Undangan untuk %s, vaksin %s di lokasi %s.\n", emailAddress, name, formattedTanggal, vaccination.getLocation());
            }
        };
        alex.sendInvitation(handler, newVaccination);

        //Atau kita bisa menulis lebih desctructive seperti dibawah ini tanpa lebih dahulu harus deklarasi.
        alex.sendInvitation(new EmailNotificationHandler() {
            @Override
            public void sendEmailNotification(String emailAddress, String name, Vaccination vaccination) {
                String formattedTanggal = DateTimeFormatter.ofPattern("dd MMMM yyyy").format(vaccination.getVaccineTime());
                System.out.printf("Send: %s... Undangan untuk %s, vaksin %s di lokasi %s.\n", emailAddress, name, formattedTanggal, vaccination.getLocation());
            }
        }, newVaccination);
    }

    public static void lambdaExpression(){
        Person alex = getExamplePerson();
        Vaccination newVaccination = new Vaccination("Pfizer", LocalDateTime.of(2022, 6, 13, 14, 45), "Faskes B");

        /*
        * Penulisan classic pada contoh classicUse diatas masih memperlihatkan kalau sebenarnya yang masuk ke dalam parameter sebagai argument adalah
        * Anonymous Class, bukan sebagai function pointer.
        *
        * Untuk lebih memperjelas kalau ini adalah function pointer, kita bisa menulis dengan menggunakan lambda expression (->)
        * sama seperti functional programming language lainnya.
        *
        * Dengan menggunakan penulisan lambda seperti di bawah ini, itu kita berarti menggunakan feature Anonymous Function,
        * karena tidak ada nama function sama sekali.
        * Lambda ditulis dengan (...parameters) -> {body function}
        * */
        alex.sendInvitation(
            (emailAddress, name, vaccination) -> {
                String formattedTanggal = DateTimeFormatter.ofPattern("dd MMMM yyyy").format(vaccination.getVaccineTime());
                System.out.printf("Send: %s... Undangan untuk %s, vaksin %s di lokasi %s.\n", emailAddress, name, formattedTanggal, vaccination.getLocation());
            }, newVaccination
        );

        //Kita juga bisa menyimpannya dalam anonymous class terlebih dahulu, selama parameternya sesuai
        EmailNotificationHandler handler = (emailAddress, name, vaccination) -> {
            String formattedTanggal = DateTimeFormatter.ofPattern("dd MMMM yyyy").format(vaccination.getVaccineTime());
            System.out.printf("Send: %s... Undangan untuk %s, vaksin %s di lokasi %s.\n", emailAddress, name, formattedTanggal, vaccination.getLocation());
        };
        alex.sendInvitation(handler, newVaccination);
    }

    public static void syntacticSugar(){
        Person alex = getExamplePerson();
        //Apabila functional interface hanya memiliki satu parameter, kita bahkan tak perlu menuliskan () bracket sama sekali
        //Apabila functional interface hanya memiliki 1 baris statement pada implementasinya, kita bahkan tak perlu menuliskan {} code block sama sekali.
        alex.sendInvitation(name -> System.out.printf("Kami mengundang sudara %s untuk vaksin\n", name));
    }

    /*
    * Ini adalah contoh lain yang lebih complex, dimana functional interface melakukan return value dan fungsi dari checkValidBooster adalah
    * kombinasi dari implementasi sendiri dan tambahan handler.
    * */
    public static void withReturnValue(){
        Person alex = getExamplePerson();
        boolean result = alex.checkValidForBooster( bloodPressures -> {
            return bloodPressures[0] <= 95 && bloodPressures[0] >= 70 && bloodPressures[1] <= 150 && bloodPressures[1] >= 95;
        }, new Integer[]{85, 125});
        System.out.println(result);
    }

    public static Person getExamplePerson(){
        List<Vaccination> vaccinations = new ArrayList<>();
        vaccinations.add(new Vaccination("Sinovac", LocalDateTime.of(2021, 11, 5, 14, 45), "Faskes A"));
        Person alex = new Person("Alexander", "123",
            LocalDate.of(1989, 10, 20),
            new Integer[]{125, 80}, vaccinations,
            "alexander@gmail.com", "08151234567");
        return alex;
    }
}
