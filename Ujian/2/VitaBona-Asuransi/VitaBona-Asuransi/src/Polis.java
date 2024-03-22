import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Polis {
    private Nasabah nasabah;
    private Product product;
    private LocalDate tanggalMulai;
    private IuranProduk iuranProduk;
    private Nasabah tertanggung;
    private String jenisKendaraan;
    private String nomorPolisi;
    private String nomorSTNK;
    private String merekKendaraan;
    private String modelKendaraan;
    private String warnaKendaraan;


    public Polis() {
    }

    public Polis(Nasabah nasabah, Product product, LocalDate tanggalMulai, IuranProduk iuranProduk, Nasabah tertanggung, String jenisKendaraan, String nomorPolisi, String nomorSTNK, String merekKendaraan, String modelKendaraan, String warnaKendaraan) {
        this.nasabah = nasabah;
        this.product = product;
        this.tanggalMulai = tanggalMulai;
        this.iuranProduk = iuranProduk;
        this.tertanggung = tertanggung;
        this.jenisKendaraan = jenisKendaraan;
        this.nomorPolisi = nomorPolisi;
        this.nomorSTNK = nomorSTNK;
        this.merekKendaraan = merekKendaraan;
        this.modelKendaraan = modelKendaraan;
        this.warnaKendaraan = warnaKendaraan;
    }

    public Nasabah getNasabah() {
        return nasabah;
    }

    public void setNasabah(Nasabah nasabah) {
        this.nasabah = nasabah;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public LocalDate getTanggalMulai() {
        return tanggalMulai;
    }

    public void setTanggalMulai(LocalDate tanggalMulai) {
        this.tanggalMulai = tanggalMulai;
    }

    public IuranProduk getIuranProduk() {
        return iuranProduk;
    }

    public void setIuranProduk(IuranProduk iuranProduk) {
        this.iuranProduk = iuranProduk;
    }

    public Nasabah getTertanggung() {
        return tertanggung;
    }

    public void setTertanggung(Nasabah tertanggung) {
        this.tertanggung = tertanggung;
    }

    public String getJenisKendaraan() {
        return jenisKendaraan;
    }

    public void setJenisKendaraan(String jenisKendaraan) {
        this.jenisKendaraan = jenisKendaraan;
    }

    public String getNomorPolisi() {
        return nomorPolisi;
    }

    public void setNomorPolisi(String nomorPolisi) {
        this.nomorPolisi = nomorPolisi;
    }

    public String getNomorSTNK() {
        return nomorSTNK;
    }

    public void setNomorSTNK(String nomorSTNK) {
        this.nomorSTNK = nomorSTNK;
    }

    public String getMerekKendaraan() {
        return merekKendaraan;
    }

    public void setMerekKendaraan(String merekKendaraan) {
        this.merekKendaraan = merekKendaraan;
    }

    public String getModelKendaraan() {
        return modelKendaraan;
    }

    public void setModelKendaraan(String modelKendaraan) {
        this.modelKendaraan = modelKendaraan;
    }

    public String getWarnaKendaraan() {
        return warnaKendaraan;
    }

    public void setWarnaKendaraan(String warnaKendaraan) {
        this.warnaKendaraan = warnaKendaraan;
    }

    //Print Data Polis
    public void printDataPolis() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        System.out.println("======================== POLICY INFO ==================================");

        if (product.getJenisProduk().equals(JenisProduk.KR)) {
            System.out.printf("Product: %s\nTanggal Mulai Dijalankan: %s\nJenis kendaraan: %s\nNomor Polisi: %s\nNomor STNK: %s\nMerek kendaraan: %s\nModel kendaraan: %s\nWarna kendaraan: %s\n",
                    product.getNamaProduk(), formatter.format(tanggalMulai), jenisKendaraan, nomorPolisi, nomorSTNK, merekKendaraan, modelKendaraan, warnaKendaraan);
        }else {
            System.out.printf("Tertanggung: %s\nProduct: %s\nTanggal Mulai Dijalankan: %s\nManfaat: %s\n",
                    tertanggung.getNamaLengkap(), product.getNamaProduk(), formatter.format(tanggalMulai), product.getManfaatProduk());
        }

        System.out.println("=======================================================================");
        System.out.println("========================== PAYMENT ====================================");

        if (product.getFrekuensiPembayaran().equals(FrekuensiPembayaran.B)) {
            for (int index = 0; index < 3; index++) {
                System.out.printf("%s. %s\n", formatter.format(tanggalMulai.plusMonths(index)), iuranProduk.getIuran());
            }
        }else if (product.getFrekuensiPembayaran().equals(FrekuensiPembayaran.T)){
            for (int index = 0; index < 3; index++) {
                System.out.printf("%s. %s\n", formatter.format(tanggalMulai.plusMonths(index)), iuranProduk.getIuran());
            }
        }

        System.out.println("=====================================================================");

    }
}
