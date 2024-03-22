import javax.swing.*;

public class Task {

    private String deskripsi;
    private Boolean isSelesai;

    public Task(String deskripsi) {
        this.deskripsi = deskripsi;
        this.isSelesai = false;
    }

    public String getDeskripsi() {
        return deskripsi;
    }


    public Boolean getSelesai() {
        return isSelesai;
    }


    public void tandaiTelahSelesai(){
        isSelesai = true;
    }

    //uba
    public String toString(){
        if (this.isSelesai){
            return this.deskripsi + " - Selesai";
        }else {
            return this.deskripsi;
        }
    }
}
