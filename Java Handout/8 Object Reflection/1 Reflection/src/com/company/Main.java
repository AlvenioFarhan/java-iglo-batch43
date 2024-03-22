package com.company;

import java.lang.reflect.*;
import java.lang.Class;
import java.time.LocalDate;

public class Main {

    /*
        Reflection adalah fitur pada Java yang digunakan untuk melakukan inspeksi atau introspeksi pada internal properties dari programnya seperti:
        Class, member class dan lain sebagainya. Kebanyakan feature-feature dari reflection datang dari library package java.lang.reflect*/

    public static void main(String[] args) {
        className();
        usingInstanceOf();
        allMethods();
        allDeclaredMethods();
        getSingleMethod();
        allFields();
        allDeclaredFields();
        getSingleField();
        getSingleDeclaredField();
        getFieldValue();
        allParameters();
        getClassFromObject();
        checkAccessModifier();
        printPackage();
        printSuperClass();
        allInterfaces();
        allInterfaces();
        allConstructor();
    }

    /*
        Kita bisa mendapatkan object class dari sebuah class dengan menggunakan .class
        Di bawah ini adalah contoh cara mendapatkan nama class dari sebuah class*/
    public static void className(){
        System.out.println("=============== className() ================");
        System.out.println(Person.class.getName());
        try{
            Class stringClass = Class.forName("java.lang.String");
            Class personClass = Class.forName(Person.class.getName());
            Class personType = Person.class;
        } catch (Exception exception){
        }
    }

    /*
        instanceof akan mengembalikan boolean value apabila sebuah object termasuk ke dalam sebuah tipe data tertentu.
        Tentunya instanceof juga akan bekerja dengan polymorphism.*/
    public static void usingInstanceOf(){
        System.out.println("============== usingInstanceOf()================");
        Student alex = new Student();
        System.out.println(alex instanceof Student);
        System.out.println(alex instanceof Person);
        Person marry = new Person();
        System.out.println(marry instanceof Student);
        System.out.println(marry instanceof Person);
        Person harry = new Student();
        System.out.println(harry instanceof Student);
    }

    /*
        gunakan getMethods untuk mendapatkan seluruh method yang dimiliki sebuah class.
        Hati-hati, getMethods akan mengembalikan seluruh method yang accessible di dalam class tersebut.
        Sekalipun method tersebut adalah parent classnya atau yang berasal dari library.*/
    public static void allMethods(){
        System.out.println("=============== allMethods() ================");
        Method[] methods = Student.class.getMethods();
        for(Method method : methods){
            System.out.println(method.getName());
        }
    }

    /*Untuk mendapatkan methods yang hanya di deklarasi di dalam class yang diinginkan kita menggunakan getDeclaredMethods().*/
    public static void allDeclaredMethods(){
        System.out.println("=============== allDeclaredMethods() ================");
        Method[] methods = Student.class.getDeclaredMethods();
        for(Method method : methods){
            System.out.println(method.getName());
        }
    }

    /*
        Untuk mendapatkan 1 selected Method, kita harus terlebih dahulu mengetahui signature dari method tersebut.
        Lalu dengan menggunakan method getMethod() atau getDeclaredMethod() kita akan mengisi parameter pertama dengan String argument berupa nama method tersebut.
        Lalu parameter kedua, ketiga dan selanjutnya isi dengan tipe data parameternya sesuai dengan urutan signaturenya.*/
    public static void getSingleMethod(){
        System.out.println("=============== getSingleMethod() =================");
        try{
            Method calculateAgeLong = Person.class.getMethod("calculateAge", null);
            System.out.printf("Name: %s\n", calculateAgeLong.getName());
            System.out.printf("Return Type: %s\n", calculateAgeLong.getAnnotatedReturnType());
            System.out.println("===================================");
            Method calculateAgeDouble = Person.class.getMethod("calculateAge", LocalDate.class);
            System.out.printf("Name: %s\n", calculateAgeDouble.getName());
            System.out.printf("Return Type: %s\n", calculateAgeDouble.getAnnotatedReturnType());
        } catch (Exception exception){
        }
    }

    /*
        Untuk mendapatkan accessible field, kita bisa menggunakn getFields()
        Tapi ingat, hanya yang accessible, dalam hal ini hanya public field yang bisa kita akses.
        Sehingga seluruh private field tidak akan di print.*/
    public static void allFields(){
        System.out.println("=============== allFields() ================");
        Field[] fields = Person.class.getFields();
        for(Field field : fields){
            System.out.println(field.getName());
        }
    }

