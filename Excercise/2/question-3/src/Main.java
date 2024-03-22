import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat formatTanggal = new SimpleDateFormat("dd/MM/yyyy");


        //Nama
        String nama = null;
        while (nama == null){
            try {
                System.out.println("Siapa nama karyawan ini?");
                nama = scanner.nextLine();

            }catch (Exception exception){
                System.out.println("Format nama salah, coba lagi.");
            }
        }

        //Tanggal Karyawan Mulai Bekerja
        Date startWork = null;
        while (startWork == null){
            try {
                System.out.println("Tanggal berapa karyawan mulai bekerja? (format : dd/MM/yyyy)");
                String inputStart = scanner.nextLine();
                startWork = formatTanggal.parse(inputStart);
            }catch (Exception exception){
                System.out.println("Format Tanggal Salah, coba lagi.");
            }
        }

        //Tanggal Karyawan Di PHK
        Date endWork = null;
        while (endWork == null) {
            try {
                System.out.print("Tanggal berapa karyawan ini di PHK secara baik-baik? (dd/MM/yyyy): ");
                String input = scanner.nextLine();
                endWork = formatTanggal.parse(input);
            } catch (Exception exception) {
                System.out.println("Format tanggal salah, coba lagi.");
            }
        }

        //Gaji Karyawan
        int gajiKaryawan = 0;
        while (gajiKaryawan <= 0) {
            System.out.print("Berapa gaji karyawan pertama kali dia bekerja? ");
            String input = scanner.nextLine();
            try {
                gajiKaryawan = Integer.parseInt(input);
                if (gajiKaryawan <= 0) {
                    throw new Exception();
                }
            } catch (Exception exception) {
                System.out.println("Input harus berupa bilangan bulat dan lebih besar dari 0");
            }
        }

        //Level Karyawan
        System.out.println("Apa level karyawan ini?");
        System.out.println("1. Staff");
        System.out.println("2. Supervisor");
        System.out.println("3. Manager");
        String levelKaryawan = null;
        while (levelKaryawan == null) {
            System.out.print("Pilih level karyawan (1/2/3): ");
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    levelKaryawan = "Staff";
                    break;
                case "2":
                    levelKaryawan = "Supervisor";
                    break;
                case "3":
                    levelKaryawan = "Manager";
                    break;
                default:
                    System.out.println("Pilihan harus antara 1 sampai 3");
            }
        }



    }
}