import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input value X dalam bilangan bulat: ");
        Integer valueX = Integer.parseInt(scanner.nextLine());

        System.out.println("Input value Y dalam bilangan bulat: ");
        Integer valueY = Integer.parseInt(scanner.nextLine());

        System.out.println("Input value Z dalam bilangan desimal: ");
        Double valueZ = Double.parseDouble(scanner.nextLine());

        Double hasil = ((valueX + valueY + valueZ)*(valueZ/2) - valueZ);

        System.out.printf("Hasilnya adalah: %s\n", hasil);

        System.out.println("Ubah value X menjadi: ");
        valueX = Integer.parseInt(scanner.nextLine());
        hasil = ((valueX + valueY + valueZ)*(valueZ/2) - valueZ);
        System.out.printf("Hasilnya sekarang adalah: %s\n", hasil);

        System.out.println("Ubah value Y menjadi: ");
        valueY = Integer.parseInt(scanner.nextLine());
        hasil = ((valueX + valueY + valueZ)*(valueZ/2) - valueZ);
        System.out.printf("Hasilnya sekarang adalah: %s\n", hasil);

        System.out.println("Ubah value Z menjadi: ");
        valueZ = Double.parseDouble(scanner.nextLine());
        hasil = ((valueX + valueY + valueZ)*(valueZ/2) - valueZ);
        System.out.printf("Hasilnya sekarang adalah: %s\n", hasil);
    }
}