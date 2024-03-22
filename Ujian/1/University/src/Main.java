import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //---------------------------------------------------------------------

        //PROGRAM APLIKASI
        //MENU
        mainMenu();
    }

    //---------------------------------------------------------------------

    //MAIN MENU APLIKASI
    public static void mainMenu(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Pilih nomor menu untuk masuk ke menunya:");
            System.out.println("1. All Student Data");
            System.out.println("2. All Tutor Data");
            System.out.println("3. About this University");
            System.out.println("4. Exit Application");
            System.out.println("Pilihan (1/2/3/4):");

            Integer pilihanMenu = 0;
            try {
                pilihanMenu = Integer.parseInt(scanner.nextLine());
            }catch (Exception exception){
                System.out.println("Pilihan Salah, silahkan pilih angka 1 - 4");
            }

            switch (pilihanMenu){
                case 1:
                    getAllStudentData();
                    break;
                case 2:
                    getAllTutorData();
                    break;
                case 3:
                    universityInfo();
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

    public static void universityInfo() {
        System.out.println("About this University");
        System.out.println("Nama Universitas: Unicorn (University of Cornelius)");
        System.out.println("Didirikan sejak: 12 December 1978");
        System.out.println("Lokasi: Amerika Serikat, Southern State, Texas");
    }

    //---------------------------------------------------------------------
    //Method All Data Mahasiswa
    public static void getAllStudentData(){
        Scanner scanner = new Scanner(System.in);

        // DATA MATAKULIAH
        MataKuliah oop = new MataKuliah("Object Oriented Programming","Programming",20);
        MataKuliah dataStructure = new MataKuliah("Data Structure","Programming",30);
        MataKuliah networkingFundamental = new MataKuliah("Networking Fundamental", "Networking", 20);
        MataKuliah databaseFundamental = new MataKuliah("Database Fundamental","Programming", 30);
        MataKuliah projectManagement = new MataKuliah("Project Management Professional","Management and Analysis", 40);
        MataKuliah unifiedModelling = new MataKuliah("Unified Modelling Language", "Management and Analysis", 20);
        MataKuliah javaFundamental = new MataKuliah("Java Fundamental", "Programming", 30);
        MataKuliah infrastructureDesign = new MataKuliah("Infrastructure Design", "Networking", 30);
        MataKuliah networkAndSecurity = new MataKuliah("Network and Security", "Networking", 20);


        // DATA MAHASISWA
        Mahasiswa alex = new Mahasiswa("Alex", "Wirianata", LocalDate.of(1990,11,23),
                "Jakarta",Gender.L,"312008923111990002",Agama.KRISTEN,GolonganDarah.A,
                "A021",LocalDate.of(2018,4,12));

        MatkulMahasiswa matkulAlexOop = new MatkulMahasiswa(oop, alex,LocalDate.of(2018,4,12),
                LocalDate.of(2018,9,12));
        MatkulMahasiswa matkulAlexDS = new MatkulMahasiswa(dataStructure,alex,
                LocalDate.of(2018,8,18), null);

        LinkedList<MatkulMahasiswa> listAlexMatkul = new LinkedList<>();
        listAlexMatkul.add(matkulAlexOop);
        listAlexMatkul.add(matkulAlexDS);

        alex.setListMatkul(listAlexMatkul);

        Mahasiswa desy = new Mahasiswa("Desy", "Oktaviani", LocalDate.of(1995,5,11),
                "Bandung",Gender.P,"312008911051995002",Agama.ISLAM,GolonganDarah.O,
                "A022",LocalDate.of(2018,4,1));

        MatkulMahasiswa matkulDesyNF = new MatkulMahasiswa(networkingFundamental, desy,
                LocalDate.of(2018,4,1), null);
        MatkulMahasiswa matkulDesyDS = new MatkulMahasiswa(dataStructure,alex,
                LocalDate.of(2018,8,18), null);

        LinkedList<MatkulMahasiswa> listDesyMatkul = new LinkedList<>();
        listDesyMatkul.add(matkulDesyNF);
        listDesyMatkul.add(matkulDesyDS);

        desy.setListMatkul(listDesyMatkul);


        Mahasiswa joko = new Mahasiswa("Joko", "Davidson", LocalDate.of(1990,6,7),
                "Jakarta",Gender.L,"3120089277889990002",Agama.ISLAM,GolonganDarah.A,
                "A023",LocalDate.of(2018,4,14));

        MatkulMahasiswa matkulJokoUML = new MatkulMahasiswa(unifiedModelling, joko,
                LocalDate.of(2018, 5,3), LocalDate.of(2018, 11,1));

        LinkedList<MatkulMahasiswa> listJokoMatkul = new LinkedList<>();
        listJokoMatkul.add(matkulJokoUML);

        joko.setListMatkul(listJokoMatkul);

        LinkedList<Mahasiswa> listMahasiswa = new LinkedList<>();
        listMahasiswa.add(alex);
        listMahasiswa.add(desy);
        listMahasiswa.add(joko);

        for ( Mahasiswa mahasiswa : listMahasiswa){
            mahasiswa.printallStudentData();
        }

        while (true){
            System.out.println("Pilih nomor menu untuk masuk ke menunya:");
            System.out.println("1. Student Information");
            System.out.println("2. Back to Main Menu");
            System.out.println("3. Exit Application");
            System.out.println("Pilihan (1/2/3):");

            Integer pilihanMenu = 0;
            try {
                pilihanMenu = Integer.parseInt(scanner.nextLine());
            }catch (Exception exception){
                System.out.println("Pilihan Salah, silahkan pilih angka 1 - 3");
            }

            switch (pilihanMenu){
                case 1:
                    System.out.print("Masukkan nomor NIK tutor yang ingin Anda lihat informasinya: ");
                    String inputNIKMahasiswa = scanner.next();

                    boolean found = false;
                    for (Mahasiswa mahasiswa : listMahasiswa) {
                        if (mahasiswa.getNikMahasiswa().equals(inputNIKMahasiswa)) {
                            mahasiswa.printStudentInformation();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Mahasiswa dengan NIK " + inputNIKMahasiswa + " tidak ditemukan.");
                    }
                    break;
                case 2:
                    mainMenu();
                    break;
                case 3:
                    System.out.println("Good Bye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan Salah, silahkan pilih angka 1 - 3");
                    break;
            }
        }
    }


    //---------------------------------------------------------------------
    //Get All Tutor Data
    public static void getAllTutorData(){
        Scanner scanner = new Scanner(System.in);

        // DATA MATAKULIAH
        MataKuliah oop = new MataKuliah("Object Oriented Programming","Programming",20);
        MataKuliah dataStructure = new MataKuliah("Data Structure","Programming",30);
        MataKuliah networkingFundamental = new MataKuliah("Networking Fundamental", "Networking", 20);
        MataKuliah databaseFundamental = new MataKuliah("Database Fundamental","Programming", 30);
        MataKuliah projectManagement = new MataKuliah("Project Management Professional","Management and Analysis", 40);
        MataKuliah unifiedModelling = new MataKuliah("Unified Modelling Language", "Management and Analysis", 20);
        MataKuliah javaFundamental = new MataKuliah("Java Fundamental", "Programming", 30);
        MataKuliah infrastructureDesign = new MataKuliah("Infrastructure Design", "Networking", 30);
        MataKuliah networkAndSecurity = new MataKuliah("Network and Security", "Networking", 20);


        //DOSEN
        Dosen antik = new Dosen("Antik", "Haya", LocalDate.of(1988,11,12),
                "Jakarta",Gender.P,"312008912111988002",Agama.ISLAM,GolonganDarah.A,
                "T701",6_500_000.0, LocalDate.of(2016,3,8));

        MatkulDosen matkulDosenAntikID = new MatkulDosen(infrastructureDesign,antik);
        MatkulDosen matkulDosenAntikNS = new MatkulDosen(networkAndSecurity,antik);

//        LinkedList<MataKuliah> matkulAntik = new LinkedList<>();
//        matkulAntik.add(infrastructureDesign);
//        matkulAntik.add(networkAndSecurity);
//
//        antik.setMatakuliahDosen(matkulAntik);

        LinkedList<MatkulDosen>  listAntikMatkul = new LinkedList<>();
        listAntikMatkul.add(matkulDosenAntikID);
        listAntikMatkul.add(matkulDosenAntikNS);

        antik.setMataKuliahDiajar(listAntikMatkul);




        Dosen cahya = new Dosen("Cahya", "Subroto", LocalDate.of(1989,1,7),
                "Surabaya",Gender.L,"312008907011989002",Agama.ISLAM,GolonganDarah.B,
                "T808",8_800_000.0, LocalDate.of(2016,4,4));

        MatkulDosen matkulDosenCahyaOOP = new MatkulDosen(oop,cahya);
        MatkulDosen matkulDosenCahyaJF = new MatkulDosen(javaFundamental,cahya);
        MatkulDosen matkulDosenCahyaDF = new MatkulDosen(databaseFundamental,cahya);

        LinkedList<MatkulDosen> listCahyaMatkul = new LinkedList<>();
        listCahyaMatkul.add(matkulDosenCahyaJF);
        listCahyaMatkul.add(matkulDosenCahyaOOP);
        listCahyaMatkul.add(matkulDosenCahyaDF);

        cahya.setMataKuliahDiajar(listCahyaMatkul);
        LinkedList<Dosen> listDosen = new LinkedList<>();
        listDosen.add(antik);
        listDosen.add(cahya);

        for (Dosen dosen : listDosen){
            dosen.printAllDosenData();
        }


        while (true){
            System.out.println("Pilih nomor menu untuk masuk ke menunya:");
            System.out.println("1. Tutor Information");
            System.out.println("2. Back to Main Menu");
            System.out.println("3. Exit Application");
            System.out.println("Pilihan (1/2/3):");

            Integer pilihanMenu = 0;
            try {
                pilihanMenu = Integer.parseInt(scanner.nextLine());
            }catch (Exception exception){
                System.out.println("Pilihan Salah, silahkan pilih angka 1 - 3");
            }

            switch (pilihanMenu){
                case 1:
                    System.out.print("Masukkan nomor NIK tutor yang ingin Anda lihat informasinya: ");
                    String inputNIKTutor = scanner.nextLine();

                    boolean found = false;
                    for (Dosen dataDosen : listDosen) {
                        if (dataDosen.getNikDosen().equals(inputNIKTutor)) {
                            dataDosen.printTutorInformation();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Tutor dengan NIK " + inputNIKTutor + " tidak ditemukan.");
                    }
                    break;
                case 2:
                    mainMenu();
                    break;
                case 3:
                    System.out.println("Good Bye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan Salah, silahkan pilih angka 1 - 3");
                    break;
            }

        }

    }

//buat fungsi, netima parameter LinkList Tutor. fungsinya, untuk print Nik tutornya

    public void printNIKDosen(LinkedList<Dosen> listDosen){
        for ( Dosen dosen: listDosen){
            System.out.println(dosen.getNikDosen());
        }
    }

//buat fungsi, yang menerima linklist Integer. Jumlahkan semua integer di list integer. lalu return

    public static Integer getPenjumlahan(LinkedList<Integer> banyakAngka){
        int hasil = 0;
        for ( Integer integer : banyakAngka){
            hasil += integer;
        }
        return hasil;
    }


}