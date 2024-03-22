import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeePromotionSystem {
//    static ArrayList<String> employeeNumbers = new ArrayList<>();
//    static ArrayList<String> employeeNames = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Masukkan tanggal masuk kerja
        System.out.print("Masukkan tanggal masuk kerja (YYYY-MM-DD): ");
        String tanggalMasukKerjaString = scanner.nextLine();
        LocalDate tanggalMasukKerja = LocalDate.parse(tanggalMasukKerjaString);

        // Hitung lama bekerja
        LocalDate tanggalSaatIni = LocalDate.now();
        Period lamaBekerja = Period.between(tanggalMasukKerja, tanggalSaatIni);

        // Tampilkan hasil
        int tahun = lamaBekerja.getYears();
        int bulan = lamaBekerja.getMonths();
        int hari = lamaBekerja.getDays();

        System.out.println("Anda telah bekerja selama: " + tahun + " tahun, " + bulan + " bulan, " + hari + " hari.");

        scanner.close();










//        Scanner scanner = new Scanner(System.in);

//        while (true) {
//            System.out.println("Masukkan nomor karyawan:");
//            String empNumber = scanner.next();
//            System.out.println("Nama karyawan dari nomor ini?");
//            String empName = scanner.next();
//
//            employeeNumbers.add(empNumber);
//            employeeNames.add(empName);
//
//            System.out.println("Apakah anda masih ingin menginput karyawan lain? (Y/N)");
//            String continueInput = scanner.next();
//
//            if (!continueInput.equalsIgnoreCase("Y")) {
//                break;
//            }
//        }
//
//        while (true) {
//            System.out.println("Pilih satu opsi:");
//            System.out.println("1. Lihat seluruh karyawan yang di register");
//            System.out.println("2. Pilih karyawan yang akan di promosi");
//            System.out.println("3. Lihat seluruh karyawan yang akan di promosi");
//            System.out.println("4. Exit system");
//
//            int option;
//            try {
//                option = scanner.nextInt();
//            } catch (InputMismatchException e) {
//                System.out.println("Invalid input. Please enter a number between 1 and 4.");
//                scanner.nextLine(); // Clear the input buffer
//                continue;
//            }
//
//            switch (option) {
//                case 1:
//                    displayRegisteredEmployees();
//                    break;
//                case 2:
//                    promoteEmployee(scanner);
//                    break;
//                case 3:
//                    displayPromotedEmployees();
//                    break;
//                case 4:
//                    System.out.println("Exiting system. Goodbye!");
//                    System.exit(0);
//                    break;
//                default:
//                    System.out.println("Invalid option. Please enter a number between 1 and 4.");
//                    break;
//            }
//        }
    }

//    static void displayRegisteredEmployees() {
//        for (int i = 0; i < employeeNumbers.size(); i++) {
//            System.out.println(employeeNumbers.get(i) + ", " + employeeNames.get(i));
//        }
//    }
//
//    static void promoteEmployee(Scanner scanner) {
//        System.out.println("Ketik nomor karyawan yang akan di promosi:");
//        String empNumber = scanner.next();
//
//        if (!employeeNumbers.contains(empNumber)) {
//            System.out.println("Nomor karyawan yang dimasukkan tidak terdaftar.");
//            return;
//        }
//
//        int index = employeeNumbers.indexOf(empNumber);
//        String empName = employeeNames.get(index);
//        employeeNumbers.remove(index);
//        employeeNames.remove(index);
//
//        System.out.println("Karyawan dengan nomor " + empNumber + " (" + empName + ") telah dipromosikan.");
//    }
//
//    static void displayPromotedEmployees() {
//        for (String empName : employeeNames) {
//            System.out.println(empName);
//        }
//    }
}
