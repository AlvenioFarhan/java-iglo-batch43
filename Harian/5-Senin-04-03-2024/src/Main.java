import java.util.*;

public class Main {
    public static void main(String[] args) {


        //Stop / Berhenti Ditengah" Code
//        System.out.println("Test 1");
//        System.exit(0); // menggunakan System.exit()
//        System.out.println("Test 2");
//        System.out.println("Test 3");

        //---------------------------------------------------------------------------------------

        //Lanjutan Jumat
        //Link List

//        LinkedList<String> candidates = new LinkedList<String>(Arrays.asList("Edwin", "Julian", "Febby"));
//        candidates.add("Rio");
//        candidates.add("Boby");
//        candidates.add("Vina");
//
//        LinkedList<String> tambahanPeople = new LinkedList<>();
//        tambahanPeople.add("John Doe");
//        tambahanPeople.add("Jane Doe");
//
//        candidates.addAll(tambahanPeople);
//
//        System.out.println(candidates.size());
//
//        for(String candidate : candidates) {
//            System.out.println(candidate);
//        };

        //---------------------------------------------------------------------------------------

        //Hash Map

//        HashMap<Integer, String> candidates = new HashMap<>();
//        candidates.put(12, "Boby");
//        candidates.put(44, "Rully");
//        candidates.put(97, "Stanlly");

//        System.out.println(candidates.get(44));

//        for ( String candidateName : candidates.values()){
//            System.out.println(candidateName);
//        };
//
//        for ( Integer candidateNumber : candidates.keySet()){
//            System.out.println(candidateNumber);
//        };
//
//        // var = Map.Entry<Integer, String>
//        for (Map.Entry<Integer, String> candidate : candidates.entrySet()){
//            System.out.printf("Key : %s, Value: %s\n", candidate.getKey(), candidate.getValue());
//        };
//
//        HashMap<String, String> countries = new HashMap<>();
//        countries.put("ID", "Indonesia");
//        countries.put("US", "United States of America"); countries.put("JP", "Japan");
//
//        System.out.println(countries.get("JP"));

        //---------------------------------------------------------------------------------------

        /*
        * Buat fungsi yang bisa mengembalikan jawaban berupa iya/ tidak
        * fungsi ini digunakan untuk mencari apakah ada 1 string yang di terima argument
        * di dalam LinkList<String> di dalam argument keduanya.
        *
        * contoh LinkList<String> berisi Mangga, Apel, Jeruk, Melon
        * maka output  dari fungsi  adalah true
        *
        * kalau contoh String yang dicari Salak
        * maka output dari fungsi adalah false
        * */

//        Scanner scanner = new Scanner(System.in);
//
//        LinkedList<String> listData = new LinkedList<>();
//        listData.add("Apel");
//        listData.add("Mangga");
//        listData.add("Jeruk");
//        listData.add("Melon");
//
//        Boolean hasil = Tester("Mangga", listData);
//        System.out.println(hasil);

        //---------------------------------------------------------------------------------------

        /*
        * Minuman : Coca-cola, Fanta, Sprite, Teh Botol, ...
        * Snack : Taro, Chicki, Cheetos, ...
        * Buah : Mangga, Sirsak, Melon, ...
        *
        * buat 2 function terpisah :
        * function 1 : masukkan kategory key dan seluruh data supermarketnya, dikembalikan seluruh isi produknya,
        *               sesuai dengan categorynya.
        * function 2 : menerima deret nama produk lalu print seluruh nama produk, plus di akhirnya
        *               menceritakan jumlah macam produk.
        * function 3 : menambah data, parameter : data supermarket, category, deret produknya
        * */

        Scanner scanner = new Scanner(System.in);

        LinkedList<String> minuman = new LinkedList<>();
        minuman.add("Coca-cola");
        minuman.add("Fanta");
        minuman.add("Sprite");
        minuman.add("Teh Botol");

        LinkedList<String> snack = new LinkedList<>();
        snack.add("Taro");
        snack.add("Chicki");
        snack.add("Cheetos");

        LinkedList<String> buah = new LinkedList<>();
        buah.add("Apel");
        buah.add("Mangga");
        buah.add("Jeruk");
        buah.add("Melon");

        LinkedList<String> listMakanan = new LinkedList<>();
        listMakanan.add("Seblak");
        listMakanan.add("Ayam Goreng");
        listMakanan.add("Nasgor");

        HashMap<String, LinkedList<String>> dataBarang = new HashMap<>();

        addProductSupermarket("Makanan", listMakanan, dataBarang);
        System.out.println(dataBarang);


    }

    //function 1
    public static ArrayList<String> getProductbyCategory(String category, HashMap<String, ArrayList<String>> dataSupermarket){

        ArrayList<String> listProduct = dataSupermarket.get(category);

        return listProduct;
    }

    //function 2
    public static void printNamaProduk(ArrayList<String> products){
        System.out.println("Daftar Produk Supermarket :");
        for ( String product : products) {
            System.out.println(product);
        }
        System.out.println("Total Jumlah Produk: " + products.size());
    }

    //function 3
    public static void addProductSupermarket(String key, LinkedList<String> category, HashMap<String, LinkedList<String>> listProduct){

        listProduct.put(key, category);

    }


    public static Boolean Tester (String nama, LinkedList<String> list){
        for (String namaData : list){
        if (nama.equals(namaData)) {
            System.out.println("Data ada di dalam list");
            return true;
            }
        }
        System.out.println("data tidak ada di dalam list");
        return false;
    }
}