import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Asuransi {
    private Prospect prospect;
    private static Map<String, Product> products = new HashMap<>();
    private static  Map<Integer, Prospect> prospects = new HashMap<>();
    private static  Map<String, Nasabah> banyakNasabah = new HashMap<>();

    //DataProduct
    public static void initializeDataProduct() {
        Product productSH = new Product("Sehat Bersama", JenisProduk.KH, FrekuensiPembayaran.B, "Claim perawatan kelas 1.", "Bisa menanggung keluarga atau diri sendiri dari data nasabah.");
        IuranProduk iuranProdukSHA = new IuranProduk(productSH, 0, 20, 200_000D);
        IuranProduk iuranProdukSHB = new IuranProduk(productSH, 21, 999, 400_000D);
        List<IuranProduk> iuranproductSH = new ArrayList<>();
        iuranproductSH.add(iuranProdukSHA);
        iuranproductSH.add(iuranProdukSHB);
        productSH.setIuranProduks(iuranproductSH);
        products.put("Sehat Bersama", productSH);

        Product productSE = new Product("Sehat Extra", JenisProduk.KH, FrekuensiPembayaran.B, "Claim perawatan kelas VIP.", "Hanya bisa menanggung diri sendiri.");
        IuranProduk iuranProdukSBA = new IuranProduk(productSE, 0, 20, 300_000D);
        IuranProduk iuranProdukSBB = new IuranProduk(productSE, 21, 999, 500_000D);
        List<IuranProduk> iuranproductSB = new ArrayList<>();
        iuranproductSB.add(iuranProdukSBA);
        iuranproductSB.add(iuranProdukSBB);
        productSE.setIuranProduks(iuranproductSB);
        products.put("Sehat Extra", productSE);

        Product productLK = new Product("Life Keluarga", JenisProduk.JW, FrekuensiPembayaran.B, "Mendapatkan 500.000.000 apabila terjadi sesuatu pada tertanggung.", "Bisa menanggung keluarga atau dirisendiri dari datanasabah.");
        List<IuranProduk> iuranProduksLK = new ArrayList<>();
        productLK.setIuranProduks(iuranProduksLK);
        products.put("Life Keluarga", productLK);

        Product productLS = new Product("Life Special", JenisProduk.JW, FrekuensiPembayaran.T, "Mendapatkan 800.000.000 apabila terjadi sesuatu pada tertanggung.", "Hanya bisa menanggung diri sendiri.");
        IuranProduk iuranProdukLKA = new IuranProduk(productSE, 0, 20, 250_000D);
        IuranProduk iuranProdukLKB = new IuranProduk(productSE, 21, 999, 450_000D);
        List<IuranProduk> iuranProductLS = new ArrayList<>();
        iuranProductLS.add(iuranProdukLKA);
        iuranProductLS.add(iuranProdukLKB);
        productLS.setIuranProduks(iuranProductLS);
        products.put("Life Special", productLS);

        Product productPT = new Product("Protection", JenisProduk.KR, FrekuensiPembayaran.T, "Mendapat ganti rugi sampai 100.000.000 bila terjadi sesuatu.", "Hanya bisa menanggung kendaraan.");
        IuranProduk iuranProdukPTA = new IuranProduk(productPT, null, null, 2_000_000D);
        List<IuranProduk> iuranProdukPT = new ArrayList<>();
        iuranProdukPT.add(iuranProdukPTA);
        productPT.setIuranProduks(iuranProdukPT);
        products.put("Protection", productPT);

        Product productPTP = new Product("Protection Plus", JenisProduk.KR, FrekuensiPembayaran.T, "Mendapat ganti rugi total lost apa bila terjadi sesuatu.", "Hanya bisa menanggung kendaraan.");
        IuranProduk iuranProdukPTPA = new IuranProduk(productPTP, null, null, 2_500_000D);
        List<IuranProduk> iuranProdukPTP = new ArrayList<>();
        iuranProdukPTP.add(iuranProdukPTPA);
        productPTP.setIuranProduks(iuranProdukPTP);
        products.put("Protection Plus", productPTP);
    }

    // find produk by produk nama
    public static Product findProductByName(String name) {
        return products.get(name);
    }


    //menambah data nasabah
    public static void  addDataNasabah(Nasabah nasabah, Prospect prospect){
        nasabah.setNomorNasabah(nasabah.generateNomorNasabah(prospect.getNomorProspect()));
        banyakNasabah.put(nasabah.getNomorNasabah(), nasabah);
        prospect.setNasabah(true);
        prospects.put(prospect.getNomorProspect(), prospect);
    }

    //menambahkan data Prospect
    public static void  addDataProspect(Prospect prospect){
        prospects.put(prospect.getNomorProspect(), prospect);
    }

    //list data prospect
    public static void printAllDataCustomerAndProspect(){
        for ( Prospect prospect : prospects.values()){
            prospect.printAllDataMenuProspect();
        }
    }

    //mengambil data Prospect
    public static Prospect getProspectData(Integer nomorProspect){
        return prospects.get(nomorProspect);
    }
    //print All Nasabah
    public static void printAllDataNasabah(){
        for(var customer : banyakNasabah.values()){
            customer.printSummary();
        }
    }

    // find nasabah form hashmap by nomor nasabah
    public static Nasabah findCustomerByNomorAndPrint(String nomor) {
        return banyakNasabah.get(nomor);
    }

    public static Boolean addPolicyCustomer(Nasabah nasabah, Polis policy) {
        boolean returnValue = false;
        System.out.println(policy.getProduct().getIuranProduks().size());
        if (policy.getProduct().getJenisProduk().equals(JenisProduk.KR)) {
            if (!policy.getProduct().getIuranProduks().isEmpty()) {
                policy.setIuranProduk(policy.getProduct().getIuranProduks().get(0));
                returnValue = true;
            }
        }else {
            long usia = ChronoUnit.YEARS.between(policy.getNasabah().getTanggalLahir(),LocalDate.now());
//            int umur = Period.between(policy.getNasabah().getTanggalLahir(), LocalDate.now()).getYears();
            for (IuranProduk iuranProduk: policy.getProduct().getIuranProduks()) {
                if (usia >= iuranProduk.getMinimumUmur() && usia <= iuranProduk.getMaksimumUmur()) {
                    policy.setIuranProduk(iuranProduk);
                    returnValue = true;
                    break;
                }
            }
        }
        if (Boolean.TRUE.equals(returnValue)) {
            nasabah.getPolis().add(policy);
            banyakNasabah.put(nasabah.getNomorNasabah(), nasabah);
        }
        return returnValue;
    }




}
