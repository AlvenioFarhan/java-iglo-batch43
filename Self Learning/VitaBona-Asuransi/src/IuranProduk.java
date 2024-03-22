public class IuranProduk {

    private Product product;

    private Integer minimumUmur;

    private Integer maksimumUmur;

    private Double iuran;

    public IuranProduk(Product product, Integer minimumUmur, Integer maksimumUmur, Double iuran) {
        this.product = product;
        this.minimumUmur = minimumUmur;
        this.maksimumUmur = maksimumUmur;
        this.iuran = iuran;
    }

    public IuranProduk() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getMinimumUmur() {
        return minimumUmur;
    }

    public void setMinimumUmur(Integer minimumUmur) {
        this.minimumUmur = minimumUmur;
    }

    public Integer getMaksimumUmur() {
        return maksimumUmur;
    }

    public void setMaksimumUmur(Integer maksimumUmur) {
        this.maksimumUmur = maksimumUmur;
    }

    public Double getIuran() {
        return iuran;
    }

    public void setIuran(Double iuran) {
        this.iuran = iuran;
    }
}
