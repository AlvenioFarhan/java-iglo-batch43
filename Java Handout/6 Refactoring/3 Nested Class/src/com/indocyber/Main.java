package com.indocyber;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        /*
        * Nested Class adalah feature pada java dimana kita bisa menulis class di dalam class.
        * Nested class dimanfaatkan untuk memaksimalkan potensi enkapsulasi, sehingga sesama class bisa share member secara globally tetapi tetap
        *   di declare private di dalamnya, sehingga code lebih mudah di maintain.
        *
        * Pemakaian nested class sendiri biasa saya gunakan untuk class konfigurasi atau helper class.
        * */
        LocalDate birthDate = LocalDate.of(1988, 11, 27);
        String formatted = OuterHelper.DateTimeHelper.getLongFormat(birthDate);
        OuterHelper.DateTimeHelper dateTimeHelper = new OuterHelper.DateTimeHelper();
        long age = dateTimeHelper.calculateAge(birthDate);

        OuterHelper.DataBaseHelper dataBaseHelper = new OuterHelper().new DataBaseHelper("3000", "Basilisk", "boby.widjaja", "1234");
        dataBaseHelper.connectingToDB(LocalDate.now());
        OuterHelper.DataBaseHelper.disconnectAllConnection();

        OuterHelper outerHelper = new OuterHelper();
        outerHelper.sendNotification("0815233467", "test@gmail.com");
    }
}
