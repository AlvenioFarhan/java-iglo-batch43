import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        int angka = 56;
        int number ; //variable declaration
        number = 89; //set value atau assign value

//        System.out.println(angka);
//        System.out.println(number);

        short pendek = 3_200;

        int number1 = 1_000_000_000;
        int contoh = 2_000_000_000 + number1;
//        System.out.println(contoh);

        //Primitive data type
        //primitive tidak boleh null
        short pendek1 = 89;
        int angka1 = 3_000_000;
        long panjang = 4_000_000_000l;

        double desimal = 56.78;

        boolean yesOrNo = true;

        char satuHuruf = 'H';


        // Wrapper Class/ Data Class
        String nama = "Alvenio Farhan";

        Short jumlah = 12;
        Integer number2 = null;
        Long siPanjang = 457000l;
        Double harga = 78.90;
        Boolean isMarried = false;
        Character letter = 'M';


//        System.out.println(number2);

        // Wajib Camel Case, untuk penamaan variable
        // alvenioFarhanPrayogo

//        Scanner scannerVariable = new Scanner(System.in);

//        System.out.println("Nama Kamu Siapa?");
//        String namaAnda = scannerVariable.nextLine();
//
//        System.out.println("Nama anda adalah " + namaAnda);


        String country;
        country = "Indonesia";
        country = "Thailand";

//        System.out.println(country);

        // Scope {}
        // Code Blok

        {
            String namaOrang = "Alvenio"; //ini Code Blok
        }
        {
            String namaOrang = "Farhan";
        }


        String namaOrang = "Joko"; // Global
        {//Scope 1
            String test = "Test"; // Local
            namaOrang = "Budi";
            {//Scope 1.1
//                System.out.println(namaOrang);
                String wilayah = "Tomang";
            }
            {//Scope 1.2
                String wilayah = "Grogol";
            }
        }
        {//Scope 2
            namaOrang = "Putin";
        }
//        System.out.println(namaOrang);


        /*
         * 1. implicit Conversions
         * 2. explicit Conversions (Memaksa) (Casting)
         * 3. Conversion with Wrapper class / Helper Method
         * */

        //Implicit Conversions
        short pendek2 = 45;
        int angka2 = pendek2;

//        System.out.println(angka2);

        int number3 = 3;
        long panjang1 = number3;

        int angkaPertama = 78;
        int angkaKedua = 56;
        long hasilJumlah = angkaPertama + angkaKedua;

        double desimal1 = number3;
        desimal1 = hasilJumlah;


        //Explicit Conversions
        double totalTabungan = 45000.00;
        long baru = (long)totalTabungan;

//        System.out.println(baru);

        long contohLain = 3_000_000_000l;
        int paksa =  (int)contohLain; //Casting
//        System.out.println(paksa);

        double diskon = 0.45;
        int quantity = 5;
        double price = 35_000;

        long hasil = (long)(diskon * quantity * price);
//        System.out.println(hasil);



        //Wrapper
        int primitive = 90;
        Integer wrapper = 78;

//        String result = wrapper.toString();
//        String hasil = ((Integer)primitive).toString();

//        String result = wrapper.toString();
//        String hasil = Integer.toString(primitive);

//        System.out.println(result);
//        System.out.println(hasil);
//        System.out.println(result + hasil);

        //Convert String to ...
        String input = "56";
        int converttoInteger = Integer.parseInt(input);
        long convertToLong = Long.parseLong(input);
        int multiplier = 2;
//        System.out.println(converttoInteger * multiplier);

        String coba = "4000000000";
        double converttoDouble = Double.parseDouble(coba);
        long coba1 = Long.parseLong(coba);
//        System.out.println(converttoDouble * multiplier);
//        System.out.println(coba1);

        Long cobaDulu = 7800l;
        Integer outcome = cobaDulu.intValue();
//        System.out.println(outcome);

        double unitpricee = 87_500.67;

        Locale indonesia = new Locale("id", "ID");
        NumberFormat alatFormat = NumberFormat.getCurrencyInstance(indonesia);
//        System.out.println(alatFormat.format(unitpricee));

//        double diskon1 = 0.56;
        NumberFormat persenFormat = NumberFormat.getPercentInstance(indonesia);
//        System.out.println(persenFormat.format(diskon1));


        //Anonymous Declaration
        var sebuahVariable = "Hello";

//        int contoh;
//        var contohLagi;


//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Siapa Nama Anda :");
//        String fullName = scanner.nextLine();
//
//        System.out.println("Dimana anda lahir :");
//        String birthCity = scanner.nextLine();
//
//        System.out.println("Apa Kelamin anda :");
//        String gender = scanner.nextLine();
//
//        System.out.println("Apa pekerjaan anda :");
//        String job = scanner.nextLine();

        //Saya adalah seorang Laki-laki, bernama Alvenio dan saya lahir di Semarang. Pekerjaan saya saat ini adalah Programmer.

//        String output = String.format("Saya adalah seorang %s, bernama %s dan saya lahir di %s. Pekerjaan saya saat ini adalah %s.",
//                gender, fullName,birthCity, job);
//        System.out.println(output);

//        System.out.printf("Saya adalah seorang %s, bernama %s dan saya lahir di %s. Pekerjaan saya saat ini adalah %s.\n",
//                gender, fullName,birthCity, job);

//        System.out.println("End Of Line");



        //Deprecated - Obsolute(Usang)
        LocalDate pemilu= LocalDate.of(2024,2,14);
        var valentine = LocalDate.of(2024, Month.FEBRUARY, 14);
//        System.out.println(pemilu);


        //GETDATE Hari ini
        LocalDate hariIni = LocalDate.now();
//        System.out.println(hariIni);


        //JAM SEKARANG
        LocalTime jamMasuk = LocalTime.of(8,30);
        LocalTime jamSekarang = LocalTime.now() ;
//        System.out.println(jamMasuk);
//        System.out.println(jamSekarang);


        LocalDateTime jadwalMeeting = LocalDateTime.of(2024,2,28,8,30);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy hh:mma", indonesia);
//        System.out.println(formatter.format(jadwalMeeting));

        LocalDateTime hariIni1 = LocalDateTime.now();
        Integer bulan = hariIni1.getMonthValue();
        boolean isLeapYear = pemilu.isLeapYear();
        var totalHariDalamBulan = valentine.lengthOfMonth();

//        System.out.println(bulan);
//        System.out.println(isLeapYear);
//        System.out.println(totalHariDalamBulan);

        var setelahValentine = valentine.plusDays(70);
//        System.out.println(setelahValentine);

        var birthDate = LocalDate.of(1988,11,27);
        var saatIni = LocalDate.now();

        long tahunUmur = ChronoUnit.YEARS.between(birthDate, saatIni);
//        System.out.println(tahunUmur);



    }
}