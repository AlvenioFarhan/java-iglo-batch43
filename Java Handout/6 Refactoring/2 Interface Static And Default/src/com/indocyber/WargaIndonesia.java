package com.indocyber;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/*
* Yang selama ini kita pelajari, interface adalah bentuk abstraksi yang tidak memiliki field dan seluruh methodnya
* harus bersifat abstract atau dalam kata lain tidak memiliki implementasi.
*
* Di dalam java, ini ada pengecualian untuk method dengan tipe static dan method dengan access modifier default.
* Untuk method static dan method default, keduanya bisa memiliki implementasi.
* */
public interface WargaIndonesia {
    public String getNama();
    public void setNama(String name);
    public String getNomorKtp();
    public void setNomorKtp(String nomorKtp);

    /*
    * Static method pada interface tidak bisa di override seperti super dan abstract method pada umumnya.
    * */
    private static String getNegara() {
        return "Indonesia";
    }
    public static void printNegara() {
        System.out.printf("Negara: %s\n", getNegara());
    }

    /*
    * Default access modifier di java aslinya tidak perlu dan tidak bisa dituliskan kata "default",
    * tetapi default di sini berbeda dengan default yang sebelumnya dan harus dituliskan.
    *
    * Default methods pada interface dikenal juga dengan sebutan "defender methods".
    * Defender method sebenarnya adalah solusi "terpaksa" yang ditambahkan ke java 8 dikarenakan masalah yang timbul ketika para programmer
    * ingin meng-update interface-interface java pada aplikasi atau library yang sudah tua, dimana interface tersebut sudah diimplement banyak sekali.
    * Sehingga apabila kita menambahkan 1 saja abstract method, class yang akan mengalami error akan banyak sekali.
    *
    * Solusi default method ini memberikan kemudahan cepat menambahkan feature pada interface dengan backward compatibility,
    * dimana programmer tidak perlu melakukan refactor terhadap seluruh library atau aplikasinya.
    *
    * Menurut saya pribadi, default method adalah feature "in case of emergency, break the glass".
    * Jadi apabila situasi tidak memaksa, solusi lain bisa digunakan ketimbang menggunakan default method.
    * */
    default Long calculateUmur(LocalDate birthDate) {
        return ChronoUnit.YEARS.between(birthDate, LocalDate.now());
    }

    default void printNomorKtp(String nomorKtp){
        System.out.printf("Warga Indonesia - Nomor Ktp: %s\n", nomorKtp);
    }
}