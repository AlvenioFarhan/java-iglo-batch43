import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Masukan tanggal ulang tahun anda :");
        int  tanggal = scanner.nextInt();

        System.out.println("Masukan bulan ulang tahun anda :");
        int bulan = scanner.nextInt();

        System.out.println("Masukan tahun ulang tahun anda :");
        int tahun = scanner.nextInt();

        String skip = scanner.nextLine();

        System.out.println("Masukan nama anda :");
        String nama = scanner.nextLine();

        String outputNama = String.format("Menghitung Umur %s ...", nama);
        System.out.println(outputNama);

        //Hitung Jarak
        LocalDate ulangTahun =LocalDate.of(tahun,bulan,tanggal);
        LocalDate saatIni = LocalDate.now();
        long usia = ChronoUnit.YEARS.between(ulangTahun, saatIni);

        String outputUmur = String.format("Umur Anda Adalah %d", usia);
        System.out.println(outputUmur);



    }
}