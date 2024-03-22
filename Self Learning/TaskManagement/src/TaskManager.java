import java.util.LinkedList;

public class TaskManager {
    private LinkedList<Task> tasks;

    public TaskManager() {
        this.tasks = new LinkedList<>();
    }

    public void tambahkanTask(Task task){
        tasks.add(task);
    }

    public void printTandaiTelahSelesai(int index){
        if (index >= 0 && index < tasks.size()){
            Task task = tasks.get(index);
            task.tandaiTelahSelesai();
            System.out.println("Task telah diselesaikan");
        }else {
            System.out.println("Task tidak ditemukan");
        }
    }

    public void deleteTask(int index){
        if (index >= 0 && index < tasks.size()){
            tasks.remove(index);
            System.out.println("Task telah dihapus");
        } else {
            System.out.println("Task tidak ditemukan");
        }
    }

    public void printTampilanTask(){
        System.out.println("Task:");
        for (int index = 0;index < tasks.size() ; index++ ){
            System.out.println((index + 1) + ". " + tasks.get(index));
        }

    }
}
