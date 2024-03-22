import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //HASHMAP PASIEN
        HashMap<String, Pasien> listPasien = new HashMap<>();

        //HASHMAP PELAYANAN
        HashMap<String, String> listPelayanan = new HashMap<>();
        listPelayanan.put("CT", "CT Scan");
        listPelayanan.put("MRI", "Magnetic Resonance Imaging");
        listPelayanan.put("BP", "Blood Pressure");
        listPelayanan.put("LAB", "Laboratory Test");
        listPelayanan.put("ECG", "Electorcardiogram");

        //LINKEDLIST HISTORY BOOKING MEDICAL CHECKUP
        LinkedList<LogMedicalCheckup> historyBooking = new LinkedList<>();

        //LINKEDLIST HISTORY BOOKING MEDICATION
        LinkedList<LogMedication> historyMedication = new LinkedList<>();

        //LINKEDLIST HISTORY BOOKING THERAPY
        LinkedList<LogTherapy> historyTherapy = new LinkedList<>();




        Scanner scannerVariable = new Scanner(System.in);

        int pilihanMenu;

        while(true) {

            mainMenu();

            pilihanMenu = validateInteger(scannerVariable, 1,6);
            Scanner scanner = new Scanner(System.in);
            switch (pilihanMenu) {

                case 1:
                    for(Pasien value : listPasien.values()){
                        if (value instanceof Elder) {
                            Elder elder = new Elder();
                            System.out.printf("ID: %s, Nama: %s, Birth Date: %s, Usia: %s \n", value.getIdPasien(), value.getNamaPasien(), value.getTanggalLahirPasien(), value.getUsiaPasien());
                            System.out.println("\nPenyakit yang Diderita:");
                            LinkedList<String> penyakitList = elder.getNamaPenyakit();
                            LinkedList<String> keteranganList = elder.getKeterangan();
                        } else { System.out.printf("ID: %s, Nama: %s, Birth Date: %s, Usia: %s \n", value.getIdPasien(), value.getNamaPasien(), value.getTanggalLahirPasien(), value.getUsiaPasien());
                            System.out.println("=======================================================");

                        }
                    }
                    System.out.print("Input id pasien: (Id pasien harus unik, menginput id yang sama akan me-replace pasien yang sebelumnya!) \n");
                    String idPasien = scanner.nextLine();

                    System.out.print("Input nama pasien: \n");
                    String namaPasien = scanner.nextLine();

                    System.out.print("Input tanggal lahir pasien (dd/MM/yyyy): \n");
                    String tanggalLahirInput = scanner.nextLine();

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate tanggalLahir = LocalDate.parse(tanggalLahirInput, formatter);

                    Elder pasien;

                    if (ChronoUnit.YEARS.between(tanggalLahir, LocalDate.now()) >= 65){

                        pasien = new Elder(idPasien, namaPasien, tanggalLahir);

                        System.out.print("Input nama penyakit: \n");
                        String namaPenyakit = scanner.nextLine();

                        System.out.print("Input keterangan: \n");
                        String keterangan = scanner.nextLine();

                        while (true) {
                            System.out.println("Apakah ada penyakit kronis? (Y/N)");
                            String jawaban = scanner.nextLine();
                            if (jawaban.equalsIgnoreCase("Y")) {
                                System.out.println("Masukkan Nama Penyakit:");
                                namaPenyakit = scanner.nextLine();
                                System.out.println("Masukkan Keterangan:");
                                keterangan = scanner.nextLine();
                                pasien.tambahPenyakit(namaPenyakit, keterangan);
                            } else if (jawaban.equalsIgnoreCase("N")) {

                                break;
                            } else {
                                System.out.println("Masukkan tidak valid. Silakan masukkan Y atau N.");
                            }
                        }

                    } else {
                        pasien = new Elder(idPasien, namaPasien, tanggalLahir);
                    }

                    Pasien addPasien = new Pasien(idPasien, namaPasien, tanggalLahir);

                    addPasien.setUsiaPasien(addPasien.dapatkanUsiaPasien());

                    listPasien.put(addPasien.getIdPasien(), addPasien);

                    break;

                case 2:
                    for(Pasien value : listPasien.values()){
                        if (value instanceof Elder) {
                            Elder elder = new Elder();
                            System.out.printf("ID: %s, Nama: %s, Birth Date: %s, Usia: %s \n", value.getIdPasien(), value.getNamaPasien(), value.getTanggalLahirPasien(), value.getUsiaPasien());
                            System.out.println("\nPenyakit yang Diderita:");
                            LinkedList<String> penyakitList = elder.getNamaPenyakit();
                            LinkedList<String> keteranganList = elder.getKeterangan();
                        } else { System.out.printf("ID: %s, Nama: %s, Birth Date: %s, Usia: %s \n", value.getIdPasien(), value.getNamaPasien(), value.getTanggalLahirPasien(), value.getUsiaPasien());
                            System.out.println("=======================================================");

                        }
                    }
                    System.out.println("Masukan id pasien yang ingin didaftarkan");
                    String inputIdPasien = scanner.nextLine();
                    for(Pasien value : listPasien.values()) {
                        if (value.getIdPasien().equalsIgnoreCase(inputIdPasien)) {
                            String pasienNama = value.getNamaPasien();

                            System.out.print("Input durasi dalam menit: \n");
                            Integer durasi = Integer.valueOf(scanner.nextLine());

                            System.out.print("Input tanggal dan jam mulai treatment (dd/MM/yyyy HH:mm): \n");
                            String inputJadwalTreatment = scanner.nextLine();

                            DateTimeFormatter formatterJadwal = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                            LocalDateTime jadwalTreatment = LocalDateTime.parse(inputJadwalTreatment, formatterJadwal);

                            System.out.print("Input nama dokter: \n");
                            String namaDokter = scanner.nextLine();

                            for (HashMap.Entry node : listPelayanan.entrySet()){
                                System.out.println(node.getKey()+" "+node.getValue());
                            }

                            System.out.println("Masukkan kode checkup:");
                            String codeCheckup = scanner.nextLine();

                            if (listPelayanan.containsKey(codeCheckup)){
                                System.out.println("============ Entry Medical Check Up Selesai ============");
                            }else {
                                System.out.println("gagal");
                            }

                            LogMedicalCheckup addHistoryCheckup = new LogMedicalCheckup(pasienNama, durasi, jadwalTreatment, namaDokter);

                            historyBooking.add(addHistoryCheckup);


                        }

                    }

                    break;

                case 3:

                    for(Pasien value : listPasien.values()){
                        if (value instanceof Elder) {
                            Elder elder = new Elder();
                            System.out.printf("ID: %s, Nama: %s, Birth Date: %s, Usia: %s \n", value.getIdPasien(), value.getNamaPasien(), value.getTanggalLahirPasien(), value.getUsiaPasien());
                            System.out.println("\nPenyakit yang Diderita:");
                            LinkedList<String> penyakitList = elder.getNamaPenyakit();
                            LinkedList<String> keteranganList = elder.getKeterangan();
                        } else { System.out.printf("ID: %s, Nama: %s, Birth Date: %s, Usia: %s \n", value.getIdPasien(), value.getNamaPasien(), value.getTanggalLahirPasien(), value.getUsiaPasien());
                            System.out.println("=======================================================");

                        }
                    }
                    System.out.println("Masukan id pasien yang ingin didaftarkan");
                    String idPasienMedicine = scanner.nextLine();
                    for(Pasien value : listPasien.values()) {
                        if (value.getIdPasien().equalsIgnoreCase(idPasienMedicine)) {
                            String pasienNama = value.getNamaPasien();

                            System.out.print("Input durasi dalam menit: \n");
                            Integer durasi = Integer.valueOf(scanner.nextLine());

                            System.out.print("Input tanggal dan jam mulai appointment (dd/MM/yyyy HH:mm): \n");
                            String inputJadwalTreatment = scanner.nextLine();

                            DateTimeFormatter formatterJadwal = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                            LocalDateTime jadwalDatang = LocalDateTime.parse(inputJadwalTreatment, formatterJadwal);

                            System.out.print("Input nama medication: \n");
                            String namaMedication = scanner.nextLine();

                            System.out.print("Input quantity medication: \n");
                            Integer quantityMedication = Integer.valueOf(scanner.nextLine());

                            LogMedication addHistoryMedication = new LogMedication(pasienNama, durasi, jadwalDatang, namaMedication,quantityMedication);

                            historyMedication.add(addHistoryMedication);

                            System.out.println("============ Entry Medication Selesai ============");
                        }
                    }

                    break;

                case 4:

                    for(Pasien value : listPasien.values()){
                        if (value instanceof Elder) {
                            Elder elder = new Elder();
                            System.out.printf("ID: %s, Nama: %s, Birth Date: %s, Usia: %s \n", value.getIdPasien(), value.getNamaPasien(), value.getTanggalLahirPasien(), value.getUsiaPasien());
                            System.out.println("\nPenyakit yang Diderita:");
                            LinkedList<String> penyakitList = elder.getNamaPenyakit();
                            LinkedList<String> keteranganList = elder.getKeterangan();
                        } else { System.out.printf("ID: %s, Nama: %s, Birth Date: %s, Usia: %s \n", value.getIdPasien(), value.getNamaPasien(), value.getTanggalLahirPasien(), value.getUsiaPasien());
                            System.out.println("=======================================================");

                        }
                    }
                    System.out.println("Masukan id pasien yang ingin didaftarkan");
                    String idPasienTherapy = scanner.nextLine();
                    for(Pasien value : listPasien.values()) {
                        if (value.getIdPasien().equalsIgnoreCase(idPasienTherapy)) {
                            String pasienNama = value.getNamaPasien();

                            System.out.print("Input durasi dalam menit: \n");
                            Integer durasi = Integer.valueOf(scanner.nextLine());

                            System.out.print("Input tanggal dan jam mulai appointment (dd/MM/yyyy HH:mm): \n");
                            String inputJadwalTreatment = scanner.nextLine();

                            DateTimeFormatter formatterJadwal = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                            LocalDateTime jadwalDatang = LocalDateTime.parse(inputJadwalTreatment, formatterJadwal);

                            System.out.print("Input nama treatment: \n");
                            String namaTreatment = scanner.nextLine();

                            System.out.print("Input nama therapist: \n");
                            String namaTherapist = scanner.nextLine();

                            LogTherapy addHistoryTherapy = new LogTherapy(pasienNama, durasi, jadwalDatang, namaTreatment, namaTherapist);

                            historyTherapy.add(addHistoryTherapy);

                            System.out.println("============ Entry Medication Selesai ============");
                        }
                    }

                    break;

                case 5:

                    for (LogMedicalCheckup listMedicalCheckup : historyBooking){
                        System.out.println("===========================================================================");
                        System.out.println("Medical Checkup");
                        System.out.printf("Nama: %s, Tanggal Check Up: %s - %s, Durasi: %s Menit, Nama Dokter: %s \n", listMedicalCheckup.getNamaPasien(),listMedicalCheckup.getTanggalCheckUp(), listMedicalCheckup.getTanggalSelesai(), listMedicalCheckup.getDurasi(), listMedicalCheckup.getNamaDokter());
                        System.out.println("===========================================================================");
                    }
                    for (LogMedication listMedication : historyMedication){
                        System.out.println("===========================================================================");
                        System.out.println("Medication");
                        System.out.printf("Nama: %s, Tanggal Check Up: %s - %s, Durasi: %s Menit, Nama Medication: %s, Quantity Medication: %s \n", listMedication.getNamaPasien(),listMedication.getTanggalDatang(), listMedication.getTanggalSelesai(), listMedication.getDurasi(), listMedication.getNamaMedication(), listMedication.getQuantityMedication());
                        System.out.println("===========================================================================");
                    }
                    for (LogTherapy listTherapy : historyTherapy){
                        System.out.println("===========================================================================");
                        System.out.println("Therapy");
                        System.out.printf("Nama: %s, Tanggal Check Up: %s - %s, Durasi: %s Menit, Nama Treatment: %s, Nama Therapist: %s \n", listTherapy.getNamaPasien(),listTherapy.getTanggalDatang(), listTherapy.getTanggalSelesai(), listTherapy.getDurasi(), listTherapy.getNamaTreatment(), listTherapy.getNamaTherapist());
                        System.out.println("===========================================================================");
                    }

                    break;

                case 6:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opsi tidak tersedia, silakan pilih kembali.");
            }
        }


    }

    public static void mainMenu() {
        System.out.println("Pilih nomor menu untuk masuk ke menunya: ");
        System.out.println("1. Tambah pasien");
        System.out.println("2. Daftar Medical Checkup");
        System.out.println("3. Daftar Medication");
        System.out.println("4. Therapy");
        System.out.println("5. Treatment Schedule");
        System.out.println("6. Exit Application");
        System.out.println("Pilihan : ");
    }

    public static int validateInteger(Scanner scanner, Integer minNumber, Integer maxNumber){
        while (true){
            try {
                int input = Integer.parseInt(scanner.nextLine());
                if (input >= minNumber && input <= maxNumber){
                    return input;
                }else {
                    System.out.printf("Input harus diantara %s dan %s\n", minNumber, maxNumber);
                }
            }catch (Exception exception){
                System.out.println("Input harus berupa bilangan bulat\n");
            }
        }
    }
}