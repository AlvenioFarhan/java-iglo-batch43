import java.util.LinkedList;

public class Movie {
    /*
     *
     * Class Movie
     *
     * title/judul
     * sutradara
     * durasi
     * actorNames (Bisa sebanyak banyaknya)
     *
     * */

    private String title;
    private String sutradara;
    private Integer durasi;
    private LinkedList<String> actorNames;


    public Movie(String title, String sutradara, Integer durasi, LinkedList<String> actorNames) {
        this.title = title;
        this.sutradara = sutradara;
        this.durasi = durasi;
        this.actorNames = actorNames;
    }


    public Movie(String title, String sutradara, Integer durasi) {
        this.title = title;
        this.sutradara = sutradara;
        this.durasi = durasi;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSutradara() {
        return sutradara;
    }

    public void setSutradara(String sutradara) {
        this.sutradara = sutradara;
    }

    public Integer getDurasi() {
        return durasi;
    }

    public void setDurasi(Integer durasi) {
        this.durasi = durasi;
    }

    public LinkedList<String> getActorNames() {
        return actorNames;
    }

    public void setActorNames(LinkedList<String> actorNames) {
        this.actorNames = actorNames;
    }

    public void addActorNames(String actorName){
        actorNames.add(actorName);
    }

    //jumlah aktor
    public Integer sizeActorNames(LinkedList<String> actorNames){
        return actorNames.size();
    }

    //menampilkan aktor
    public void showActors(){
        for ( String nameActors: actorNames){
            System.out.println(nameActors);
        }
    }

}
