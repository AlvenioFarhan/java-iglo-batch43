import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Input Value X :");
        int valueX = scanner.nextInt();

        System.out.println("Input Value Y :");
        int valueY = scanner.nextInt();

        System.out.println("Input Value Z :");
        double valueZ = scanner.nextDouble();

        double hasilPertama = ((valueX + valueY + valueZ) * (valueZ / 2) - valueZ);
        System.out.println(hasilPertama);

        //Value X Baru
        System.out.println("Input Value X Baru :");
        int valueXBaru = scanner.nextInt();

        double hasilKedua = ((valueXBaru + valueY + valueZ) * (valueZ / 2) - valueZ);
        System.out.println(hasilKedua);

        //Value Y Baru
        System.out.println("Input Value Y Baru :");
        int valueYBaru = scanner.nextInt();

        double hasilKetiga = ((valueXBaru + valueYBaru + valueZ) * (valueZ / 2) - valueZ);
        System.out.println(hasilKetiga);

        //Tambah Value Z
        System.out.println("Input Value Z Baru:");
        double valueZBaru = scanner.nextDouble();

        double hasilKeempat = ((valueXBaru + valueYBaru + valueZBaru) * (valueZBaru / 2) - valueZBaru);
        System.out.println(hasilKetiga);
    }
}