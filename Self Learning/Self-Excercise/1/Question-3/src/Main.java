import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Masukkan nilai harga barang:");
        Integer hargaBarang = Integer.parseInt(scanner.nextLine());
        Double integerToDouble = (double) hargaBarang;

        System.out.println("Masukkan presentase diskon:");
        Integer diskon = Integer.parseInt(scanner.nextLine());

        Double rumusDiskon = (integerToDouble * diskon) / 100.0;
        Double hargaSetelahDiskon = integerToDouble - rumusDiskon;
        NumberFormat formatUangIdn = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));


        System.out.printf("Harga barang adalah %s\n", formatUangIdn.format(integerToDouble));
        System.out.println("Diskon sebesar " + diskon + "%");
        System.out.printf("Total diskon sebesar %s\n", formatUangIdn.format(rumusDiskon));
        System.out.printf("Harga barang setelah diskon %s\n",formatUangIdn.format(hargaSetelahDiskon));


    }
}