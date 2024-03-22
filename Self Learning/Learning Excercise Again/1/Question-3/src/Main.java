import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Masukan nilai harga barang: ");
        Integer hargaBarang = Integer.parseInt(scanner.nextLine());

        System.out.println("Masukan persentase diskon: ");
        Integer diskon = Integer.parseInt(scanner.nextLine());

        Locale locale = new Locale("id", "ID");

        Integer persentaseDiskon = diskon / 100;
        Integer rumusDiskon = hargaBarang * persentaseDiskon;
        String formatterRumusDiskon = NumberFormat.getCurrencyInstance(locale).format(rumusDiskon);

        Integer totalSetelahDiskon = hargaBarang - rumusDiskon;
        String formatterTotalSetelahDiskon = NumberFormat.getCurrencyInstance(locale).format(totalSetelahDiskon);

        String formatterHargaBarang = NumberFormat.getCurrencyInstance(locale).format(hargaBarang);

        System.out.printf("Harga barang adalah %s\n", formatterHargaBarang);
        System.out.println("Diskon sebesar " + diskon + "%");
        System.out.printf("Total diskon sebesar %s\n", formatterRumusDiskon);
        System.out.printf("Harga barang setelah diskon %s\n", formatterTotalSetelahDiskon);
    }
}