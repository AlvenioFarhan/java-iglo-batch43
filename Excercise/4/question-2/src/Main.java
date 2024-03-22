import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static HashMap<Integer, String> karyawan = new HashMap<>();
    public static ArrayList<String> karyawanYangDipromosikan = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //input karyawan
        while (true){
            //Convert Interger ke nextLine
            System.out.println("Masukkan nomor karyawan:");
            Integer nomorKaryawan = Integer.parseInt(scanner.nextLine());

            System.out.println("Nama karyawan dari nomor ini?");
            String namaKaryawan = scanner.next();

            //put nomor dan nama karyawan
            karyawan.put(nomorKaryawan, namaKaryawan);

            //inputan YES or NO
            System.out.println("Apakah anda masih ingin menginput karyawan lain? (Y/N)");
            String inputYesOrNo;
            while (true) {
                inputYesOrNo = scanner.next();
                if (inputYesOrNo.equalsIgnoreCase("Y") || inputYesOrNo.equalsIgnoreCase("N")) {
                    break;
                } else {
                    System.out.println("Input yang dimasukkan tidak valid. Mohon masukkan Y atau N.");
                }
            }

            if (inputYesOrNo.equalsIgnoreCase("N")) {
                break;
            }
        }

        //Menu
        while (true){
            System.out.println("Pilih satu opsi:");
            System.out.println("1. Lihat seluruh karyawan yang di register");
            System.out.println("2. Pilih karyawan yang akan di promosi");
            System.out.println("3. Lihat seluruh karyawan yang akan di promosi");
            System.out.println("4. Exit system");
            System.out.println("Pilihan (1/2/3/4):");

            int pilihanMenu = 0;
            try {
                pilihanMenu = scanner.nextInt();
            }catch (Exception exception){
                System.out.println("Pilihan Salah, silahkan pilih angka 1 - 4");
            }

            switch (pilihanMenu){
                case 1:
                    listDataKaryawan();
                    break;
                case 2:
                    promosiKaryawan();
                    break;
                case 3:
                    listKaryawanYangDiPromosi();
                    break;
                case 4:
                    System.out.println("Good Bye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan Salah, silahkan pilih angka 1 - 4");
                    break;
            }
        }
    }

    //Data Karyawan
    public static void listDataKaryawan() {
        for (Integer noKaryawan : karyawan.keySet()) {
            System.out.println(noKaryawan + ", " + karyawan.get(noKaryawan));
        }
    }

    //karyawan yang akan di promosikan
    public static void promosiKaryawan(){
        Scanner scanner = new Scanner(System.in);

        //Convert Interger ke nextLine
        System.out.println("Ketik nomor karyawan yang akan di promosi:");
        Integer nomorKaryawan = Integer.parseInt(scanner.nextLine());

        if (!karyawan.containsKey(nomorKaryawan)){
            System.out.println("Nomor Karyawan tidak terdaftar, silahkan coba lagi!");
            return;
        }

        //menghapus karyawan yang ada di list
        String namaKaryawan = karyawan.get(nomorKaryawan);
        karyawan.remove(nomorKaryawan);

        //memindahkan atau menambahkan karyawan ke list karyawan promosi
        karyawanYangDipromosikan.add(namaKaryawan);

        System.out.println("Karyawan dengan nomor " + nomorKaryawan + " (" + namaKaryawan + ") telah dipromosikan.");
    }

    //Menampilkan Karyawan Promosi
    public static void listKaryawanYangDiPromosi(){
        for ( String namaKaryawan : karyawanYangDipromosikan){
            System.out.println(namaKaryawan);
        }
    }

}