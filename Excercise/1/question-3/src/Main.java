import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Masukan nilai harga barang :");
        int hargaBarang = scanner.nextInt();

        System.out.println("Masukan persentase diskon :");
        int diskon = scanner.nextInt();

        Locale indonesia = new Locale("id", "ID");

        //Format Diskon
        NumberFormat formatDiskon = NumberFormat.getPercentInstance(indonesia);

        //Format Uang
        NumberFormat formatUang = NumberFormat.getCurrencyInstance(indonesia);

        //Perhitungan
        double totalDiskon = hargaBarang * (diskon /100.0);
        double totalAkhir = hargaBarang - totalDiskon;

        System.out.println("Harga barang adalah "+ formatUang.format(hargaBarang));
        System.out.println("Diskon sebesar " + formatDiskon.format(diskon/100.0));
        System.out.println("Total diskon sebesar " + formatUang.format(totalDiskon));
        System.out.println("Harga barang setelah diskon " + formatUang.format(totalAkhir));
    }
}