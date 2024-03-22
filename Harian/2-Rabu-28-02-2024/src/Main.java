import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        int angka = 4;
//        var hasil = angka > 5;

        //memenuhi = true
        //tidak memenuhi = false

//        if (!hasil){
//            System.out.println("Memenuhi Hasil");
//        }



//        int age = 25;
//        double cash = 100_000;
//
//        boolean hasilUmur = age > 17;
//        boolean hasilCash = cash >= 50_000;
//
//        boolean hasil = hasilUmur && hasilCash;
//
//        if (hasil){
//            System.out.println("Memenuhi Kondisi");
//        }


//
//        if (age > 17 && cash >= 50_000){
//            System.out.println("Memenuhi Kondisi");
//        } else {
//            System.out.println("Tidak Memenuhi Kondisi");
//        }



//        int input = 9;
//
//        if(input == 1) {
//            System.out.println("Satu");
//        }else if (input == 2) {
//            System.out.println("Dua");
//        } else if (input == 3){
//            System.out.println("Tiga");
//        } else {
//            System.out.println("Input tidak ada pilihannya");
//        }




        //Switch Case
//        int pilihan = 3;
//
//        switch (pilihan){
//            case 1:
//                System.out.println("Teh Botol");
//                break;
//            case 2:
//                System.out.println("Coca-cola");
//                break;
//            case 3:
//                System.out.println("Sprite");
//                break;
//            case 4:
//                System.out.println("Fanta");
//                break;
//            default:
//                System.out.println("Default");
//                break;
//        }




        /*
        * 1. for loop
        * 2. while
        * 3. do while
        * 4. recursion (function)
        * 5. for each (collection)
        * */

//        int jumlahMartabak = 12;

//        jumlahMartabak = jumlahMartabak - 4;
//        jumlahMartabak -= 4;

//        jumlahMartabak -=1;
//        jumlahMartabak--;
//        --jumlahMartabak;

//        System.out.println(--jumlahMartabak);
//        System.out.println(jumlahMartabak);


        /*
        * Persyaratan Iteration
        * 1. Kondosi dimulai
        * 2. Kondisi tetap berlangsung/berhenti
        * 3. Perubahan(update) kondisi
        *
        *
        * break
        * continue
        * go (Sudah tidak digunakan)
        * return (function)
        * */

//        for (int index = 0; index < 10; index++){
//            System.out.printf("Hello World %s\n", index);
//        }
//
//        for (int index = 0; index < 10; index++){
//            int test = 1;
//            System.out.println("Nomor Urut "+ index);
//        }


//        for (int indexSatu = 0; indexSatu < 10; indexSatu++){
//            for (int indexDua = 0; indexDua < 10; indexDua++){
//                System.out.printf("%s , %s\n", indexSatu, indexDua);
//            }
//        }




//        for (int indexSatu = 0; indexSatu < 10; indexSatu++){
//            if (indexSatu == 4){
//            break;
//            }
//            System.out.println(indexSatu);
//        }




        //input pakai scanner, mau break di angka berapa? masukkan angka 0-9. yang di print sesuai inputan

        Scanner scanner = new Scanner(System.in);

        System.out.println("Mau Break di angka berapa :");
        int breakLine = Integer.parseInt(scanner.nextLine());

        for (int indexSatu = 0; indexSatu < 10; indexSatu++){
            if (indexSatu == breakLine){
                break;
            }
            System.out.println(indexSatu);
        }



//        //While
//        int indexBaru = 0;
//        while (indexBaru < 10){
//            System.out.println(indexBaru);
//            indexBaru++;
//        }




        //user harus masukan input berupa angka dari 1 - 4
        //Input diterima!
        //Input salah, coba lagi!

//        Scanner scanner = new Scanner(System.in);

//        boolean isAccepted = false;
//
//        while (!isAccepted){
//            System.out.println("Masukkan input berupa angka dari 1 - 4 :");
//            int input = Integer.parseInt(scanner.nextLine());
//
//            isAccepted = input > 0  && input <= 4;
//            if (isAccepted){
//                System.out.println("Input diterima!");
//            } else {
//                System.out.println("Input salah, coba lagi!");
//            }
//        }




//        int index = 0;
//        do {
//            System.out.printf("Do While: %s\n", index);
//            index++;
//        } while (index < 10);
//
//        int number = 0;
//        while (number < 10){
//            System.out.printf("While: %s\n", number);
//            number++;
//        }




//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Masukkan Angka : ");
//        String input = scanner.nextLine();
//
//        System.out.println("Sebelum di parsing");
//
//        try {
//            Integer angka = Integer.parseInt(input);
//            System.out.printf("TRY SUKSES! %s \n", angka);
//        }catch (Exception exception) {
//            System.out.println("Ada Run-Time Error, Catch dijalankan");
//            //cek error menggunakan exception
//            System.out.println(exception.getMessage());
//            System.out.println(exception.toString());
//        }
//        System.out.println("Setelah diparsing");





//        Scanner scanner = new Scanner(System.in);
//
//        boolean isValid = false;
//
//        while (!isValid){
//            System.out.println("Masukkan Angka :");
//            String input = scanner.nextLine();
//
//            try {
//                Integer angka = Integer.parseInt(input);
//                System.out.printf("TRY SUKSES! %s \n", angka);
//                isValid = true;
//            } catch (Exception exception){
//                System.out.println("Yang anda masukkan tidak valid, coba lagi!");
//            }
//
//        }



    }
}