/*
* Aturan dalam membuat Interface :
* 1. Tidak ada field
* 2. Tidak ada constructor
* 3. Interface tidak bisa di Instantiate
* 4. Hanya boleh membuat abstrak method di dalam member interface
* (Note : abstrak method adalah method/fungsi tanpa body)
* 5. Sebuah class Meng-Inherit/meng-implemen interface, artinya setuju untuk meng-override
* semua signature abstract method dari si interface
* (Ini sering disebut sebagai contract /perjanjian)
* 6. Sebuah class bisa implement ke banyak interfaces
* 7. Interface tidak bisa punya static
*
* Kegunaannya:
* 1. Menambah manuver Polymorphism
* 2. Sebuah entity yang tidak mungkin di instantiate, karena terlalu abstract
*
* */

public interface WargaNegara {
    public void setNomorKTP(String nomorKTP);
    public String getNomorKTP();
}
