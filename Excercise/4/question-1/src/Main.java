import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static Integer TOTAL_ROWS = 5;
    public static Integer SEATS_PER_ROW = 6;
    public static boolean[][] banyakKursi = new boolean[TOTAL_ROWS][SEATS_PER_ROW];
    public static String[][] bookingLog = new String[TOTAL_ROWS][SEATS_PER_ROW];

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true){
        //Menu
        System.out.println("Summary: Terdapat " + jumlahKursiKosong() + " kursi yang belum di book dan "+ jumlahKursiSudahBooking() + " kursi yang sudah di book");
        System.out.println("Menu mana yang akan kalian ambil?");
        System.out.println("1. Book kursi");
        System.out.println("2. Lihat semua status kursi");
        System.out.println("3. Lihat history log booked");
        System.out.println("Pilihan :");

        int pilihanMenu = scanner.nextInt();
        scanner.nextLine();

            switch (pilihanMenu) {
                case 1:
                    bookKursi(scanner);
                    break;
                case 2:
                    statusKursi();
                    break;
                case 3:
                    historiBookingLog();
                    break;
                default:
                    System.out.println("Pilihan tidak valid, silakan pilih kembali.");
            }

        }
    }

    //Pilihan 1, booking kursi
    public static void bookKursi(Scanner scanner) {
        LocalDate hariIni = LocalDate.now();
        int row = 0, kursi = 0;
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.print("Pilih row (1-5): ");
                row = scanner.nextInt() - 1;
                System.out.print("Pilih nomor kursi (1-6): ");
                kursi = scanner.nextInt() - 1;

                if (row >= 0 && row < TOTAL_ROWS && kursi >= 0 && kursi < SEATS_PER_ROW) {
                    isValid = true;
                } else {
                    System.out.println("Input tidak valid, silakan ulangi proses.");
                }
            } catch (Exception exception) {
                System.out.println("Input tidak valid, silakan masukkan bilangan bulat.");
                scanner.nextLine();
            }
        }

        if (banyakKursi[row][kursi]) {
            System.out.println("Maaf kursi sudah di booked oleh Seseorang.");
            bookingLog[row][kursi] = "Pada tanggal " + hariIni + ": Row " + (row + 1) + ", Kursi " + (kursi + 1) + " gagal di book oleh seseorang";
        } else {
            System.out.print("Masukkan nama anda: ");
            String name = scanner.next();
            banyakKursi[row][kursi] = true;
            bookingLog[row][kursi] = "Pada tanggal " + hariIni + ": Row " + (row + 1) + ", Kursi " + (kursi + 1) + " berhasil di book oleh " + name;
            System.out.println("Booking berhasil!");
        }
    }


    //Pilihan 2, cek status kursi
    public static void statusKursi() {
        for (int row = 0; row < TOTAL_ROWS; row++) {
            for (int kursi = 0; kursi < SEATS_PER_ROW; kursi++) {
                if (banyakKursi[row][kursi]) {
                    System.out.println("Row " + (row + 1) + ", Kursi " + (kursi + 1) + ": Booked");
                } else {
                    System.out.println("Row " + (row + 1) + ", Kursi " + (kursi + 1) + ": Vacant");
                }
            }
        }
    }


    //Pilian 3, cek histori booking
    public static void historiBookingLog() {
        for (int row = 0; row < TOTAL_ROWS; row++) {
            for (int kursi = 0; kursi < SEATS_PER_ROW; kursi++) {
                if (bookingLog[row][kursi] != null) {
                    System.out.println(bookingLog[row][kursi]);
                }
            }
        }
    }

    public static int jumlahKursiKosong() {
        int count = 0;
        for (int row = 0; row < TOTAL_ROWS; row++) {
            for (int kursi = 0; kursi < SEATS_PER_ROW; kursi++) {
                if (!banyakKursi[row][kursi]) {
                    count++;
                }
            }
        }
        return count;
    }

    static int jumlahKursiSudahBooking() {
        return TOTAL_ROWS * SEATS_PER_ROW - jumlahKursiKosong();
    }

}

