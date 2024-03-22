package com.company;

import classLibrary.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    /* Generic (Parameterized Type) adalah template data type yang bisa diatur pada saat pemakaian pada sebuah method atau class.
     * Generic ditandai dengan syntax <>
     *
     * Generic memungkinkan satu macam tipe data pada class atau pada method untuk dipakai beberapa kali dalam pengaplikasian tipe data yang berbeda.
     * Contoh paling mencolok dalam Generic adalah tipe-tipe generic collection seperti List misalnya.
     */
    public static void main(String[] args) {
        executingPrintSingleField();
        executingPrintAllForField();
        executingPrintAllEmployeeInfo();
        executingGetAndUpdateAllStakeholders();
        executingAssigningDetails();
        useSingleEntity();
        useGroupOfSomething();
        useGroupOfEmployee();
        useGroupOfSpecificPeople();
        useGroupOfSpecificEmployees();
        useGroupOfHeaderDetails();
    }

    /*
        Meng-invoke printSingleField, method ini langsung mendeteksi kalau tipe data parameter pertama adalah Employee.
        Kita tidak lagi menuliskan <Employee> pada saat memanggil fungsinya.
    */
    public static void executingPrintSingleField(){
        Employee jack = new Employee(
                "Jack Sparrow",
                LocalDate.of(1988, 11, 27),
                "Male",
                "J233",
                LocalDate.of(2015, 10, 4),
                12000000.0
        );
        GenericMethods.printSingleField(jack, "employeeNumber");

        StakeHolderImplementation helen = new StakeHolderImplementation(
                "Helen Garcia",
                LocalDate.of(1982,12,27),
                "Female",
                "Microsoft",
                "Technology"
        );
        GenericMethods.printSingleField(helen, "company");
    }

    public static void executingPrintAllForField(){
        Employee jack = new Employee(
                "Jack Sparrow",
                LocalDate.of(1988, 11, 27),
                "Male",
                "J233",
                LocalDate.of(2015, 10, 4),
                12000000.0
        );
        StakeHolderImplementation helen = new StakeHolderImplementation(
                "Helen Garcia",
                LocalDate.of(1982,12,27),
                "Female",
                "Microsoft",
                "Technology"
        );

        List<Person> people = new ArrayList<>();
        people.add(jack);
        people.add(helen);
        GenericMethods.printAllForField(people, "fullName");
    }

    public static void executingPrintAllEmployeeInfo(){
        List<Staff> staffs = new ArrayList<>();
        staffs.add(new Staff(
                "Adrian Hartanto", LocalDate.of(1987, 10, 8), "Male", "A577",
                LocalDate.of(2018,4,4), 7000000.0, 1000000.0 ));
        staffs.add(new Staff(
                "Silvia Marrison", LocalDate.of(1988, 7, 6), "Female", "A587",
                LocalDate.of(2019,4,2), 6000000.0, 500000.0 ));
        GenericMethods.printAllEmployeeInfo(staffs);

        List<Manager> managers = new ArrayList<Manager>();
        managers.add(new Manager("Agustina Suwandi",
                LocalDate.of(1986, 1, 5), "Female", "B500",
                LocalDate.of(2018,4,4), 30000000.0, 30.0));
        managers.add(new Manager("Donny Darko",
                LocalDate.of(1984, 2, 2), "Male", "B501",
                LocalDate.of(2017,6,8), 20000000.0, 25.0));
        GenericMethods.printAllEmployeeInfo(managers);
    }

    public static void executingGetAndUpdateAllStakeholders(){
        List<Supplier> suppliers = new ArrayList<Supplier>();
        suppliers.add(new Supplier("Harrison Ford", LocalDate.of(1986, 1, 5),
                "Male", "Company X", "Food Industry", "Sales Manager"));
        suppliers.add(new Supplier("Johnny Mnemonic", LocalDate.of(1976, 1, 6),
                "Male", "Company Y", "Construction", "Sales Manager"));

        List<Supplier> updatedSuppliers = GenericMethods.getAndUpdateAllStakeholders(suppliers, "Blue Diamond");

        for(Supplier supplier : updatedSuppliers){
            supplier.printCompanyInfo();
        }
    }

    public static void executingAssigningDetails(){
        List<Staff> staffs = new ArrayList<>();
        staffs.add(new Staff(
                "Adrian Hartanto", LocalDate.of(1987, 10, 8), "Male", "A577",
                LocalDate.of(2018,4,4), 7000000.0, 1000000.0 ));
        staffs.add(new Staff(
                "Silvia Marrison", LocalDate.of(1988, 7, 6), "Female", "A587",
                LocalDate.of(2019,4,2), 6000000.0, 500000.0 ));

        Manager donny = new Manager("Donny Darko", LocalDate.of(1984,2,2), "Male", "B501",
                LocalDate.of(2017, 6, 8), 20000000.0, 25.0);
        Manager updatedDonny = GenericMethods.assigningDetails(donny, staffs, "setSubordinates");
        System.out.println(updatedDonny.getSubordinates().size());
    }

    public static void useSingleEntity(){
        System.out.println("============== useSingleEntity() ====================");

        Staff adrian = new Staff("Adrian Hartanto", LocalDate.of(1987, 10, 8),
                "Male", "A577", LocalDate.of(2018, 4, 4), 7000000.0, 1000000.0);
        SingleEntity myEntity = new SingleEntity(adrian);

        Staff staffEntity = (Staff)myEntity.getEntity();
        System.out.println(staffEntity.getFullName());
        System.out.println(staffEntity.getAllowance());

        Supplier harrison = new Supplier("Harrison Ford", LocalDate.of(1986, 1, 5),
                "Male", "Company X", "Food Industry", "Sales Manager");
        myEntity.setEntity(harrison);
        Supplier supplierEntity = (Supplier)myEntity.getEntity();
        System.out.println(supplierEntity.getFullName());
        System.out.println(supplierEntity.getBusiness());
    }

    public static void useGroupOfSomething(){
        System.out.println("============== useGroupOfSomething() ====================");
        List<Person> people = new ArrayList<>();
        people.add(new Employee(
                "Jack Sparrow",
                LocalDate.of(1988, 11, 27),
                "Male",
                "J233",
                LocalDate.of(2015, 10, 4),
                12000000.0
        ));
        people.add(new StakeHolderImplementation(
                "Helen Garcia",
                LocalDate.of(1982,12,27),
                "Female",
                "Microsoft",
                "Technology"
        ));

        List<Staff> staffs = new ArrayList<>();
        staffs.add(new Staff(
                "Adrian Hartanto", LocalDate.of(1987, 10, 8), "Male", "A577",
                LocalDate.of(2018,4,4), 7000000.0, 1000000.0 ));
        staffs.add(new Staff(
                "Silvia Marrison", LocalDate.of(1988, 7, 6), "Female", "A587",
                LocalDate.of(2019,4,2), 6000000.0, 500000.0 ));

        GroupOfSomething<Person> groupOfPeople = new GroupOfSomething(people);
        groupOfPeople.printAllSelectedField("fullName");
        groupOfPeople.printAllFieldNames();

        GroupOfSomething<Staff> groupOfStaff = new GroupOfSomething(staffs);
        groupOfStaff.printAllSelectedField("employeeNumber");
        groupOfStaff.printAllFieldNames();
    }

    public static void useGroupOfEmployee(){
        System.out.println("============== useGroupOfEmployee() ====================");
        List<Employee> employees = new ArrayList<>();
        employees.add(new Staff(
                "Adrian Hartanto", LocalDate.of(1987, 10, 8), "Male", "A577",
                LocalDate.of(2018,4,4), 7000000.0, 1000000.0 ));
        employees.add(new Manager("Donny Darko", LocalDate.of(1984,2,2), "Male", "B501",
                LocalDate.of(2017, 6, 8), 20000000.0, 25.0));
        GroupOfEmployees staffEmployees = new GroupOfEmployees(employees);
        staffEmployees.printAllEmployeeInfos();
        staffEmployees.printAllOriginalDataType();
    }

    public static void useGroupOfSpecificPeople(){
        System.out.println("============== useGroupOfSpecificPeople() ====================");
        List<Staff> staffs = new ArrayList<>();
        staffs.add(new Staff(
                "Adrian Hartanto", LocalDate.of(1987, 10, 8), "Male", "A577",
                LocalDate.of(2018,4,4), 7000000.0, 1000000.0 ));
        staffs.add(new Staff(
                "Silvia Marrison", LocalDate.of(1988, 7, 6), "Female", "A587",
                LocalDate.of(2019,4,2), 6000000.0, 500000.0 ));

        GroupOfSpecificPeople groupOfSpecificStaff = new GroupOfSpecificPeople(staffs);
        groupOfSpecificStaff.printAllFieldNames();
        groupOfSpecificStaff.printAllMethodNames();
    }

    public static void useGroupOfSpecificEmployees(){
        System.out.println("============== useGroupOfSpecificEmployees() ====================");
        List<Manager> managers = new ArrayList<Manager>();
        managers.add(new Manager("Agustina Suwandi",
                LocalDate.of(1986, 1, 5), "Female", "B500",
                LocalDate.of(2018,4,4), 30000000.0, 30.0));
        managers.add(new Manager("Donny Darko",
                LocalDate.of(1984, 2, 2), "Male", "B501",
                LocalDate.of(2017,6,8), 20000000.0, 25.0));

        GroupOfSpecificEmployees groupOfSpecificManagers = new GroupOfSpecificEmployees(managers);
        groupOfSpecificManagers.printAllWorkingDuration();
    }

    public static void useGroupOfHeaderDetails(){
        System.out.println("============== useGroupOfHeaderDetails() ====================");
        Category[] categories = {
                new Category(1, "Makanan"),
                new Category(2, "Elektronik"),
                new Category(3, "Rumah Tangga")
        };
        Product[] products = {
                new Product(1, "Indomie", 1),
                new Product(2, "Permen", 1),
                new Product( 3, "Handphone", 2),
                new Product(4, "Laptop", 2),
                new Product(5, "Speaker", 2)
        };
        GroupOfHeaderDetails<Category, Product> group = new GroupOfHeaderDetails<>(categories, products);
        try{
            group.innerJoin();
        }catch (Exception exception){}
    }
}
