package com.indocyber;

import java.sql.SQLOutput;

public class KaryawanIndonesia implements WargaIndonesia, PendudukIndonesia{

    private String name;
    private String nomorKtp;

    public KaryawanIndonesia() {
    }
    public KaryawanIndonesia(String name, String nomorKtp) {
        this.name = name;
        this.nomorKtp = nomorKtp;
    }

    @Override
    public String getNama() {
        return this.name;
    }
    @Override
    public void setNama(String name) {
        this.name = name;
    }
    @Override
    public String getNomorKtp() {
        return this.nomorKtp;
    }
    @Override
    public void setNomorKtp(String nomorKtp) {
        this.nomorKtp = nomorKtp;
    }

    /*
    * Override untuk default method cukup dilema, kenapa?
    * Karena selama ini sebuah child class melakukan override dimana method yang di-override memiliki implementasi, hanya berasal dari satu sumber.
    *
    * Maksudnya adalah parent dari child class yang bisa memiliki method dengan implementasi hanya dari super class atau abstract class.
    * Parent dalam bentuk super class atau abstract class hanya bisa di inherit dengan cara "extends" dan kita hanya bisa meng-extend 1 parent class.
    *
    * Lain dengan meng-implement interface, kita bisa meng-implement multiple interface. Tetapi normalnya, seluruh method di dalam interface bersifat
    * abstract, sehingga sudah pasti satu-satunya childnya yang memiliki implementasi.
    * Tapi lain dengan kasus default method dimana kedua parent interface memiliki body method.
    * */
    @Override
    public void printNomorKtp(String nomorKtp){
        System.out.printf("Karyawan Indonesia - Nomor KTP: %s\n", this.nomorKtp);

        /*
        * Dilema terjadi ketika kita ingin meng-invoke method dari parent, normalnya kita tinggal menggunakan kata super.
        * Untuk memberikan control pada programmer, kita bisa menuliskan nama interfacenya sebelum kata super
        * */
        PendudukIndonesia.super.printNomorKtp(nomorKtp);
        WargaIndonesia.super.printNomorKtp(nomorKtp);
    }

}
