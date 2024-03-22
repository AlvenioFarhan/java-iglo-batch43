public class Product {

    /*
    *buat sebuah class, namanya product.
        didalam terdapat 3 field
        nama, harga, stok.
        komplit getter setter
        dan ada constructor lengkap.
     */

    private String nama;
    private Double harga;
    private Integer stock;


    public Product(String nama, Double harga, Integer stock) {
        this.nama = nama;
        this.harga = harga;
        this.stock = stock;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Double getHarga() {
        return harga;
    }

    public void setHarga(Double harga) {
        this.harga = harga;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
