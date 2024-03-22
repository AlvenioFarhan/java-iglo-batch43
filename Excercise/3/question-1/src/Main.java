import java.util.Scanner;

public class Main {

    //Pilihan User
    public static int pilihanPertanhyaan(Scanner scanner, int min, int max) {
        int pilihan;
        do {
            try {
                System.out.print("Pilihan Anda: ");
                pilihan = scanner.nextInt();
                if (pilihan < min || pilihan > max) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Masukkan angka antara 1 - 3");
                scanner.nextLine();
                pilihan = -1;
            }
        } while (pilihan < min || pilihan > max);
        return pilihan;
    }


    //cashback
    public static double rumusCashback(double totalBelanja, double minimalBelanja, double persentase, double maksimalCashback) {
        double cashback = totalBelanja * persentase;
        if (totalBelanja >= minimalBelanja) {
            cashback = Math.min(cashback, maksimalCashback);
        } else {
            cashback = 0;
        }
        return cashback;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

            System.out.println("Pilih hari raya di bawah ini:");
            System.out.println("1. Idul Fitri");
            System.out.println("2. Tahun Baru");
            System.out.println("3. Hari Natal");
            int pilihan = pilihanPertanhyaan(scanner, 1, 3);


        double minimalPembelian;
        double persentaseCashback;
        double maksimalPembelian;

        switch (pilihan) {
            case 1:
                minimalPembelian = 400000;
                persentaseCashback = 0.1;
                maksimalPembelian = 150000;
                break;
            case 2:
                minimalPembelian = 200000;
                persentaseCashback = 0.05;
                maksimalPembelian = 80000;
                break;
            case 3:
                minimalPembelian = 250000;
                persentaseCashback = 0.06;
                maksimalPembelian = 100000;
                break;
            default:
                throw new IllegalStateException("Invalid choice");
        }

        System.out.println("Berapa total belanja anda?");
        double totalPurchase = scanner.nextDouble();

        double cashback = rumusCashback(totalPurchase, minimalPembelian, persentaseCashback, maksimalPembelian);
        System.out.println("Total Cashback yang anda terima adalah: Rp" + cashback);

    }
}