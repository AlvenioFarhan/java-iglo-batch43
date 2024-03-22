import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();

        while (true){
            System.out.println("Menu:");
            System.out.println("1. Tambah Task");
            System.out.println("2. Tandai Task Telah Selesai");
            System.out.println("3. Delete Task");
            System.out.println("4. Tampilkan Task");
            System.out.println("5. Exit");
            System.out.println("Pilih (1/2/3/4):");
            Integer input = Integer.parseInt(scanner.nextLine());

            switch (input){
                case 1:
                    System.out.println("Tambahkan Deskripsi Task:");
                    String description = scanner.nextLine();
                    Task task = new Task(description);
                    taskManager.tambahkanTask(task);
                    System.out.println("Sukses Menambahkan Task");
                    break;
                case 2:
                    taskManager.printTampilanTask();
                    System.out.println("Task berapa yang sudah di selesaikan:");
                    Integer index = Integer.parseInt(scanner.nextLine());
                    taskManager.printTandaiTelahSelesai(index-1);
                    break;
                case 3:
                    taskManager.printTampilanTask();
                    System.out.println("Task berapa yang ingin di hapus:");
                    Integer number = Integer.parseInt(scanner.nextLine());
                    taskManager.deleteTask(number - 1);

                    break;
                case 4:
                    taskManager.printTampilanTask();
                    break;
                case 5:
                    System.out.println("Good Bye! :)");
                    System.exit(0);
                default:
                    System.out.println("Pilihan Gagal, Input Angka 1 - 4");
            }
        }
    }
}