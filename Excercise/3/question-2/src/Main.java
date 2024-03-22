import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    //nama Karyawan
    public static String inputNamaKaryawan(Scanner scanner) {
        String input = "";
        boolean validInput = false;
        do {
            try {
                System.out.println("Siapa Nama Karyawan?");
                input = scanner.nextLine();
                if (!input.matches("[a-zA-Z ]+")) {
                    throw new IllegalArgumentException("Input tidak valid. Masukkan hanya huruf.");
                }
                validInput = true;
            } catch (Exception exception) {
                System.out.println("Input tidak valid. Masukkan hanya huruf.");
            }
        } while (!validInput);
        return input;
    }

    //input gaji
    public static int inputGaji(Scanner scanner, String namaKaryawan){
        int input = 0;
        boolean validInput = false;
        do {
            try {
                System.out.printf("Berapa Gaji Bulanan %s? ", namaKaryawan);
                input = scanner.nextInt();
                validInput = true;
            } catch (Exception exception) {
                System.out.println("Input harus bilangan bulat");
                scanner.next();
            }
        } while (!validInput);
        return input;
    }

    //hitung total gaji setahun
    public static double hitungTotalGajiSetahun(int gajiBulanan) {
        double gajiDalamTahun = gajiBulanan * 13;
        double bonusTahunan = gajiBulanan * 1.10;
        double totalGajiSetahun = gajiDalamTahun + bonusTahunan;
        return totalGajiSetahun;
    }

    //Memiliki Pasangan atau tidak
    public static boolean isPasangan(Scanner scanner) {
        String input;
        while (true) {
            input = scanner.nextLine().toUpperCase();
            if (input.equals("Y") || input.equals("N")) {
                break;
            } else {
                System.out.println("Masukkan harus 'Y' atau 'N'");
            }
        }
        return input.equals("Y");
    }

   public static double perhitunganPajak(double taxableIncome) {
        double pajak = 0;
        if (taxableIncome > 500000000) {
            pajak = pajak + 0.3 * (taxableIncome - 500000000);
            taxableIncome = 500000000;
        }
        if (taxableIncome > 250000000) {
            pajak += 0.25 * (taxableIncome - 250000000);
            taxableIncome = 250000000;
        }
        if (taxableIncome > 50000000) {
            pajak += 0.15 * (taxableIncome - 50000000);
            taxableIncome = 50000000;
        }
        pajak += 0.05 * taxableIncome;
        return pajak;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Locale indonesia = new Locale("id","ID");
        NumberFormat formater = NumberFormat.getCurrencyInstance(indonesia);

        //input nama dengan function
        String namaKaryawan = inputNamaKaryawan(scanner);

        //input gaji
        int gajiBulanan = inputGaji(scanner, namaKaryawan);

        //Dengan function
        double totalGajiSetahun = hitungTotalGajiSetahun(gajiBulanan);

        System.out.printf("Total Penghasilan %s Tahun Ini : %s\n", namaKaryawan, formater.format(totalGajiSetahun));

        // Input status memiliki pasangan
        System.out.printf("Apakah %s memiliki pasangan? ", namaKaryawan);
        boolean memilikiPasangan = isPasangan(scanner);

        System.out.printf("Berapa jumlah tanggungan anak %s ?", namaKaryawan);
        int memilikiAnak = scanner.nextInt();

        //perhitungan
        int bebasPajak = 54000000;

        if (memilikiPasangan) {
            bebasPajak += 4500000;
        }
        bebasPajak += memilikiAnak * 4500000;

        // Hitung taxable income
        double taxableIncome = totalGajiSetahun - bebasPajak;

        System.out.printf("Jumlah taxable income : %s\n", formater.format(taxableIncome));

        double pajak = perhitunganPajak(taxableIncome);
        System.out.printf("Jumlah pajak yang harus dibayar %s : %s", namaKaryawan, formater.format(pajak));
        
    }
}