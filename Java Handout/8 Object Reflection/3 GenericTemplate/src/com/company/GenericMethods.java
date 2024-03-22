package com.company;
import classLibrary.Employee;
import classLibrary.Stakeholder;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

//Semua contoh-contoh generic method terletak pada class ini.
public class GenericMethods {

    //Generic pada method bisa mengatur tipe data pada parameternya.
    public static <T> void printSingleField(T anyObject, String fieldName) {
        System.out.println("=============== printSingleField(Type anyObject, String fieldName) =====================");
        //Kita tidak bisa langsung mengambil Class atau Type dari T pada generic, karena T tidak diproses pada saat run time.
        Class<?> type = anyObject.getClass();
        try{
            Field field = type.getDeclaredField(fieldName);
            field.setAccessible(true);
            Object value = field.get(anyObject);
            System.out.printf("%s : %s\n", fieldName, value.toString());
        } catch(Exception exception){}
    }

    /*
        Penggunaan generic type template juga bisa kita oper dari generic ke generic, contohnya saja
        kita mengoper <T> dari method ke List<T> pada parameter.
    */
    public static <T> void printAllForField(List<T> collections, String fieldName) {
        System.out.println("=============== printAllForField(List<Type> collections, String fieldName) =====================");
        for (T anyObject : collections) {
            try{
                Class<?> type = anyObject.getClass();
                Field field = type.getSuperclass().getDeclaredField(fieldName);
                field.setAccessible(true);
                Object value = field.get(anyObject);
                System.out.printf("%s : %s\n", fieldName, value);
            } catch (Exception exception){}
        }
    }

    /*
        Di sini kita menggunakan generic dengan cara Bounded Type Parameters, yang artinya Template Type pada generic ini
        dibatasi oleh extends (inheritance) kepada Employee.

        Itu artinya, parameter yang masuk ke dalam method ini, tidak boleh memiliki tipe data diluar dari tipe data yang
        meng-inherit class Employee.
    */
    public static <T extends Employee> void printAllEmployeeInfo(List<T> collections) {
        System.out.println("=============== printAllEmployeeInfo(List<Type> collections) =====================");
        for (Employee employee : collections) {
            employee.printEmployeeInfo();
            Class<?> employeeType = employee.getClass();
            try{
                Method paymentSlipMethod = employeeType.getDeclaredMethod("paymentSlip");
                paymentSlipMethod.invoke(employee);
            } catch (Exception exception){}
        }
    }

    /*
        Yang bermanfaat dari generic adalah, kemampuannya meng-singkronisasi antara satu parameter dengan parameter lain, atau mengsingkronisasi
        antara parameter dengan return typenya, karena generic juga bisa mengatur tipe data returnnya.
        Dengan kata lain pada method ini, hasil return akan berubah tergantung tipe data argument yang masuk ke dalam parameter ini.

        Kalian juga bisa lihat di sini, walaupun Stakeholder adalah interface, Bound Type tetap akan menggunakan kata extends, bukan implements.
    */
    public static <T extends Stakeholder> List<T> getAndUpdateAllStakeholders(List<T> stakeholders, String companyName){
        System.out.println("=============== getAndUpdateAllStakeholders(List<Type> stakeholders, String companyName) =====================");
        List<T> updatedStakeholders = new ArrayList<T>();
        for(T stakeholder : stakeholders){
            stakeholder.setCompany(companyName);
            updatedStakeholders.add(stakeholder);
        }
        return updatedStakeholders;
    }

    /*
        Generic bisa memiliki multiple Type template, berikut ini adalah contoh penggunaanya.
    */
    public static <THeader, TDetail> THeader assigningDetails(THeader header, List<TDetail> details, String setMethodName){
        System.out.println("=============== assigningDetails(TypeHeader header, List<TypeDetail> details, String setMethodName) =====================");
        try{
            Class<?> headerType = header.getClass();
            Method setMethod = headerType.getDeclaredMethod(setMethodName, List.class);
            setMethod.invoke(header, details);
        } catch (Exception exception){}
        return header;
    }
}
