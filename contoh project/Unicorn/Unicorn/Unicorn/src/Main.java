import institution.*;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static String[] mainMenu = {
        "All Student Data",
        "All Tutor Data",
        "About this University",
        "Exit Application"
    };
    public static String[] studentMenu = {
        "Student Information",
        "Back to Main Menu",
        "Exit Application"
    };
    public static String[] tutorMenu = {
        "Tutor Information",
        "Back to Main Menu",
        "Exit Application"
    };
    public static String[] subStudentMenu = {
        "Back to all student data",
        "Back to Main Menu",
        "Exit Application"
    };
    public static String[] subTutorMenu = {
        "Back to all tutor data",
        "Back to Main Menu",
        "Exit Application"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        University.initializeData();
        mainMenu(scanner);
    }

    public static void mainMenu(Scanner scanner){
        printMenus(mainMenu);
        var rio = new Student("Rio", "Andika", LocalDate.of(2000,3,5),
            "Pekan Baru", Gender.L, "7491237481", Religion.BUDDHA, BloodType.AB, "A025", LocalDate.of(2022,6,7));
        University.addOneStudent(rio);

        var allSubjects = University.getAllSubjects();
        allSubjects.get("PMP").setNama("Kurang Professionals");

        Integer number = validateMenuInput(scanner, mainMenu.length);
        switch (number){
            case 1:
                studentMenu(scanner);
            case 2:
                tutorMenu(scanner);
            case 3:
                University.printAbout();
                mainMenu(scanner);
            case 4:
                executeExit(scanner);
            default:
                System.out.println("Input menu is not valid");
                break;
        }
    }

    public static void studentMenu(Scanner scanner){
        University.printAllStudentsSummary();
        printMenus(studentMenu);
        Integer number = validateMenuInput(scanner, studentMenu.length);
        switch (number){
            case 1:
                studentInformation(scanner);
            case 2:
                mainMenu(scanner);
            case 3:
                executeExit(scanner);
            default:
                System.out.println("Input menu is not valid");
                break;
        }
    }

    public static void studentInformation(Scanner scanner){
        System.out.println("Masukan nomor NIK yang anda ingin lihat informasinya:");
        var nik = scanner.nextLine();
        Boolean isFound = University.findAndPrintOneStudent(nik);
        if(!isFound){
            System.out.println("Student tidak ditemukan, coba lagi.");
            studentInformation(scanner);
        }
        subStudentMenu(scanner);
    }

    public static void tutorMenu(Scanner scanner){
        University.printAllTutorsSummary();
        printMenus(tutorMenu);
        Integer number = validateMenuInput(scanner, tutorMenu.length);
        switch (number){
            case 1:
                tutorInformation(scanner);
            case 2:
                mainMenu(scanner);
            case 3:
                executeExit(scanner);
            default:
                System.out.println("Input menu is not valid");
                break;
        }
    }

    public static void tutorInformation(Scanner scanner){
        System.out.println("Masukan nomor NIK yang anda ingin lihat informasinya:");
        var nik = scanner.nextLine();
        Boolean isFound = University.findAndPrintOneTutor(nik);
        if(!isFound){
            System.out.println("Tutor tidak ditemukan, coba lagi.");
            tutorInformation(scanner);
        }
        subTutorMenu(scanner);
    }

    public static void subStudentMenu(Scanner scanner){
        printMenus(subStudentMenu);
        Integer number = validateMenuInput(scanner, subStudentMenu.length);
        switch (number){
            case 1:
                studentMenu(scanner);
            case 2:
                mainMenu(scanner);
            case 3:
                executeExit(scanner);
            default:
                System.out.println("Input menu is not valid");
                break;
        }
    }

    public static void subTutorMenu(Scanner scanner){
        printMenus(subTutorMenu);
        Integer number = validateMenuInput(scanner, subTutorMenu.length);
        switch (number){
            case 1:
                tutorMenu(scanner);
            case 2:
                mainMenu(scanner);
            case 3:
                executeExit(scanner);
            default:
                System.out.println("Input menu is not valid");
                break;
        }
    }

    public static void executeExit(Scanner scanner){
        scanner.close();
        System.exit(0);
    }

    public static void printMenus(String[] menus){
        System.out.println("Pilih nomor menu untuk masuk ke menunya:");
        for(int index = 0; index < menus.length; index++){
            System.out.printf("\t%s. %s\n", index + 1, menus[index]);
        }
    }

    public static Integer validateMenuInput(Scanner scanner, Integer maxInput){
        String input = scanner.nextLine();
        try{
            Integer number = Integer.parseInt(input);
            if(number > 0 && number <= maxInput){
                return number;
            } else {
                System.out.printf("Input harus antara 1 - %s\n", maxInput);
                return validateMenuInput(scanner, maxInput);
            }
        }catch (Exception exception){
            System.out.println("Input harus berupa angka bulat");
            return validateMenuInput(scanner, maxInput);
        }
    }

}