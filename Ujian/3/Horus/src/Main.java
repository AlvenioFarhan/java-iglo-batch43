import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Horus.intializeDataMedicallCheckup();
        mainMenu(scanner);
    }

    public static String[] mainMenu = {
            "Tambah patient",
            "Daftar Medical Checkup",
            "Daftar Mediation",
            "Daftar Therapy",
            "Treatment Schedule",
            "Exit Applocation"
    };

    public static void mainMenu(Scanner scanner) {
        printMenus(mainMenu);
        System.out.println("Pilihan: ");

        Integer number = validateMenuInput(scanner, mainMenu.length);
        switch (number) {
            case 1:
//                Tambah Patient
                tambahPatientMenu(scanner);
                break;
            case 2:
//                 "Daftar Medical Checkup",
                daftarMedicalCheckupMenu(scanner);
                break;
            case 3:
//                "Daftar Mediation",
                mediationMenu(scanner);
                break;
            case 4:
//                "Daftar Therapy",
                daftarTherapyMenu(scanner);
                break;
            case 5:
//                "Treatment Schedule",
                treatmentScheduleMenu(scanner);
                break;
            case 6:
                executeExit(scanner);
                break;
            default:
                System.out.println("Input menu is not valid");
                break;
        }
    }

    public static void tambahPatientMenu(Scanner scanner) {
        Horus.printAllDataPatient();

        System.out.println("Input patient Id:");
        System.out.println("(Patient Id harus unik, menginput id yang sama akan me-replace patient sebelumnya)");
        String idPatient = scanner.nextLine();

        Horus.replacePatientDoubleID(idPatient);

        System.out.println("Input nama patient:");
        String namaPatient = scanner.nextLine();

        LocalDate birthDate = validateTanggalLahir(scanner);


        Patient patient = new Patient(idPatient, namaPatient, birthDate);
        Horus.addDataPatient(patient);

//        tanya penyakit
        patientOld(patient, scanner);

        System.out.println("======Entry patient selesai========");
        mainMenu(scanner);
    }

    public static LocalDate validateTanggalLahir(Scanner scanner) {
        LocalDate tanggalLahir = null;
        boolean inputValid = false;
        while (!inputValid) {
            System.out.println("Input tanggal lahir patient (dd/MM/yyyy):");
            String inputTanggalLahir = scanner.nextLine();
            try {
                tanggalLahir = LocalDate.parse(inputTanggalLahir, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                inputValid = true;
            } catch (Exception exception) {
                System.out.println("Input tanggal tidak dalam format yang benar, coba lagi.");
            }
        }
        return tanggalLahir;
    }

    public static void patientOld(Patient patient, Scanner scanner) {
        if (patient.getAge() >= 65) {
            addChronicDisiase(scanner);
        } else {
            mainMenu(scanner);
        }

    }

    //tanya penyakit
    public static void addChronicDisiase(Scanner scanner) {
        String isYesOrNo;
        System.out.println("Apakah patient memiliki penyakit kronis? (Y/N)");
        isYesOrNo = scanner.nextLine();

        do {
            if (isYesOrNo.equals("Y")) {
                System.out.println("Nama Penyakit:");
                String namaPenyakit = scanner.nextLine();

                System.out.println("Keterangan:");
                String keteranganPenyakit = scanner.nextLine();

                ChronicDisease chronicDisease = new ChronicDisease(namaPenyakit, keteranganPenyakit);
                Horus.addDataPenyakit(chronicDisease);

                System.out.println("Apakah patient memiliki penyakit kronis lainnya? (Y/N)");
                isYesOrNo = scanner.nextLine();

            } else if (!isYesOrNo.equals("N")) {
                System.out.println("Input tidak valid. Harap masukkan Y atau N.");
                mainMenu(scanner);
            }
        } while (isYesOrNo.equalsIgnoreCase("Y"));
    }

    //menu medical checkup
    public static void daftarMedicalCheckupMenu(Scanner scanner) {
        Horus.printAllDataPatient();


        System.out.println("Pilih satu patient dengan meng-input Id-nya:");
        String idPatient = scanner.nextLine();

        Horus.findPatientByID(idPatient);
        if (Horus.findPatientByID(idPatient) == null) {
            System.out.println("ID pasien tidak valid. Silakan coba lagi.");
            daftarMedicalCheckupMenu(scanner);
        } else {
            Horus.findPatientByID(idPatient);
        }

        System.out.println("Input durasi dalam menit:");
        Integer duration = validateDurasiMenit(scanner);

        String tanggalMulai = String.valueOf(validateTanggalDanJamMulai(scanner));

        System.out.println("Input nama dokter:");
        String namaDokter = scanner.nextLine();

        //list Medical Checkup
        Horus.printAllDataMedicalCheckup();

        System.out.println("Input code checkup method yang tersedia diatas:");
        String codeCheckup = scanner.nextLine();

        if (!Horus.isSlotAvailable(codeCheckup)) {
            System.out.println("Method code tidak tersedia");
            daftarMedicalCheckupMenu(scanner);
            return;
        }

        LogMedicalCheckup newLogMedicalCheckup = new LogMedicalCheckup(idPatient, duration, namaDokter, codeCheckup);
        Horus.addDataLogMedicalCheckup(newLogMedicalCheckup);

        System.out.println("========Entry medical checkup selesai========");
        mainMenu(scanner);
    }

    //validate durasi menit
    public static Integer validateDurasiMenit(Scanner scanner) {
        int duration = 0;
        boolean validDuration = false;
        while (!validDuration) {
            try {
                duration = Integer.parseInt(scanner.nextLine());
                if (duration > 0) {
                    validDuration = true;
                } else {
                    System.out.println("Durasi harus lebih dari 0. Silakan coba lagi.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Harus memasukkan bilangan bulat. Silakan coba lagi.");
            }
        }
        return duration;
    }


    public static LocalDate validateTanggalDanJamMulai(Scanner scanner) {
        boolean validate = false;
        while (!validate) {
            System.out.println("Input tanggal dan jam mulai treatment (dd/MM/yyyy HH:mm):");
            String inputStartTreatment = scanner.nextLine();
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                LocalDate treatmentStartTime = LocalDate.parse(inputStartTreatment, formatter);
                validate = true;
                return treatmentStartTime;
            } catch (Exception exception) {
                System.out.println("Input tanggal dan jam tidak dalam format yang benar, coba lagi.");
            }
        }
        return null;
    }


    public static void mediationMenu(Scanner scanner) {

        Horus.printAllDataPatient();

        System.out.println("Pilih satu patient dengan meng-input Id-nya:");
        String idPatient = scanner.nextLine();

        Horus.findPatientByID(idPatient);
        if (Horus.findPatientByID(idPatient) == null) {
            System.out.println("ID pasien tidak valid. Silakan coba lagi.");
            daftarMedicalCheckupMenu(scanner);
        } else {
            Horus.findPatientByID(idPatient);
        }

        System.out.println("Input durasi dalam menit:");
        Integer duration = validateDurasiMenit(scanner);

        String startTreatment = String.valueOf(validateTanggalDanJamMulai(scanner));

        System.out.println("Inpout nama mediation:");
        String namaMediation = scanner.nextLine();

        System.out.println("Input Quantity mediation:");
        Integer quantityMediation = Integer.parseInt(scanner.nextLine());

        LogMediation logMediation = new LogMediation(idPatient, duration, namaMediation, quantityMediation);
        Horus.addDataLogMediation(logMediation);

        System.out.println("========Entry mediation selesai========");
        mainMenu(scanner);
    }

    public static void daftarTherapyMenu(Scanner scanner) {

        Horus.printAllDataPatient();

        System.out.println("Pilih satu patient dengan meng-input Id-nya:");
        String idPatient = scanner.nextLine();

        Horus.findPatientByID(idPatient);
        if (Horus.findPatientByID(idPatient) == null) {
            System.out.println("ID pasien tidak valid. Silakan coba lagi.");
            daftarMedicalCheckupMenu(scanner);
        } else {
            Horus.findPatientByID(idPatient);
        }

        System.out.println("Input durasi dalam menit:");
        Integer duration = validateDurasiMenit(scanner);

        String startTreatment = String.valueOf(validateTanggalDanJamMulai(scanner));

        System.out.println("Inpout nama treatment:");
        String namaTreatment = scanner.nextLine();

        System.out.println("Inpout nama therapist:");
        String namaTherapyst = scanner.nextLine();

        LogTherapy logTherapy = new LogTherapy(idPatient, duration, namaTreatment, namaTherapyst);
        Horus.addDataLogTherapy(logTherapy);

        System.out.println("========Entry therapy selesai========");
        mainMenu(scanner);
    }


    public static void treatmentScheduleMenu(Scanner scanner) {
        Horus.listTreatmentSchedule(scanner);
    }


    public static void printMenus(String[] menus) {
        System.out.println("Input salah satu angka menu:");
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