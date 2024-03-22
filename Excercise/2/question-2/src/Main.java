import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //bulan
        int bulan;
        while(true) {
            System.out.print("Masukkan Bulan (1-12): ");
            String input = scanner.nextLine();
            try {
                bulan = Integer.parseInt(input);
                if (bulan < 1 || bulan > 12) {
                    throw new Exception();
                }
                break;
            } catch (Exception exception) {
                System.out.println("Harus input antara 1 sampai 12");
            }
        }

        //tahun
        int tahun ;
        while(true) {
            System.out.print("Masukkan Tahun: ");
            String input = scanner.nextLine();
            try {
                tahun = Integer.parseInt(input);
                break;
            } catch (NumberFormatException exception) {
                System.out.println("Input masih salah, tolong coba lagi");
            }
        }

        //memunculkan tanggal akhir pada bulan
        LocalDate tanggalAkhir = LocalDate.of(tahun, bulan, 1).plusMonths(1).minusDays(1);
        System.out.println("Tanggal tertinggi pada " + tanggalAkhir.getMonth() + " " + tahun + " ini adalah " + tanggalAkhir.getDayOfMonth());


        //tanggal
        int tanggal;
        while(true) {
            System.out.print("Masukkan Tanggal: ");
            String input = scanner.nextLine();
            try {
                tanggal = Integer.parseInt(input);
                if (tanggal < 1 || tanggal > tanggalAkhir.getDayOfMonth()) {
                    throw new Exception();
                }
                break;
            } catch (Exception exception) {
                System.out.println("Harus input antara 1 sampai " + tanggalAkhir.getDayOfMonth());
            }
        }

        //pertanyaan
        int pertanyaan;
        while (true){
            System.out.println("Pilih nomor 1 - 3");
            System.out.println("1. Penambahan Hari");
            System.out.println("2. Penambahan Bulan");
            System.out.println("3. Penambahan Tahun");
            try {
                pertanyaan = Integer.parseInt(scanner.nextLine());
                if (pertanyaan < 1 || pertanyaan > 3) {
                    throw new Exception();
                }
                break;
            } catch (Exception exception) {
                System.out.println("Anda harus memilih antara 1, 2 atau 3");
            }
        }

        //hasil pilihan pertanyaan
        int jarak;
        while (true){
            switch (pertanyaan){
                case 1:
                    System.out.print("Berapa hari kemudian dari tanggal ini? ");
                    break;
                case 2:
                    System.out.print("Berapa bulan kemudian dari tanggal ini? ");
                    break;
                case 3:
                    System.out.print("Berapa tahun kemudian dari tanggal ini? ");
                    break;
            }
            try {
                jarak = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception exception){
                System.out.println("Input salah coba lagi");
            }
        }

        // Proses penambahan dan output hasil
        LocalDate hasil = LocalDate.of(tahun, bulan, tanggal);
        switch (pertanyaan) {
            case 1:
                hasil = hasil.plusDays(jarak);
                break;
            case 2:
                hasil = hasil.plusMonths(jarak);
                break;
            case 3:
                hasil = hasil.plusYears(jarak);
                break;
        }

        System.out.println(jarak + (pertanyaan == 1 ? " hari" : pertanyaan == 2 ? " bulan" : " tahun") + " kemudian adalah " + hasil.format(DateTimeFormatter.ofPattern("dd MMMM yyyy")));

    }
}