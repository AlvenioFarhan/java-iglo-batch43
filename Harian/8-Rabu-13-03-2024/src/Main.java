import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        Student alex = new Student("Alexander", LocalDate.of(1988,11,28),89.5);
//
//        //penggunaan Object
//        Object alexObject = alex;
//
//        Double gradeAlex = ((Student)alexObject).getGrade();
//
//        Long umurAlex = ((Student)alexObject).getAge();
//
//        Person amelia = new Person("Amelia", LocalDate.of(1999,3,4));
//
//        String text = "Hello World";
//
//        Double harga = 45.6;
//
//        int jumlah = 4;
//
//        LinkedList<String> colours = new LinkedList<>();
//        colours.add("Merah");
//        colours.add("Biru");
//        colours.add("Hijau");
//
//        menerimaObject(alex);


        //-----------------------------------------------------------------------------------

        //ABSTRACTION
        //INTERFACE

        /*
        * Student alex = new Student();
        * Tutor cahya = new Tutor();
        *
        * prosesPerson(alex);
        * prosesPerson(cahya);
        * */

        //WargaNegara cahya = new Manager();

//        Manager alex = new Manager();
//        WargaNegara alex = new Manager();
//        prosesPerson(alex);
//        prosesWargaNegara(alex);
//        prosesManager(alex);


//        List<String> colours = new LinkedList<String>();
//        List<String> names = new ArrayList<String>();


        Supervisor chandra = new Supervisor(12_000_000.0, LocalDate.of(2021,2,3),
                null,5_000_000.0);

        prosesPerson(chandra);
//        prosesWargaNegara(chandra);
        prosesKaryawan(chandra);
        prosesSupervisor(chandra);
//        prosesManager(chandra);



    }

    public static void prosesPerson(Person person){}
    public static void prosesWargaNegara(WargaNegara wargaNegara){}
    public static void prosesKaryawan(Karyawan karyawan){}
    public static void prosesSupervisor(Supervisor supervisor){}
    public static void prosesManager(Manager manager){}





    //----------------------------------------------------------------------------------

//    public static void prosesManager(Manager manager){
//
//    }
//
//    public static void prosesPerson(Person person){
//        System.out.println(person.getName());
//    }
//
//    public static void prosesWargaNegara(WargaNegara wargaNegara){
//        System.out.println(wargaNegara.getNomorKTP());
//    }

    //Object = kakeknya para kakek, atau class object pertama. Seperti di manusia itu Adam.
//    public static Object menerimaObject(Object objectApapun){
//        Person amelia = new Person("Amelia", LocalDate.of(1999,3,4));
//        return amelia;
//    }
//
//    //Final = tidak dapat diubah" atau di edit.
//    public static String printSomething(final String input){
////        input = "Coba";
//        return  "Test";
//    }
}