import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static String[] mainMenu = {
            "Menu Prospect",
            "Menu Customer",
            "Exit Application"
    };
    public static String[] menuProspect = {
            "Add Prospect",
            "Prospect To Customer",
            "Main Menu",
            "Exit Application"
    };
    public static String[] menuCustomer = {
            "Buy Product",
            "Detail Policy",
            "Main Menu",
            "Exit Application"

    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Asuransi.initializeDataProduct();
        mainMenu(scanner);
    }

    public static void mainMenu(Scanner scanner) {
        printMenus(mainMenu);
        System.out.println("Pilihan(1/2/3): ");

        Integer number = validateMenuInput(scanner, mainMenu.length);
        switch (number) {
            case 1:
                menuProspect(scanner);
                break;
            case 2:
                menuCustomer(scanner);
                break;
            case 3:
                executeExit(scanner);
                break;
            default:
                System.out.println("Input menu is not valid");
                break;
        }
    }

    public static void menuProspect(Scanner scanner) {
        Asuransi.printAllDataCustomerAndProspect();

        printMenus(menuProspect);
        System.out.println("Pilihan(1/2/3/4): ");

        Integer number = validateMenuInput(scanner, menuProspect.length);
        switch (number) {
            case 1:
                addProspectMenu(scanner);
                break;
            case 2:
                prospectToCustomerMenu(scanner);
                break;
            case 3:
                mainMenu(scanner);
                break;
            case 4:
                executeExit(scanner);
                break;
            default:
                System.out.println("Input menu is not valid");
                break;
        }
    }

    public static void addProspectMenu(Scanner scanner) {
        System.out.printf("Masukan data prospect satu-persatu:\n\n");
        System.out.println("Nama Depan :");
        String namaDepan = scanner.nextLine();
        System.out.println("Nama Belakang :");
        String namaBelakang = scanner.nextLine();

        LocalDate tanggalLahir = validateTanggalLahir(scanner);

        System.out.println("Tempat Lahir:");
        String tempatLahir = scanner.nextLine();

        Gender gender = validateGender(scanner);

        System.out.println("Pekerjaan:");
        String pekerjaan = scanner.nextLine();

        Prospect prospect = new Prospect(namaDepan, namaBelakang, tanggalLahir, tempatLahir, gender, pekerjaan, false);

//        prospects.add(prospect);
        Asuransi.addDataProspect(prospect);

        System.out.println("... Menambahkan Prospect Baru");
        mainMenu(scanner);
    }

    public static Gender validateGender(Scanner scanner) {
        Gender gender = null;
        boolean inputValid = false;
        while (!inputValid) {
            System.out.println("Jenis Kelamin (P/L):");
            System.out.println("P: Perempuan, L: Laki-laki");
            String inputJenisKelamin = scanner.nextLine();

            try {
                gender = Gender.valueOf(inputJenisKelamin);
                if (inputJenisKelamin.equals("L")) {
                    gender = Gender.L;
                } else {
                    gender = Gender.P;
                }
                inputValid = true;
            } catch (Exception exception) {
                System.out.println("Jenis kelamin yang dimasukkan tidak valid. Masukkan P/L");
            }
        }
        return gender;
    }

    //validasi tanggal lahir
    public static LocalDate validateTanggalLahir(Scanner scanner) {
        LocalDate tanggalLahir = null;
        boolean inputValid = false;
        while (!inputValid) {
            System.out.println("Tanggal Lahir (dd/MM/yyyy):");
            String inputTanggalLahir = scanner.nextLine();
            try {
                tanggalLahir = LocalDate.parse(inputTanggalLahir, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                inputValid = true;
            } catch (Exception exception) {
                System.out.println("Format tanggal salah. Masukkan tanggal dengan format dd/MM/yyyy.");
            }
        }
        return tanggalLahir;
    }


    public static void prospectToCustomerMenu(Scanner scanner) {

        Asuransi.printAllDataCustomerAndProspect();

        System.out.println("Ketik nomor prospect yang ingin dijadikan nasabah:");
        Integer addNasabah;
        Prospect prospect = null;
        try {
            addNasabah = Integer.parseInt(scanner.nextLine());
            prospect = Asuransi.getProspectData(addNasabah);
            if (prospect == null) {
                System.out.println("Nomor Prospect tidak ditemukan.");
                prospectToCustomerMenu(scanner);
            }
        } catch (Exception exception) {
            System.out.println("Wajib bilangan Bulat");
            prospectToCustomerMenu(scanner);
        }


        System.out.println("Nomor KTP:");
        String addNomorKTP = scanner.nextLine();
        System.out.println("Status KK:");
        String addStatusKK = scanner.nextLine();

        String payment = validasiPayment(scanner);
        MetodePembayaran paymentEnum = MetodePembayaran.getMetodePembayaranByString(payment);

        Nasabah nasabah = new Nasabah(prospect, addNomorKTP, addStatusKK, paymentEnum);
        Asuransi.addDataNasabah(nasabah,prospect);


        menuProspect(scanner);
    }

    //Validasi Payment
    public static String validasiPayment(Scanner scanner) {
        String payment = null;
        boolean inputValid = false;
        System.out.println("Payment Method(CC/AC/VP):");
        System.out.println("(CC adalah Credit Card, AC adalah Auto Collection, VP adalah Voucher Point)");
        payment = scanner.nextLine();
        LinkedList<String> metodePembayaran = new LinkedList<>(List.of("CC", "AC", "VP"));
        if (!metodePembayaran.contains(payment)) {
            System.out.println("Payment harus CC/AC/VP");
            prospectToCustomerMenu(scanner);
        }
        return payment;
    }


    public static void menuCustomer(Scanner scanner) {
        //TODO belum kelar
        //TODO Detail list customer
        Asuransi.printAllDataNasabah();

        printMenus(menuCustomer);
        System.out.println("Pilihan(1/2/3/4): ");

        Integer number = validateMenuInput(scanner, menuCustomer.length);
        switch (number) {
            case 1:
//                TODO: ADD BUY PRODUCT
                buyProductMenu(scanner);
                break;
            case 2:
//                TODO: ADD DETAIL POLICY
                detailPolicyMenu(scanner);
                break;
            case 3:
                mainMenu(scanner);
                break;
            case 4:
                executeExit(scanner);
                break;
            default:
                System.out.println("Input menu is not valid");
                break;
        }
    }

    public static void buyProductMenu(Scanner scanner) {
        //TODO belum kelar
        //TODO Detail list customer
        Asuransi.printAllDataNasabah();

        System.out.println("Pilih Nomor Customer:");
        String nomorCustomer = scanner.nextLine();
        Nasabah nasabah = Asuransi.findCustomerByNomorAndPrint(nomorCustomer);
        if (nasabah != null) {
            nasabah.printSummary();
        }else {
            System.out.println("Nasabah tidak ditemukan");
            buyProductMenu(scanner);
        }
        System.out.println("Pilih Nama Product:");
        String namaProduct = scanner.nextLine();
        Product product = Asuransi.findProductByName(namaProduct);
        if (product == null) {
            System.out.println("Product tidak ketemu");
            buyProductMenu(scanner);
        }
        Polis polis = new Polis(nasabah, product, LocalDate.now(), null, null, null, null, null, null, null, null);

        if (product.getJenisProduk().equals(JenisProduk.KR)) {
            inputDataKendaraan(scanner, polis);
        }else {
            inputDataTertanggung(scanner, polis);
        }
        Boolean hasil = Asuransi.addPolicyCustomer(nasabah, polis);
        if (!hasil) {
            System.out.println("iuran produk tidak ditemukan");
            buyProductMenu(scanner);
        }
        menuCustomer(scanner);
    }

    public static Polis inputDataTertanggung(Scanner scanner, Polis polis) {
        System.out.println("Pilih Nomor Customer Tertanggung:");
        String nomorCustomerTertanggung = scanner.nextLine();
        Nasabah nasabah = Asuransi.findCustomerByNomorAndPrint(nomorCustomerTertanggung);
        if (nasabah == null) {
            System.out.println("nasabah tertatanggung tidak ditemukan");
            buyProductMenu(scanner);
        }
        polis.setTertanggung(nasabah);
        return polis;
    }

    public static Polis inputDataKendaraan(Scanner scanner, Polis polis) {
        System.out.println("Input Data Kendaraan:");
        System.out.println("Jenis kendaraan:");
        String jenisKendaraan = scanner.nextLine();
        System.out.println("Nomor Polisi:");
        String nomorPolisi = scanner.nextLine();
        System.out.println("nomor STNK:");
        String nomorSTNK = scanner.nextLine();
        System.out.println("Merek kendaraan:");
        String merkKendaraan = scanner.nextLine();
        System.out.println("Model kendaraan:");
        String modelKendaraan = scanner.nextLine();
        System.out.println("Warna kendaraan:");
        String warnaKendaraan = scanner.nextLine();

        polis.setJenisKendaraan(jenisKendaraan);
        polis.setNomorPolisi(nomorPolisi);
        polis.setNomorSTNK(nomorSTNK);
        polis.setMerekKendaraan(merkKendaraan);
        polis.setModelKendaraan(modelKendaraan);
        polis.setWarnaKendaraan(warnaKendaraan);
        return polis;
    }

    public static void detailPolicyMenu(Scanner scanner) {
        //TODO list customer

        System.out.println("Pilih Nomor Customer:");
        String nomorCustomer = scanner.nextLine();

        Nasabah nasabah = Asuransi.findCustomerByNomorAndPrint(nomorCustomer);
        if (nasabah == null) {
            System.out.println("nasabah tidak ditemukan");
            detailPolicyMenu(scanner);
        }
        nasabah.printSummaryWithPolicy();
        //TODO customer information, policy info, Payment

        //TODO SKenario untuk kendaraan
        menuCustomer(scanner);

    }

    public static void printMenus(String[] menus) {
        System.out.println("Pilih lah salah satu menu di bawah ini:");
        for (int index = 0; index < menus.length; index++) {
            System.out.printf("\t%s. %s\n", index + 1, menus[index]);
        }
    }

    public static Integer validateMenuInput(Scanner scanner, Integer maxInput) {
        String input = scanner.nextLine();
        try {
            Integer number = Integer.parseInt(input);
            if (number > 0 && number <= maxInput) {
                return number;
            } else {
                System.out.printf("Input harus antara 1 - %s\n", maxInput);
                return validateMenuInput(scanner, maxInput);
            }
        } catch (Exception exception) {
            System.out.println("Input harus berupa angka bulat");
            return validateMenuInput(scanner, maxInput);
        }
    }

    public static void executeExit(Scanner scanner) {
        scanner.close();
        System.out.println("Good Bye!");
        System.exit(0);
    }
}