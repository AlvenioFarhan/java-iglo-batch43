import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pilih option dari nomor 1 - 3 :");
        System.out.println("1. Formula: (X * Y) + (Z * Y)");
        System.out.println("2. Formula: (X + Y + Z) / X");
        System.out.println("3. Formula: (X - Z) * Y");

        int option = 0;

        boolean pilihan = true;

        while(pilihan) {
            System.out.print("Masukkan pilihan anda (1/2/3): ");
            String input = scanner.nextLine().trim();
            try {
                option = Integer.parseInt(input);
                if (option < 1 || option > 3) {
                    throw new Exception();
                }
                break;
            } catch (Exception exception) {
                System.out.println("Maaf, anda harus input antara 1 atau 2 atau 3");
            }
        }


        System.out.println("Input value X dalam bilangan bulat : ");
        int valueX = 0;
        while (pilihan){
            try {
                valueX = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception exception){
                System.out.println("Input salah, coba lagi");
            }
        }

        System.out.println("Input value Y dalam bilangan bulat : ");
        int valueY = 0;
        while (pilihan){
            try {
                valueY = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception exception){
                System.out.println("Input salah, coba lagi");
            }
        }

        System.out.println("Input value Z dalam bilangan desimal : ");
        double valueZ = 0.0;
        while (pilihan){
            try {
                valueZ = Double.parseDouble(scanner.nextLine());
                break;
            } catch (Exception exception){
                System.out.println("Input salah, coba lagi");
            }
        }

        double hasil = 0;

        switch (option) {
            case 1:
                hasil = (valueX * valueY) + (valueZ * valueY);
                break;
            case 2:
                hasil = (valueX + valueY + valueZ) / valueX;
                break;
            case 3:
                hasil = (valueX - valueZ) * valueY;
                break;
        }
        System.out.println("Hasilnya adalah: " + hasil);


    }
}