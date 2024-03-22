import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        /*
        * Kelebihan :
        * 1. Berbasis index (Pencarian Cepat)
        * 2. Multi dimensi
        *
        * Kekurangan :
        * 1. ukuran fixed/ pas
        * 2. index harus berupa integer dimulai dari 0
        * */

//        Integer[] koleksiAngka = new Integer[5];
//        koleksiAngka[0] = 56;
//        koleksiAngka [1] = 123;
//        koleksiAngka [2] = 78;
//
//        System.out.println(koleksiAngka[3]);
//
//        String[] paraCandidates = {"Rio", "Eky", "Oksen"}; //3
//
//        paraCandidates[1] = "Boby";
//
//        System.out.println(paraCandidates[1]);
//
//        Double[] transactions = {99.56, 77.9};

        //---------------------------------------------------------------------------

//        Integer[] koleksiAngka = {20,21,22}; //Reference Type
//        Integer angka = 77; //Value Type
//
//        Integer[] numberCollection = koleksiAngka;
//        Integer number = angka;
//
//        number = 88;
//        numberCollection[0] = 40;
//
//        System.out.println(angka); //77 (ambil nilai lama)
//        System.out.println(koleksiAngka[0]); //40 (ambil nilai yang baru)
//
//        Integer[] koleksiBaru = {99,100};
//        System.out.println(koleksiBaru[0]);

        //---------------------------------------------------------------------------

        //For Each
//        String[] candidates = {"Rio", "Oksen", "Ekky", "Rully"};
//
//        for ( String kandidat : candidates){
//            System.out.println(kandidat);
//        }

        //---------------------------------------------------------------------------

//        Double[] jumlahDouble = {1,2,3};

        //---------------------------------------------------------------------------

        //function penjumlahan dengan menggunakan Array
//        Double[] deretAngka = {1.5, 2.5, 3.5};
//        System.out.println(jumlahDouble(deretAngka));

        //---------------------------------------------------------------------------


//        Double[][] deretOngkos = new Double[3][];
//
//        deretOngkos[0] = new Double [3];
//        deretOngkos[0][0] = 7800.9;
//        deretOngkos[0][1] = 8900.34;
//        deretOngkos[0][2]= 12000.90;
//
//        deretOngkos[1] = new Double [2];
//        deretOngkos[1][0] = 5600.34;
//        deretOngkos[1][1] = 13000.45;
//
//        deretOngkos[2]  = new Double [3];
//        deretOngkos[2][0] = 7600.90;
//        deretOngkos[2][1] = 44000.0;
//        deretOngkos[2][2] = 150000.0;
//
//        System.out.println(deretOngkos[1][1]);


        //belum bisa var
//        Double[][] deretOngkos = {
//                {7800.9, 8900.34, 12000.90},
//                {5600.34, 13000.45},
//                {7600.90, 44000.0, 150000.0}
//        };
//
//        var contoh = new Double[3];
//
//        System.out.println(deretOngkos[1][1]);


        //---------------------------------------------------------------------------


        //Link List
        //Link Array

        LinkedList<String> candidate = new LinkedList<String>();
        candidate.add("Rio");
        candidate.add("Boby");
        candidate.add("Vina");

        System.out.println(candidate.get(2));

        LinkedList<Double> deretAngka = new LinkedList<Double>();
        deretAngka.add(19.01);
        deretAngka.add(20.24);

        var numbers = new LinkedList<Integer>();

        ArrayList<Integer> banyakAngka = new ArrayList<>();
        banyakAngka.add(56);

    }

//    public static Integer perubahan(Integer[] koleksiSesuatu, Integer sesuatu){
//        sesuatu = 88;
//        koleksiSesuatu[0] = 40;
//        return sesuatu;
//    }

    //Membuat fungsi yang mengembalikan table array. Menjumlahkan value table array





    public static Double jumlahDouble (Double[] koleksiDouble) {
        Double jumlah = 0.0;
        for (Double deretAngka : koleksiDouble) {
            if (deretAngka != null) {
                jumlah += deretAngka;
            }
        }
        return jumlah;
    }

}