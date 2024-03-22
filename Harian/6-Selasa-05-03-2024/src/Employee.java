public class Employee {
/*
* Class Employee
*
* Field : number, name, departement
*
* buat fungsi yang bisa memindahkan seluruh Linkedlist<Employee>
* kedalam HashMap dimana key nya merupakan employee number dan value employee object
*
* */


    private String number;
    private String name;
    private String departement;


    public Employee(String number, String name, String departement) {
        this.number = number;
        this.name = name;
        this.departement = departement;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }
}
