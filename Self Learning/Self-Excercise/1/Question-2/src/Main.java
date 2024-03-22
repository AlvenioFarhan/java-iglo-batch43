import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Masukkan tanggal ulang tahun anda:");
        Integer inputTanggal = Integer.parseInt(scanner.nextLine());

        System.out.println("Masukkan bulan ulang tahun anda:");
        Integer inputBulan = Integer.parseInt(scanner.nextLine());

        System.out.println("Masukkan tahun ulang tahun anda:");
        Integer inputTahun = Integer.parseInt(scanner.nextLine());

        System.out.println("Masukkan nama anda:");
        String inputNama = String.valueOf(scanner.nextLine());

        LocalDate birthDay = LocalDate.of(inputTahun,inputBulan,inputTanggal);
        Long usiaSekarang = ChronoUnit.YEARS.between(birthDay, LocalDate.now());
        System.out.printf("Menghitung umur %s\n", inputNama);
        System.out.printf("Umur anda adalah %s\n",usiaSekarang);
    }
}