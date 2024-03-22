import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Asuransi {
    private Prospect prospect;
    private static Map<String, Product> products = new HashMap<>();
    private static Map<Integer, Prospect> prospects = new HashMap<>();
    private static Map<String, Nasabah> banyakNasabah = new HashMap<>();

    //Data Product
    public static void initializeDataProduct() {
        //Product Sehat Bersama
        Product productSB = new Product("Sehat Bersama", JenisProduk.KH, FrekuensiPembayaran.B, "Claim perawatan kelas 1.", "Bisa menanggung keluarga atau diri sendiri dari data nasabah.");
        IuranProduk iuranProdukSBA = new IuranProduk(productSB, 0, 20, 200_000.0);
        IuranProduk iuranProdukSBB = new IuranProduk(productSB, 21, 999, 400_000.0);
        List<IuranProduk> iuranProduksSB = new LinkedList<>();
        iuranProduksSB.add(iuranProdukSBA);
        iuranProduksSB.add(iuranProdukSBB);
        productSB.setIuranProducts(iuranProduksSB);
        products.put("Sehat Bersama", productSB);


        //Product Sehat Extra
        Product productSE = new Product("Sehat Extra", JenisProduk.KH, FrekuensiPembayaran.B, "Claim perawatan kelas VIP.", "Hanya bisa menanggung diri sendiri.");
        IuranProduk iuranProdukSEA = new IuranProduk(productSE, 0, 20, 300_000D);
        IuranProduk iuranProdukSEB = new IuranProduk(productSE, 21, 999, 500_000D);
        List<IuranProduk> iuranProductsSE = new LinkedList<>();
        iuranProductsSE.add(iuranProdukSEA);
        iuranProductsSE.add(iuranProdukSEB);
        productSE.setIuranProducts(iuranProductsSE);
        products.put("Sehat Ekstra", productSE);

        //Product Life Keluarga
        Product productLK = new Product("Life Keluarga", JenisProduk.JW, FrekuensiPembayaran.B, "Mendapatkan 500.000.000 apabila terjadi sesuatu pada tertanggung.", "Bisa menanggung keluarga atau dirisendiri dari datanasabah.");
        IuranProduk iuranProdukLKA = new IuranProduk(productLK, 0, 20, 250_000.0);
        IuranProduk iuranProdukLKB = new IuranProduk(productLK, 21, 999, 450_000.0);
        List<IuranProduk> iuranProduksLK = new LinkedList<>();
        iuranProduksLK.add(iuranProdukLKA);
        iuranProduksLK.add(iuranProdukLKB);
        productLK.setIuranProducts(iuranProduksLK);
        products.put("Life Keluarga", productLK);

        //Product Life Spesial
        Product productLS = new Product("Life Special", JenisProduk.JW, FrekuensiPembayaran.T, "Mendapatkan 800.000.000 apabila terjadi sesuatu pada tertanggung.", "Hanya bisa menanggung diri sendiri.");
        IuranProduk iuranProdukLSA = new IuranProduk(productLK, 0, 20, 3_600_000.0);
        IuranProduk iuranProdukLSB = new IuranProduk(productLK, 21, 999, 4_800_000.0);
        List<IuranProduk> iuranProduksLS = new LinkedList<>();
        iuranProduksLS.add(iuranProdukLSA);
        iuranProduksLS.add(iuranProdukLSB);
        productLS.setIuranProducts(iuranProduksLS);
        products.put("Life Special", productLS);

        //Product Protection
        Product productPT = new Product("Protection", JenisProduk.KR, FrekuensiPembayaran.T, "Mendapat ganti rugi sampai 100.000.000 bila terjadi sesuatu.", "Hanya bisa menanggung kendaraan.");
        IuranProduk iuranProdukPTA = new IuranProduk(productPT, null, null, 2_000_000.0);
        List<IuranProduk> iuranProduksPT = new LinkedList<>();
        iuranProduksPT.add(iuranProdukPTA);
        productPT.setIuranProducts(iuranProduksPT);
        products.put("Protection", productPT);

        //Product Protection Plus
        Product productPP = new Product("Protection Plus", JenisProduk.KR, FrekuensiPembayaran.T, "Mendapat ganti rugi total lost apa bila terjadi sesuatu.", "Hanya bisa menanggung kendaraan.");
        IuranProduk iuranProdukPP = new IuranProduk(productPP, null, null, 2_500_000.0);
        List<IuranProduk> iuranProduksPP = new LinkedList<>();
        iuranProduksPP.add(iuranProdukPP);
        productPP.setIuranProducts(iuranProduksPP);
        products.put("Protection Plus", productPP);

    }

    //menambah data nasabah
    public static void addDataNasabah(Nasabah nasabah, Prospect prospect) {
        nasabah.setNomorNasabah(nasabah.generateNomorNasabah(prospect.getNomorProspect()));
        banyakNasabah.put(nasabah.getNomorNasabah(), nasabah);
        prospect.setNasabah(true);
        prospects.put(prospect.getNomorProspect(), prospect);
    }

    // mencetak semua data nasabah
    public static void printAllDataNasabah() {
        for (Nasabah nasabah : banyakNasabah.values()) {
            nasabah.printAllDataMenuCustomerLengkap();
        }
    }

    //Mencari data nasabah dengan nomor
    public static Nasabah findNasabahByNomor(String nomor) {
        return banyakNasabah.get(nomor);
    }

    //Mencari Product dengan nama
    public static Product findProductByName(String name) {
        return products.get(name);
    }

    //menambahkan data Prospect
    public static void addDataProspect(Prospect prospect) {
        prospects.put(prospect.getNomorProspect(), prospect);
    }

    //list data prospect
    public static void printAllDataCustomerAndProspect() {
        for (Prospect prospect : prospects.values()) {
            prospect.printAllDataMenuProspect();
        }
    }

    //mengambil data Prospect
    public static Prospect getProspectData(Integer nomorProspect) {
        return prospects.get(nomorProspect);
    }


//    // menambahkan data policy nasabah BARU DITAMBAHKAN
    public static Boolean addDataPolisNasabah(Nasabah nasabah, Polis polis){

        boolean returnValue = false;
//        System.out.println(polis.getProduct().getIuranProduk().size());
        if (polis.getProduct().getJenisProduk().equals(JenisProduk.KR)) {
            if (!polis.getProduct().getIuranProduk().isEmpty()) {
                polis.setIuranProduk(polis.getProduct().getIuranProduk().get(0));
                returnValue = true;
            }
        }else {
            long usia = ChronoUnit.YEARS.between(polis.getNasabah().getTanggalLahir(),LocalDate.now());
//            int umur = Period.between(polis.getNasabah().getTanggalLahir(), LocalDate.now()).getYears();
            for (IuranProduk iuranProduk: polis.getProduct().getIuranProduk()) {
                if (usia >= iuranProduk.getMinimalUmur() && usia <= iuranProduk.getMaksimalUmur()) {
                    polis.setIuranProduk(iuranProduk);
                    returnValue = true;
                    break;
                }
            }
        }
        if (Boolean.TRUE.equals(returnValue)) {
            nasabah.getPolis().add(polis);
            banyakNasabah.put(nasabah.getNomorNasabah(), nasabah);
        }
        return returnValue;

    }

}
