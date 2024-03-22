import java.time.LocalDate;

public class Minister extends Citizen{

    private String division;

    public Minister() {
    }

    //-------------------------------------------------------------------------

    @Override
    public void printInfo(){
        System.out.printf("Person ini ber-nama: %s, Devisi: %s\n", super.getName(), this.division);
    }

    //-------------------------------------------------------------------------

    public Minister(String name, String birthCity, LocalDate birthDate, Gender gender, String nomorKTP, String division) {
        super(name, birthCity, birthDate, gender, nomorKTP);
        this.division = division;
    }
}
