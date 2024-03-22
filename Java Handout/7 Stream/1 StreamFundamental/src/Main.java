import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    /*
        Stream sering disalah artikan oleh beberapa developer sebagai collection, stream bukanlah object collection,
            stream adalah object yang digunakan untuk memproses sebuah collection. Stream adalah sebuah aliran data yang
            biasa digunakan untuk menambahkan proses seperti query setelah data masuk ke dalam object model.

        Stream merupakan feature yang berasal dari java.util.stream library.
    */
    public static void main(String[] args) {
        initiatingStream();
        collectionStream();
        emptyStream();
        streamBuilder();
        chainBuilder();
        streamIsCold();
        streamMap();
        streamPipeline();
        flatMap();
        filter();
        distinct();
        limit();
        skip();
        takeWhile();
        dropWhile();
        findAny();
        findFirst();
        sorting();
        maxAndMin();
        count();
        reduce();
        anyMatch();
        noneMatch();
        generate();
        iterate();
        peek();
        collect();
        immutableList();
        toMap();
        groupingBy();

    }

    /*Kita bisa menginisialisasi stream dengan tipe data apa saja langsung dengan menggunakan method of.*/
    public static void initiatingStream(){
        System.out.println("==================initiatingStream()==================");

        Stream<String> stream = Stream.of("Satu", "Dua", "Tiga");
        stream.forEach((angka) -> {
            System.out.println(angka);
        });
    }

    /*Kita juga bisa merubah sebuah collection menjadi stream*/
    public static void collectionStream(){
        System.out.println("==================collectionStream()==================");

        String[] arrayString = new String[]{"Satu", "Dua", "Tiga"};
        Stream<String> streamArray = Arrays.stream(arrayString);
        streamArray.forEach(each -> System.out.println(each));

        List<Integer> numbers = List.of(23, 45, 67);
        Stream<Integer> streamOfInteger = numbers.stream();
        streamOfInteger.forEach(each -> System.out.println(each));
    }

    /*Kita bisa menciptakan stream kosong dengan Stream.empty().
      Empty stream biasa digunakan untuk menghindari null pointer apabila value dari stream hanya di set pada kondisi tertentu saja.
      Sehingga kita bisa memanfaatkannya pada saat inisialisasi.*/
    public static void emptyStream(){
        System.out.println("==================emptyStream()==================");

        Stream<String> emptyStream = Stream.empty();
        emptyStream.forEach(System.out::println); //tidak akan error
    }

    /*Sebagai alternative, kita juga bisa membuat stream dengan Builder class dan builder method*/
    public static void streamBuilder(){
        System.out.println("==================streamBuilder()==================");

        Stream.Builder<String> builder = Stream.builder();
        builder.accept("Satu");
        builder.accept("Dua");
        builder.accept("Tiga");
        Stream<String> builded = builder.build();
        builded.forEach(System.out::println);
    }

    /*Ketimbang menggunakan accept method, kita juga bisa menggunakan add method pada string builder.
        Lain dengan accept yang me-return void, add method akan me-return stream builder object, sehingga kita bisa chain methodnya.*/
    public static void chainBuilder(){
        System.out.println("==================chainBuilder()==================");

        Stream.Builder<String> builder = Stream.builder();
        builder.add("Satu").add("Dua").add("Tiga");
        Stream<String> builded = builder.build();
        builded.forEach(System.out::println);
    }

    /* Setiap stream bersifat cold, artinya hanya bisa dijalankan oleh terminal operation satu kali.
   Mehtod foreach yang sebelumnya kita gunakan adalah contoh dari terminal operation.*/
    public static void streamIsCold(){
        System.out.println("==================streamIsCold()==================");

        String[] arrayString = new String[]{"Satu", "Dua", "Tiga"};
        Stream<String> streamArray = Arrays.stream(arrayString);
        streamArray.forEach(each -> System.out.println(each));
        try{
            streamArray.forEach(each -> System.out.println(each));
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    /*
        Method yang digunakan pada operasi stream dibedakan menjadi 2 macam, yaitu:

        1. Terminal Operation: atau operation pemberhentian akhir adalah method yang bisa digunakan pada stream, dimana
            method tersebut bersifat void atau me-return suatu tipe data yang bukan Stream<>.
            Sebuah stream yang menjalankan terminal operation akan langsung bersifat cold. Seperti yang sudah dijelaskan sebelumnya
            sebuah stream yang bersifat cold artinya arusnya sudah sampai ke pemberhentian terakhir dan tidak bisa lagi diproses oleh mehod
            atau operation apa pun.

        2. Intermediate Operation: atau operasi transit adalah method yang digunakan pada stream sebelum terminal operation.
            Method intermediate akan selalu mengembalikan tipe data Stream<T>, dan hasil stream dari method ini akan bisa di chain dengan
            method-method intermediate lainnya secara berurutan, sebelum pada akhirnya berhenti di terminal operation method.
    */

    /* map adalah salah satu contoh intermidate operation method pada stream.
        Parameter pada map akan menerima functional interface yang meneruskan satu parameter sesuai dengan tipe data generic pada stream,
        dan mengembalikan satu nilai yang memiliki tipe data yang sama.*/
    public static void streamMap(){
        System.out.println("==================streamMap()==================");

        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        Stream<Integer> originals = numbers.stream();
        Stream<Integer> triples = originals.map(number -> number * 3);
        triples.forEach(System.out::println);

        Stream<Double> decimalStream = List.of(1.5, 2.5, 3.5).stream();
        System.out.println("Sebelum doubled");
        Stream<Double> doubled = decimalStream.map(decimal -> {
            double multiplied = 2 * decimal;
            System.out.printf("(1) Hasilnya: %s\n", multiplied); //Baru di print di foreach
            return multiplied;
        });
        System.out.println("Setelah doubled - Sebelum addThree");
        Stream<Double> addThree = doubled.map(decimal -> {
           double added = decimal + 3;
           System.out.printf("(2) Hasilnya: %s\n", added); //Baru di print di foreach
           return added;
        });
        System.out.println("Setelah addThree");
        addThree.forEach(System.out::println); //Hasil diproses satu persatu untuk setiap variable atau object di dalam stream.
    }

    //Kumpulan dari beberapa intermediate dan satu terminal operation disebut juga sebagai Stream pipeline.
    public static void streamPipeline(){
        System.out.println("==================streamPipeline()==================");

        List.of("Alex", "Ben", "Aldo").stream()
            .map(name -> name.toUpperCase())
            .map(upper -> "Mr, " + upper)
            .forEach(nameWithTitle -> System.out.println(nameWithTitle));
    }

    /*
        Di sini kita akan melihat beberapa contoh operasi-operasi method pada stream lainnya.
        Setiap operation dibagi menjadi 2 jenis berdasarkan pipelinenya: Intermediate atau Terminal
        dan setiap operation dibagi menjadi beberapa category berdasarkan kegunaan atau sifatnya.

        Beberapa kategory operation yang akan dibahas di sini adalah:

        Transformation operation: method yang digunakan untuk melakukan perubahan terhadap data di dalam stream.
            Map merupakan salah satu contoh transformation operation.

        Filtering operation: method yang digunakan untuk melakukan penyaringan data, sehingga stream bisa melakukan
            operasi pembanding untuk memilih data mana yang akan diambil. Sama seperti where pada query.

        Retrieving operation: method ini sebenarnya hampir mirip dengan filter, tetapi tidak menyaring berdasarkan
            operasi pembanding, melainkan dengan batasan scope. Sama seperti top, fetch dan offset pada query.

        Ordering operation: method yang digunakan untuk melakukan sorting pada hasil data stream.

        Aggregate operation: method yang digunakan untuk melakukan perhitungan aggregate operation dalam satu kelompok.
            Sama seperti count, avg, sum pada query.

        Check operation: method yang mengembalikan boolean value yang menyimpulkan kondisi seluruh isi data pada stream.

        Inifinite operation: Sebuah operation yang terus akan melakukan looping dan hanya bisa dihentikan oleh operasi lain pada
            pipeline.

        Collector operation: adalah operation yang digunakan untuk membentuk kembali stream menjadi collection.
    */

    /*
    * flatMap:method ini hampir sama dengan method map, hanya saya parameter function interface dari fungsi ini
    *   mengharapkan tipe data Stream untuk di return.
    *
    * Jenis di pipeline: Intermediate Operation
    * Kategori: Transformation Operation
    * */
    public static void flatMap(){
        System.out.println("==================flatMap()==================");

        List.of("a", "b", "c").stream()
            .flatMap(word -> {
               return Stream.of(word.toUpperCase());
            }).forEach(System.out::println);

        List.of("d", "e", "f").stream()
            .flatMap(word -> {
                String upper = word.toUpperCase();
                return Stream.of(upper + "1", upper + "2", upper + "3");
            }).forEach(System.out::println);
    }

    /*
    * filter: filter method digunakan untuk mengembalikan data yang lolos pada kriteria filter saja.
    *   Parameter pada filter mengharapkan functional interface yang mengembalikan boolean.
    *   True untuk lolos filter dan false untuk yang tidak lolos.
    *
    * Jenis di pipeline: Intermediate Operation
    * Kategori: Filtering Operation
    * */
    public static void filter(){
        System.out.println("==================filter()==================");

        List.of(45, 4, 7, 12, 89, 64).stream()
                .filter(number -> number < 10)
                .forEach(System.out::println);

        getProducts().stream()
            .filter(product -> {
                boolean lolos = product.getPrice() > 100000.0 || product.getCategoryId() == 2;
                return lolos;
            }).forEach(product -> System.out.println(product.toString()));
    }

    /*
     * distinct: method distinct sama seperti distinct pada sql, yaitu tidak mengambil data dengan value yang sama.
     *  method distinct tidak mengharapkan parameter apapun.
     *
     * Jenis di pipeline: Intermediate Operation
     * Kategori: Filtering Operation
     * */
    public static void distinct(){
        System.out.println("==================distinct()==================");

        List.of("Satu", "Tiga", "Satu", "Empat", "Dua", "Dua").stream()
                .distinct().forEach(System.out::println);
    }

    /*
     * limit: method yang mengembalikan banyaknya data sesuai dengan parameter integer.
     *  limit sama seperti TOP pada sql.
     *
     * Jenis di pipeline: Intermediate Operation
     * Kategori: Retrieving Operation
     * */
    public static void limit(){
        System.out.println("==================limit()==================");

        Stream<String> data = List.of("Satu", "Dua", "Tiga", "Empat", "Lima", "Enam", "Tujuh", "Delapan").stream();
        data.limit(3).forEach(System.out::println);
    }

    /*
     * skip: hampir sama seperti offset, yaitu melewati banyaknya data untuk di proses.
     *
     * Jenis di pipeline: Intermediate Operation
     * Kategori: Retrieving Operation
     * */
    public static void skip(){
        System.out.println("==================skip()==================");

        Stream<String> data = List.of("Satu", "Dua", "Tiga", "Empat", "Lima", "Enam", "Tujuh", "Delapan").stream();
        data.skip(3).forEach(System.out::println);

        //Dengan melakukan kombinasi skip dan limit, kita bisa membuat pagination system.
        System.out.println("==Pagination==");
        Stream<String> data2 = List.of("Satu", "Dua", "Tiga", "Empat", "Lima", "Enam", "Tujuh", "Delapan").stream();
        data2.skip(3).limit(3).forEach(System.out::println);
    }

    /*
     * takeWhile: walaupun takeWhile tergolong kedalam retrieving operation, takeWhile sifatnya
     * mirip seperti filter. takeWhile memiliki parameter berupa functional interface yang mengembalikan boolean.
     * Hanya saja proses masih terus dilakukan selama kondisi masih terus, ketika sudah false, stream akan berhenti.
     *
     * Jenis di pipeline: Intermediate Operation
     * Kategori: Retrieving Operation
     * */
    public static void takeWhile(){
        System.out.println("==================takeWhile()==================");

        Stream<Integer> data = List.of(1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3).stream();
        data.takeWhile(number -> number < 5).forEach(System.out::println);

        Stream<Integer> dataTwo = List.of(1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3).stream();
        dataTwo.takeWhile(number -> {
            int hasil = number * 2;
            return hasil <= 10;
        }).forEach(System.out::println);
    }

    /*
     * dropWhile: method ini bekerja sangat terbalik dengan takeWhile.
     * Yang pertama dropWhile akan mengambil data dimana method dropWhile akan mengembalikan nilai false.
     * Yang kedua dropWhile tidak akan berhenti hanya karena nilai returnya false atau true.
     *
     * Jenis di pipeline: Intermediate Operation
     * Kategori: Retrieving Operation
     * */
    public static void dropWhile(){
        System.out.println("==================dropWhile()==================");

        Stream<Integer> data = List.of(1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3, 4, 5, 6, 7).stream();
        data.dropWhile(number -> number < 5).forEach(System.out::println);
    }

    /*
     * findAny: digunakan untuk mengetahui apakah setidaknya ada satu value di dalamnya.
     * findAny cukup unik, karena mengembalikan Optional value.
     * Note: findAny seharusnya mengambil value random dari stream yang ada, tetapi pada kenyataanya akan selalu mengambil value yang pertama
     * karena itu merupakan value yang paling cepat untuk diambil.
     *
     * Jenis di pipeline: Terminal Operation
     * Kategori: Retrieving Operation
     * */
    public static void findAny(){
        System.out.println("==================findAny()==================");

        Stream<String> data = List.of("Satu", "Dua", "Tiga", "Empat", "Lima", "Enam", "Tujuh", "Delapan").stream();
        Optional<String> result = data.findAny();
        System.out.println(result.isPresent());
        System.out.println(result.get());

        Stream<String> dataTwo = Stream.empty();
        Optional<String> resultTwo = dataTwo.findAny();
        System.out.println(resultTwo.isPresent());
    }

    /*
     * findFirst: Karena findAny selalu mengembalikan value pertama dari stream, jadi pada kasus ini
     * findFirst tidak memiliki beda sama sekali dengan findAny.
     *
     * Jenis di pipeline: Terminal Operation
     * Kategori: Retrieving Operation
     * */
    public static void findFirst(){
        System.out.println("==================findFirst()==================");

        Stream<String> data = List.of("Satu", "Dua", "Tiga", "Empat", "Lima", "Enam", "Tujuh", "Delapan").stream();
        Optional<String> result = data.findFirst();
        System.out.println(result.get());
        result.ifPresent(System.out::println);
    }

    /*
     * sorting: method yang melakukan sorting secara ascending atau descending.
     *
     * Jenis di pipeline: Intermediate Operation
     * Kategori: Ordering Operation
     * */
    public static void sorting(){
        System.out.println("==================sorting()==================");

        Stream<String> data = List.of("Satu", "Dua", "Tiga", "Empat", "Lima", "Enam", "Tujuh", "Delapan").stream();
        data.sorted().forEach(System.out::println);

        System.out.println("==Reverse==");

        Stream<Integer> data2 = List.of(9, 2, 6, 1, 3, 5).stream();
        data2.sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }

    /*
     * max dan min: aggregate untuk mencari yang terbesar atau yang terkecil dari kumpulan value.
     *
     * Jenis di pipeline: Terminal Operation
     * Kategori: Aggregate Operation
     * */
    public static void maxAndMin(){
        System.out.println("==================maxAndMin()==================");

        var data = List.of(1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3);

        //Comparator.naturalOrder() adalah ascending dimana semua akan berjalan normal bila menggunakannya.
        Stream<Integer> streamOne = data.stream();
        Optional<Integer> maximum = streamOne.max(Comparator.naturalOrder());
        maximum.ifPresent(System.out::println);

        Stream<Integer> streamTwo = data.stream();
        Optional<Integer> minimum = streamTwo.min(Comparator.naturalOrder());
        minimum.ifPresent(System.out::println);

        //Comparator.reverseOrder() akan membuat max jadi min dan min jadi max
        Stream<Integer> streamThree = data.stream();
        Optional<Integer> maximumReversed = streamThree.max(Comparator.reverseOrder());
        maximumReversed.ifPresent(System.out::println);
    }

    /*
     * count: sama dengan sql, count digunakan untuk menghitung jumlah value di dalam stream
     *
     * Jenis di pipeline: Terminal Operation
     * Kategori: Aggregate Operation
     * */
    public static void count(){
        System.out.println("==================count()==================");

        Stream<String> data = List.of("Ali", "Melissa", "Ryan").stream();
        Long jumlah = data.count(); //ascending
        System.out.println(jumlah);
    }

    /*
     * reduce: adalah method aggregation yang body dari functional interfacenya bisa di custom sesuai dengan keinginan developer.
     *  Karena java stream tidak menyediakan macam-macam aggregate function seperti sum, average, dll,
     *  jadinya stream menyediakan reduce agar kita bisa membuatnya sendiri
     *
     * Jenis di pipeline: Terminal Operation
     * Kategori: Aggregate Operation
     * */
    public static void reduce(){
        System.out.println("==================reduce()==================");

        System.out.println("==Sum==");
        Stream<Integer> streamOne = List.of(100, 70, 30, 200).stream();
        Integer sum = streamOne.reduce(0, (result, number) -> result + number);
        System.out.println(sum);

        System.out.println("==Average==");
        List<Double> data = List.of(100.0, 70.0, 30.0, 200.0);
        Stream<Double> streamTwo = data.stream();
        Double average = streamTwo.reduce(0.0, (result, number) -> result + (number / data.size()));
        System.out.println(average);
    }

    /*
     * anyMatch: method yang mengembalikan true apabila ada setidaknya satu bagian dari stream memenuhi kriteria.
     *  Parameter dari anyMatch juga merupakan functional interface yang mengembalikan boolean.
     *
     * Jenis di pipeline: Terminal Operation
     * Kategori: Check Operation
     * */
    public static void anyMatch(){
        System.out.println("==================anyMatch()==================");
        Stream<Product> streamOne = getProducts().stream();
        boolean anyPrice = streamOne.anyMatch(product -> product.getPrice() == 5000);
        System.out.println(anyPrice);

        Stream<Product> streamTwo = getProducts().stream();
        boolean anyCategory = streamTwo.anyMatch(product -> product.getCategoryId() == 5);
        System.out.println(anyCategory);
    }

    /*
     * allMatch: all match digunakan untuk memastikan bahwa seluruh component di dalam stream memenuhi syarat,
     *  bila tidak, false adalah nilai yang akan dikembalikan method ini.
     *
     * Jenis di pipeline: Terminal Operation
     * Kategori: Check Operation
     * */
    public static void allMatch(){
        System.out.println("==================allMatch()==================");

        Stream<Product> streamOne = getProducts().stream();
        boolean allPrice = streamOne.allMatch(product -> product.getPrice() > 1000);
        System.out.println(allPrice);

        Stream<Product> streamTwo = getProducts().stream();
        boolean allCategory = streamTwo.allMatch(product -> product.getCategoryId() > 1);
        System.out.println(allCategory);
    }

    /*
     * noneMatch: none match memastikan bahwa seluruh component di dalam stream tidak ada yang memenuhi kriteria.
     *
     * Jenis di pipeline: Terminal Operation
     * Kategori: Check Operation
     * */
    public static void noneMatch(){
        System.out.println("==================noneMatch()==================");

        Stream<Product> streamOne = getProducts().stream();
        boolean nonePrice = streamOne.noneMatch(product -> product.getPrice() > 8000000);
        System.out.println(nonePrice);

        Stream<Product> streamTwo = getProducts().stream();
        boolean noneCategory = streamTwo.noneMatch(product -> product.getCategoryId() == 2);
        System.out.println(noneCategory);
    }

    /*
     * generate: method yang digunakan mengenerate value secara infinite.
     *  parameter pada generate adalah functional interface yang tidak memiliki parameter dan me-return tipe data apa saja. (return typenya generic)
     *
     * Jenis di pipeline: Intermediate Operation
     * Kategori: Infinite Operation
     * */
    public static void generate(){
        System.out.println("==================generate()==================");

        Stream.generate(() -> {
            return "Repeat";
        }).limit(5) //bila tidak ada limit, maka akan infinite loop
        .forEach(System.out::println);
    }

    /*
     * iterate adalah method infinite operation pada stream yang bisa digunakan sebagai pengganti iteration seperti
     * for loop, dikarenakan parameter pada iterate adalah method yang menerima 2 parameter, yaitu seed nilai pertama
     * dan functional interface yang menerima parameter return sebelumnya.
     *
     * Jenis di pipeline: Intermediate Operation
     * Kategori: Infinite Operation
     * */
    public static void iterate(){
        System.out.println("==================iterate()==================");

        Stream.iterate(1, value -> value + 1)
            .takeWhile(number -> number < 10) //infinite tanpa takeWhile
            .forEach(System.out::println);
    }

    /*
     * peek adalah versi intermediate (non-terminal) dari forEach.
     *  Sama seperti forEach, peek me-return void, sehingga method selanjutnya dari pipeline tidak akan menerima perubahan
     *  apapun yang dilakukan oleh peek. Oleh karena itu peek tidak masuk ke dalam kategori manapun.
     *
     * Jenis di pipeline: Intermediate Operation
     * Kategori: ?
     * */
    public static void peek(){
        System.out.println("==================peek()==================");

        Stream<String> names = List.of("alex", "surya", "ben").stream();
        names.peek(name -> {
            name = name.toUpperCase();
            System.out.println(name);
        }).forEach(System.out::println);
    }

    /*
     * collect: digunakan untuk mengembalikan stream kembali ke dalam collection.
     *  contoh dibawah membuat stream menjadi list.
     *
     * Jenis di pipeline: Terminal Operation
     * Kategori: Collector Operation
     * */
    public static void collect(){
        System.out.println("==================collect()==================");

        Stream<String> data = List.of("Satu", "Dua", "Tiga").stream();
        List<String> dataResult = data.map(word -> word.toUpperCase()).collect(Collectors.toList());
    }

    //Dengan menggunakan parameter Collectors.toUnmodifiableList(), hasil list bersifat immutable, atau tidak bisa di set sama sekali valuenya.
    public static void immutableList(){
        System.out.println("==================immutableList()==================");

        Stream<String> data = List.of("Satu", "Dua", "Tiga").stream();
        List<String> dataResult = data.map(word -> word.toUpperCase()).collect(Collectors.toUnmodifiableList());
        try{
            dataResult.add("Empat");
        }catch (Exception exception){
            System.out.println("Terkena exception karena immutable");
        }
        for (var datum : dataResult) {
            System.out.println(datum);
        }
    }

    /*
    * Selain ke list, kita juga bisa memetakan stream ke dalam map.
    * */
    public static void toMap(){
        System.out.println("==================toMap()==================");

        Stream<Product> data = getProducts().stream();
        Map<Long, Product> results = data.collect(Collectors.toMap(value -> value.getId(), value -> value));

        for(Map.Entry<Long, Product> entry : results.entrySet()){
            System.out.println(entry.getKey() + ":" + entry.getValue().getName());
        }
    }

    /*
    * groupingBy adalah method yang bisa digunakan untuk melakukan pemisahaan collection dalam
    * group pada method collect.
    * */
    public static void groupingBy(){
        System.out.println("==================groupingBy()==================");

        Stream<Product> dataStream = getProducts().stream();
        Map<Integer, List<Product>> groupMap = dataStream.collect(Collectors.groupingBy(product -> {
            return product.getCategoryId();
        }));
        for (var entry : groupMap.entrySet()) {
            System.out.printf("Category ID: %s\n", entry.getKey());
            for (Product product: entry.getValue()) {
                System.out.println(product.toString());
            }
        }

        System.out.println("==Angka==");
        Stream<Integer> numberStream = List.of(1, 2, 3, 4, 5, 6, 7, 8).stream();
        Map<String, List<Integer>> numberGroup = numberStream.collect(Collectors.groupingBy(number ->{
            if(number > 4){
                return "Besar";
            } else {
                return "Kecil";
            }
        }));
        for (var entry : numberGroup.entrySet()) {
            System.out.printf("Group: %s\n", entry.getKey());
            for (Integer angka: entry.getValue()) {
                System.out.println(angka);
            }
        }
    }

    private static List<Product> getProducts(){
        return List.of(
            new Product(1l, "Chitato", 1, 6000.0),
            new Product(2l, "Kacang", 1, 10000.0),
            new Product(3l, "Coca cola", 2, 5000.0),
            new Product(4l, "Handphone", 3, 3000000.0),
            new Product(5l, "Monitor", 3, 1000000.0)
        );
    }
}