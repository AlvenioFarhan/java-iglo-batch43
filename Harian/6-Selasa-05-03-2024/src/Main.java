import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");
        //------------------------------------------------------------------------------

        //Object(Instance) ---> Row
//        Person alex = new Person();
//        alex.firstName = "Alexander";
//        alex.setLastName("Dragunov"); //menggunakan setter
//        alex.gender = "Laki - laki";
//        alex.birthDate = LocalDate.of(1967, 8, 2);
//
//
//        Person linda = new Person();
//        linda.firstName = "Lindawati";
//        linda.setLastName("Susanti"); //menggunakan setter
//        linda.gender = "Perempuan";
//        linda.birthDate = LocalDate.of(2003,2,2);
//
//        alex.printHelloWorld();
//        linda.printHelloWorld();
//
//        alex.printNameSendiri();
//        linda.printNameSendiri();
//
//        Long umurAlex = alex.getUmur();
//        System.out.println(umurAlex);
//
//        Long umurLinda = linda.getUmur();
//        System.out.println(umurLinda);


        //------------------------------------------------------------------------------

//        Person alex = new Person();
//        alex.setFirstName("Alexander"); //menggunakan setter
//        alex.setLastName("Dragunov"); //menggunakan setter
//
//
//        Person linda = new Person();
//        linda.setFirstName("Lindawati");//menggunakan setter
//        linda.setLastName("Susanti"); //menggunakan setter
//
//        System.out.println(alex.getName());//menggunakan getter
//        System.out.println(linda.getName());


        //------------------------------------------------------------------------------

        //Constractor

//        Person alex = new Person("Alexander", "Dragunov", "Laki-laki");
//
//        Person linda = new Person("Lindawati", "Susanti","Ria", "Perempuan");
//
//        System.out.println(alex.getGender());
//        System.out.println(linda.getGender());


        //------------------------------------------------------------------------------


//        Product cocaCola = new Product("Coca-Cola", 5000.0, 23);
//        Product snack = new Product("Cheetos", 3000.0, 15);
//        Product makanan = new Product("Krupuk", 2500.0, 30);
//
//        LinkedList<Product> listProduct = new LinkedList<>();
//        listProduct.add(cocaCola);
//        listProduct.add(snack);
//        listProduct.add(makanan);
//
//        double hargaCocaCola = cocaCola.getHarga();
//        double hargaSnack = snack.getHarga();
//        double hargaMakanan = makanan.getHarga();
//        System.out.println("Total Harga : " + (hargaCocaCola+hargaMakanan+hargaSnack));
//
//        double hargaProduct = 0;
//        int jumlahStock = 0;
//
//
//        for ( Product dataProduct : listProduct){
////            System.out.println(dataProduct.getHarga());
//            hargaProduct = dataProduct.getHarga();
//            jumlahStock = dataProduct.getStock();
//            System.out.println("Total :" + (hargaProduct * jumlahStock));
//        }



        //------------------------------------------------------------------------------

//
//        LinkedList<String> avatarActor= new LinkedList<>();
//        avatarActor.add("Al");
//        avatarActor.add("Ihsan");
//        avatarActor.add("Putra");
//
//        Movie avatar = new Movie("avatar","Alvenio",180, avatarActor);
//


        //------------------------------------------------------------------------------


//        Movie titanic = new Movie("");


        //------------------------------------------------------------------------------



    }


    public static void getEmployeesFromLinkedList(LinkedList<Employee> incomingEmployee, HashMap<String, Employee> globalEmployee){
        for ( Employee dataEmployee : incomingEmployee){
                globalEmployee.put(dataEmployee.getNumber(), dataEmployee);
        }

    }
}