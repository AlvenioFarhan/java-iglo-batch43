package main;

/*
* Pada java, enum bisa memiliki constructor dan method tersendiri.
* Sehingga dengan begini, kita tidak perlu membuat kan get label method di dalam class User Account.
* Kita bisa menggunakan method getLabelDalamIndonesia()
* */
public enum Religion {
    ISLAM("Islam"),
    CATHOLIC("Kristen Katolik"),
    CHRISTIAN("Kristen Protestan"),
    BUDDIST("Buddha"),
    HINDU("Hindu");

    private String labelDalamIndonesia;

    Religion(String labelDalamIndonesia) {
        this.labelDalamIndonesia = labelDalamIndonesia;
    }

    public String getLabelDalamIndonesia() {
        return labelDalamIndonesia;
    }
}
