import java.util.LinkedList;
import java.util.List;

public class Product {
    private String namaProduk;
    private JenisProduk jenisProduk;
    private FrekuensiPembayaran frekuensiPembayaran;
    private String manfaatProduk;
    private String ketentuanProduk;
    private List<IuranProduk> iuranProduk;

    public Product() {
    }

    public Product(String namaProduk, JenisProduk jenisProduk, FrekuensiPembayaran frekuensiPembayaran, String manfaatProduk, String ketentuanProduk) {
        this.namaProduk = namaProduk;
        this.jenisProduk = jenisProduk;
        this.frekuensiPembayaran = frekuensiPembayaran;
        this.manfaatProduk = manfaatProduk;
        this.ketentuanProduk = ketentuanProduk;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
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

    public String getManfaatProduk() {
        return manfaatProduk;
    }

    public void setManfaatProduk(String manfaatProduk) {
        this.manfaatProduk = manfaatProduk;
    }

    public String getKetentuanProduk() {
        return ketentuanProduk;
    }

    public void setKetentuanProduk(String ketentuanProduk) {
        this.ketentuanProduk = ketentuanProduk;
    }

    public List<IuranProduk> getIuranProduk() {
        return iuranProduk;
    }

    public void setIuranProduk(LinkedList<IuranProduk> iuranProduk) {
        this.iuranProduk = iuranProduk;
    }

    //method untuk set iuran product
    public void setIuranProducts(List<IuranProduk> iuranProduk){
        this.iuranProduk = iuranProduk;
    }


}
