import java.util.List;

public class Product {

    private String nama;

    private JenisProduk jenisProduk;

    private FrekuensiPembayaran frekuensiPembayaran;

    private String manfaat;

    private String ketentuan;

    private List<IuranProduk> premiumRates;

    public Product(String nama, JenisProduk jenisProduk, FrekuensiPembayaran frekuensiPembayaran, String manfaat, String ketentuan) {
        this.nama = nama;
        this.jenisProduk = jenisProduk;
        this.frekuensiPembayaran = frekuensiPembayaran;
        this.manfaat = manfaat;
        this.ketentuan = ketentuan;
    }

    public Product() {
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public JenisProduk getJenisProduk() {
        return jenisProduk;
    }

    public void setJenisProduk(JenisProduk jenisProduk) {
        this.jenisProduk = jenisProduk;
    }

    public FrekuensiPembayaran getFrekuensiPembayaran() {
        return frekuensiPembayaran;
    }

    public void setFrekuensiPembayaran(FrekuensiPembayaran frekuensiPembayaran) {
        this.frekuensiPembayaran = frekuensiPembayaran;
    }

    public String getManfaat() {
        return manfaat;
    }

    public void setManfaat(String manfaat) {
        this.manfaat = manfaat;
    }

    public String getKetentuan() {
        return ketentuan;
    }

    public void setKetentuan(String ketentuan) {
        this.ketentuan = ketentuan;
    }

    public List<IuranProduk> getIuranProduks() {
        return premiumRates;
    }

    public void setIuranProduks(List<IuranProduk> premiumRates) {
        this.premiumRates = premiumRates;
    }
}
