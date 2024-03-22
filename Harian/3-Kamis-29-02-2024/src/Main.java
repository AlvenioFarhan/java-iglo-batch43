import java.util.Scanner;

public class Main {

    /*
    * Sub Routine / Function / Method
    * */

    /*
    * Bagian" Method :
    * 1. Access Modifier : public, private, protected, default(hutang di OOP)
    * 2. Static status : static dan non-static (hutang di OOP)
    * 3. Return Daya-Type : void, int, double, dll ...
    * 4. Method name : penamaan bebas seperti printHelloWorld
    * 5. Parameter Braket : ()
    * 6. Parameter : String name
    * 7. Argument : atau isinya seperti "Alvenio" (case printHaloSeseorang)
    * 8. Method Body :  / isi Method; {// isi}
    * 9. Method Signature : (gabungan dari nama dan deret tipe data parameternya)
    * 10. Return : return hasil
    * */

    /*
    * Jump Statement :
    *
    * Break
    * continue
    * go
    * return
    * */

    public static void printHelloWorld(){
        System.out.println("Hello world!");
        System.out.println("Hello Everyone");
    }

    //------------------------------------------------------------------------

    public static void printHaloSeseorang(String nama){
        System.out.printf("Halo %s\n", nama);
    }

    //------------------------------------------------------------------------

    public static void printAngka(long inputNumber){
        System.out.printf("Angka diprint: %s\n", inputNumber);
    }

    //-----------------------------------------------------------------------

    public static void printKataDanAngka(String kata, Integer angka, Double angkaDesimal, Integer angkaKedua){
        kata = "UPDATED";
        System.out.printf("Kata: %s, Angka: %s, Angka Desimal: %s\n",kata, angka, angkaKedua, angkaDesimal);
    }

    //---------------------------------------------------------------------------

    public static void printHello(){
        System.out.println("Hello 1");
    }

    //Overloading
    //signature : printHello(int)
    public static void printHello(int angka){
        System.out.println("Hello 2");
    }

    //signature : printHello(String)
    public static void printHello(String kata){
        System.out.println("Hello 3");
    }

    //signature : printHello(int, String)
    public static void printHello(int angka, String kata){
        System.out.println("Hello 4");
    }

    //signature : printHello(String, int)
    public static void printHello(String kata,int angka){
        System.out.println("Hello 5");
    }


    //------------------------------------------------------------------------------------
    //RETURN
    public static int mendapatkanPenjumlahan(int angkaPertama, int angkaKedua){
        int hasil = angkaPertama + angkaKedua;
        return hasil;
    }

    public static void printPenjumlahan(int angkaPertama, int angkaKedua){
        int hasil = angkaPertama + angkaKedua;
        System.out.println(hasil);
    }


    //-----------------------------------------------------------------------------
    //
    public static Integer checkList(Integer number, int numberTwo){
        if (number != null){
            System.out.printf("ADA ISINYA! %s\n", number);
            return number + numberTwo;
        }
        return  numberTwo * 2;
    }

    //---------------------------------------------------------------------------------

    public static void methodKeempat(){
        System.out.println("Method 4 Mulai");
        System.out.println("Method 4 Selesai");
    }

    public static void methodKetiga(){
        System.out.println("Method 3 Mulai");
        System.out.println("Method 3 Selesai");
    }

    public static void methodKedua(){
        System.out.println("Method 2 Mulai");
        methodKetiga();
        System.out.println("Method 2 Selesai");
    }

    public static void methodPertama(){
        System.out.println("Method 1 Mulai");
        methodKedua();
        System.out.println("Method 1 Selesai");
    }

    //---------------------------------------------------------------------------------

    //Stack Overflow Error
    //Tidak bisa di try catch/ Exception
    public static void looping(int index){
        if (index >= 0){
            System.out.println(index);
            looping(++index);
        }

    }


    //---------------------------------------------------------------------------------


    //DRY Don't Repeat Yourself
    public static Integer validateInteger(Scanner scanner, Integer maxNumber, String message){
        try{
            System.out.println(message);
            Integer input = Integer.parseInt(scanner.nextLine());
            if(input >= 1 && input <= maxNumber){
                return input;
            } else {
                System.out.printf("Input harus dari 1 - %s\n", maxNumber);
                return validateInteger(scanner, maxNumber, message);
            }
        }catch (Exception exception){
            System.out.println("Input harus berupa bilang bulat");
            return validateInteger(scanner, maxNumber, message);
        }
    }

    //MAIN FUNCTION (UTAMA)
    public static void main(String[] args) {
        //call method / Invoke Method
//        printHelloWorld();
//        System.out.println("Jalankan main");

//----------------------------------------------------------------------------

//        printHaloSeseorang("Alvenio");
//
//        String contohNama = "John";
//        printHaloSeseorang(contohNama);

        //----------------------------------------------------------------------
//
//        int contohNumber = 56;
//        printAngka(contohNumber);

        //---------------------------------------------------------------------
//
//        printKataDanAngka("Test Drive", 56, 34.6, 78);

        //-------------------------------------------------------------------


//        printHello(7,"Test");

        //---------------------------------------------------------------------


//        printPenjumlahan(4,6);

//        int hasilJumlah = mendapatkanPenjumlahan(10,5);
//        System.out.println(hasilJumlah * 2);

        //-------------------------------------------------------------------------------

//        int hasil = checkList(null, 5);
//        System.out.println(hasil);

        //-------------------------------------------------------------------------------

//        methodPertama();

        //-------------------------------------------------------------------------------

        //Stack Overflow Error
//        int index = 0;
//        looping(index );

        //-------------------------------------------------------------------------------

        Scanner scanner = new Scanner(System.in);
        Integer hasil = validateInteger(scanner, 12, "Masukan bulan:");
        System.out.printf("Hasilnya: %s\n", hasil);


    }
}