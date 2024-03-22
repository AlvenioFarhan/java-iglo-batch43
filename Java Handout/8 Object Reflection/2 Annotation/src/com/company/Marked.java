package com.company;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/*
    Setiap annotation memiliki retention policy. Retention policy adalah aturan kapan metadata dari sebuah annotation akan expired
    dan dihapus secara otomatis oleh Java.

    Baik RetentionPolicy.SOURCE dan RetentionPolicy.CLASS(default) akan terhapus ketika java sudah dicompile dan masuk ke runtime.
    Hanya meta data dari RetentionPolicy.RUNTIME yang tetap bertahan ketika aplikasi berjalan.

    Kebanyakan dari developer tentu saja akan menggunakan RetentionPolicy.RUNTIME karena hanya policy ini yang bisa diakses
    oleh reflection. (Karena tentu saja reflection memproses code ketika runtime)

    Kegunaan dari RetentionPolicy yang berjalan pre-compile atau hanya pada saat compile pada SOURCE dan CLASS adalah untuk
    membantu proses compilasi, contohnya seperti @Override. Ketika java meng-compile untuk menentukan method mana yang di override method lain,
    setelah proses compilasi, informasi pada metadata tidak diperlukan lagi.
*/
@Retention(RetentionPolicy.RUNTIME)
public @interface Marked { }
