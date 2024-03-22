public class MatkulDosen {

    private MataKuliah mataKuliah;
    private Dosen dosen;


    public void printCompetencyInformation(){

        System.out.printf("%s in %s\n", this.mataKuliah.getNamaMataKuliah(), this.mataKuliah.getNamaPenjurusan());
    }

    public MatkulDosen(MataKuliah mataKuliah, Dosen dosen) {
        this.mataKuliah = mataKuliah;
        this.dosen = dosen;
    }

    public MataKuliah getMataKuliah() {
        return mataKuliah;
    }

    public void setMataKuliah(MataKuliah mataKuliah) {
        this.mataKuliah = mataKuliah;
    }

    public Dosen getDosen() {
        return dosen;
    }

    public void setDosen(Dosen dosen) {
        this.dosen = dosen;
    }
}
