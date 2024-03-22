import java.time.LocalDate;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {


        //Nomor 2
        Pembeli michael = new Pembeli(23,"Michael", "Jackson", LocalDate.of(1976, 5, 19),
                12_000_000.0);
        Pembeli andrea = new Pembeli(25, "Andrea", "Bocelli", LocalDate.of(1973,11,23),
                15_300_000.0);
        Pembeli bob = new Pembeli(27, "Bob", "Marley", LocalDate.of(1968, 3,1),
                2_450_000.0);


        //Nomor 3
//        Pembeli.changeFirstName(michael, "John");
//        System.out.println(michael.getFirstName());

        //Nomor 4
//        LinkedList<Pembeli> people =new LinkedList<>();
//        people.add(michael);
//        people.add(andrea);
//        people.add(bob);
//
//        for (Pembeli pembeli : people){
//            pembeli.getInformation();
//        }

        //Nomor 5
//        Long umurMichael = michael.getUmur();
//        System.out.println(umurMichael + " Tahun");
//
//        Long umurAndrea = andrea.getUmur();
//        System.out.println(umurAndrea + " Tahun");
//
//        Long umurBob = bob.getUmur();
//        System.out.println(umurBob + " Tahun");


        //Nomor 6
//        for (Pembeli pembeli : people){
//            pembeli.formatterUang();
//        }

        //Nomor 8
//        for (Pembeli pembeli : people){
//            pembeli.printInformation();
//        }

        //Nomor 10
        Alamat alamatMichael = new Alamat("USA", "California", "Los Angeles", "Truman Street B34 Unit 5");
        Alamat alamatAndrea = new Alamat("Italy", "Lazio", "Rome", "Saint Marcus Street C45 Unit 1");
        Alamat alamatBob = new Alamat("Indonesia", "DKI Jakarta", "Jakarta", " Daan Mogot C 9-10");

        //Set Alamt
        michael.setAlamat(alamatMichael);
        andrea.setAlamat(alamatAndrea);
        bob.setAlamat(alamatBob);

        //PrintAlamat
//        michael.printAlamatInformation();
//        andrea.printAlamatInformation();
//        bob.printAlamatInformation();

        //Print Alamat dengan LinkList
//        LinkedList<Pembeli> people =new LinkedList<>();
//        people.add(michael);
//        people.add(andrea);
//        people.add(bob);
//
//        //ForEach untuk munculkan semua di LinkList
//        for (Pembeli pembeli : people){
//            pembeli.printAlamatInformation();
//        }


    }




}