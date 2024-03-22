package com.indocyber;

/*
* Seperti yang kita tahu, java adalah language yang bersifat OOP, sehingga seluruh function adalah
* method yang sebenarnya bagian dari object, sehingga tidak mungkin sebuah method berdiri sendiri.
*
* Sebagian bahasa pemrograman yang bersifat functional tidak seperti ini, contohnya pada javascript, function bisa berdiri sendiri
* dan function di perlakukan seperti sebuah object (function as first-class object). Sehingga function bisa di simpan dalam heap selayaknya object.
* Pada java version 8 dan setelahnya, java mencoba meng-adaptasi feature ini dengan trick memanfaatkan interface.
*
* menggunakan interface untuk membuat sebuah function menjadi first-class object adalah dengan menggunakan
* Single (Abstract) Method Interface atau lebih umum dikenal dengan sebutan Functional Interface.
*
* Untuk membuat functional interface, sebuah interface hanya boleh memiliki 1 abstract method.
* Interface ini bisa memiliki lebih dari satu static method atau lebih dari default method, tetapi apabila dicode lebih dari satu abstract method,
* maka functional interface tidak terwujud.
*
* Annotation @FunctionalInterface memanfaatkan compiler untuk memastikan kalau fungsi ini tidak melanggar aturan
* pembuatan functional interface. Apabila kalian tambahkan 1 abstract method lagi, akan terjadi compile error.
* */
@FunctionalInterface
public interface EmailNotificationHandler {
    public void sendEmailNotification(String emailAddress, String name, Vaccination vaccination);
}
