public class IuranProduk {
private Product product;
private Integer minimalUmur;
private Integer maksimalUmur;
private Double iuran;

    public IuranProduk() {
    }

    public IuranProduk(Product product, Integer minimalUmur, Integer maksimalUmur, Double iuran) {
        this.product = product;
        this.minimalUmur = minimalUmur;
        this.maksimalUmur = maksimalUmur;
        this.iuran = iuran;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getMinimalUmur() {
        return minimalUmur;
    }

    public void setMinimalUmur(Integer minimalUmur) {
        this.minimalUmur = minimalUmur;
    }

    public Integer getMaksimalUmur() {
        return maksimalUmur;
    }

    public void setMaksimalUmur(Integer maksimalUmur) {
        this.maksimalUmur = maksimalUmur;
    }

    public Double getIuran() {
        return iuran;
    }

    public void setIuran(Double iuran) {
        this.iuran = iuran;
    }
}
