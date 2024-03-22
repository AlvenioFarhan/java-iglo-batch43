package com.indocyber;

public interface PendudukIndonesia {
    default void printNomorKtp(String nomorKtp){
        System.out.printf("Penduduk Indonesia - Nomor Ktp: %s\n", nomorKtp);
    }
}
