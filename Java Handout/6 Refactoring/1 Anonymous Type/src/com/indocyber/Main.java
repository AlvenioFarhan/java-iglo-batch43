package com.indocyber;

public class Main {

    public static void main(String[] args) {
        /* Anymous data type adalah feature dari java versi 9 atau yang lebih baru, dimana digunakan sebagai syntatic sugar
         * bagi developer untuk lebih simple dan lebih mudah mendeklarasi sebuah object atau variable.
         *
         * Anonymous data type memiliki beberapa characteristik:
         * 1. Var tidak bisa di deklarasi tanpa di assign, karena tipe data var dibuat pada saat assign value.
         * 2. variable yang di declare var dan di assign akan selamanya menjadi deklarasi tersebut, sehingga tidak bisa dipakai sebagai tipe data lain.
         * 3. var tidak bisa digunakan untuk parameter atau pun return declaration.
         * 4. var secara default tidak akan melakukan polymorphism.
         * 5. var cenderung memilih tipe data primitive
         */

        var contohString = "Hello World";
        //contohString = 90; contohString sudah selamanya akan menjadi String sejak inisialisasi pertama, sehingga tidak bisa jadi integer.
        System.out.println(contohString.getClass());

        var contohInteger = 56;
        System.out.println(contohInteger);

        var contohItem = new Item("Makanan", 5000.0);
        System.out.println(contohItem.getClass());

        var contohPerson = new Person("Jack", "Male");
        System.out.println(contohPerson.getClass());

        var contohEmployee = new Employee("Jennifer", "Female", "A1243");
        System.out.println(contohEmployee.getClass());

    }

}