    /*
        Untuk mendapatkan seluruh field yang di deklarasi di dalam class yang dituju tanpa memperdulikan
        access modifiernya, kita bisa menggunakan getDeclaredFields()*/
    public static void allDeclaredFields(){
        System.out.println("=============== allDeclaredFields() ================");
        Field[] fields = Person.class.getDeclaredFields();
        for(Field field : fields){
            System.out.println(field.getName());
        }
    }

    /*kita juga bisa mendapatkan 1 selected field dengan menggunakan namanya*/
    public static void getSingleField(){
        System.out.println("=============== getSingleFields() ================");
        try{
            Field field = Person.class.getField("firstName");
            System.out.println(field.getType());
        }catch (Exception exception){
        }
    }

    public static void getSingleDeclaredField(){
        System.out.println("=============== getSingleDeclaredFields() ================");
        try{
            Field field = Person.class.getDeclaredField("dependencies");
            System.out.println(field.getType());
        }catch (Exception exception){
        }
    }

    /*
    * Untuk private field kita harus membuka aksesnya dahulu sebelum kita bisa mendapatkan valuenya.
    * */
    public static void getFieldValue(){
        System.out.println("=============== getFieldValue() =================");
        Person alex = new Person("Alexander", "Corvinus", 2, LocalDate.of(1988, 11, 27));
        try{
            Class<?> type = alex.getClass();
            Field publicField = Person.class.getDeclaredField("firstName");
            Object value = publicField.get(alex);
            System.out.println(value);
            Field privateField = Person.class.getDeclaredField("lastName");
            privateField.setAccessible(true);
            value = privateField.get(alex);
            System.out.println(value);
        }catch(Exception exception){
        }
    }

    /*Kita juga bisa meng-inspeksi seluruh parameter dari sebuah method*/
    public static void allParameters(){
        System.out.println("=============== allParameters() =================");
        try{
            Method method = Student.class.getMethod("enrollSubject", String.class, LocalDate.class, double.class);
            Parameter[] parameters = method.getParameters();
            for(Parameter parameter : parameters){
                System.out.println(parameter.getParameterizedType());
            }
        } catch (Exception exception){
        }
    }

    /*Kita juga bisa mendapatkan refleksi class dari sebuah object.*/
    public static void getClassFromObject(){
        System.out.println("=============== getClassFromObject() =================");
        Person person = new Person();
        Student student = new Student();
        Class<?> personClass = person.getClass();
        System.out.println(personClass.getName());
    }

    /*Access modifier akan dikembalikan oleh fungsi reflection sebagai integer.
        Untuk melakukan check terhadap angka dari access modifier, gunakan static method, isPrivate, isPublic atau isProtected
    */
    public static void checkAccessModifier(){
        System.out.println("=============== checkAccessModifier() =================");
        try{
            Field firstName = Person.class.getDeclaredField("firstName");
            Field lastName = Person.class.getDeclaredField("lastName");
            int firstNameModifier = firstName.getModifiers();
            int lastNameModifier = lastName.getModifiers();
            System.out.printf("First Name modifier number: %s, isPublic: %s, isPrivate: %s\n",
                    firstNameModifier, Modifier.isPublic(firstNameModifier), Modifier.isPrivate(firstNameModifier));
            System.out.printf("Last Name modifier number: %s, isPublic: %s, isPrivate: %s\n",
                    lastNameModifier, Modifier.isPublic(lastNameModifier), Modifier.isPrivate(lastNameModifier));
        }catch (Exception exception){
        }
    }

    public static void printPackage(){
        System.out.println("=============== printPackage() =================");
        Package packageObject = Person.class.getPackage();
        System.out.println(packageObject.getName());
    }

    public static void printSuperClass(){
        System.out.println("=============== printSuperClass() =================");
        Class<?> superClass = Student.class.getSuperclass();
        System.out.println(superClass.getName());
    }

    public static void allInterfaces(){
        System.out.println("=============== allInterfaces() =================");
        Class<?>[] interfaces = Student.class.getInterfaces();
        for(Class<?> everyInterface : interfaces){
            System.out.println(everyInterface.getName());
        }
    }

    public static void allConstructor(){
        System.out.println("=============== inspectingConstructor() =================");
        Constructor<?>[] constructors = Student.class.getConstructors();
        for(Constructor<?> constructor : constructors){
            System.out.println(constructor.getName());
        }
    }
}
