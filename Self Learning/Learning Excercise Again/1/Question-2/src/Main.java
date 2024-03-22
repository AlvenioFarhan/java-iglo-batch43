import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Masukan tanggal ulang tahun anda: ");
        Integer tanggal = Integer.parseInt(scanner.nextLine());

        System.out.println("Masukan bulan ulang tahun anda: ");
        Integer bulan = Integer.parseInt(scanner.nextLine());

        System.out.println("Masukkan tahun ulang tahun anda: ");
        Integer tahun = Integer.parseInt(scanner.nextLine());

        System.out.println("Masukkan Nama Anda: ");
        String nama = scanner.nextLine();

        LocalDate birthDate = LocalDate.of(tahun,bulan,tanggal);

        Long umur = ChronoUnit.YEARS.between(birthDate, LocalDate.now());

        System.out.printf("Menghitung umur %s...\n", nama);
        System.out.printf("Umur anda adalah %s tahun", umur);
    }
}