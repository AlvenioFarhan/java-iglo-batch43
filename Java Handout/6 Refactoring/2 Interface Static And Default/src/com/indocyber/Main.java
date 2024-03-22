package com.indocyber;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        testKaryawan();
        testWarga();
        testPenduduk();
    }

    public static void testKaryawan(){
        KaryawanIndonesia karyawan = getKaryawan();
        System.out.println("Nama: " + karyawan.getNama());
        karyawan.setNomorKtp("K456");
        System.out.println("Nomor KTP: " + karyawan.getNomorKtp());
        Long umur = karyawan.calculateUmur(LocalDate.of(1988, 11, 27));
        System.out.println("Umur: " + umur);
        karyawan.printNomorKtp("I789");
        System.out.println("======================================");
    }

    public static void testWarga(){
        WargaIndonesia warga = getKaryawan();
        WargaIndonesia.printNegara();
        Long umur = warga.calculateUmur(LocalDate.of(1998, 8, 12));
        System.out.println("Umur: " + umur);
        warga.printNomorKtp("I789");
        System.out.println("======================================");
    }

    public static void testPenduduk(){
        PendudukIndonesia penduduk = new PendudukIndonesia() {};
        penduduk.printNomorKtp("A000");
    }

    public static KaryawanIndonesia getKaryawan(){
        return new KaryawanIndonesia("Ben", "O123");
    }
}
