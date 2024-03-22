package com.company;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {
    /*
         Di sini kita akan belajar menggunakan java Annotation (@).
         Annotation adalah syntax pada java yang digunakan untuk membuat metadata.
         Metadata sendiri artinya adalah informasi yang digunakan untuk memberikan keterangan pada data utamanya.
         (Note: sampa seperti C# attribute [])

         Metadata pada annotation sendiri tidak bisa diakses tanpa menggunakan teknik Reflection.
         Jadi sebelum mempelajari java annotation, ada baiknya developer memahami reflection terlebih dahulu.

         Annotation sendiri sangat berguna ketika untuk tech leader membuat atau meng-enhance suatu library atau framework.
         Java annotation dibagi menjadi beberapa kategori, di dalam sample project ini akan dijelaskan macam-macam metadata dan penggunaanya.
    */
    public static void main(String[] args) {
        obsoleteSample();
        markerAnnotation();
        singleValueAnnotation();
        fullAnnotations();
        fieldAnnotation();
        repeatableAnnotation();
    }

    /*
        Category 1: Built-In Annotation
        Built-In Annotation adalah annotation yang sudah ada di library core Java sejak JDK pertama kali di install.
        Kalian pasti sudah pernah menggunakan built-in annotation sebelumnya, contohnya seperti @Override.

        Selain @Override, ada beberapa built in annotation lagi, contohnya seperti:
        @SuppressWarning, @Deprecated, @SafeVarargs, @FunctionalInterface, @Native
    */
    /*
        @Deprecated adalah Built-In annotation yang digunakan untuk me-labelkan Constructor, Field, Variable, Method, Package, Parameter atau Data Type,
        kalau ini sudah deprecated / obsolete. Deprecated / Obsolete sendiri artinya adalah feature ketinggalan jaman yang walaupun masih berfungsi, tidak disarankan
        untuk masih dipakai. Dikarenakan berkembangnya aplikasi atau sebuah library, developer tidak bisa begitu saja menghapus feature yang obsolete, karena
        nantinya akan mengakibatkan bugs pada system legacy atau system yang sudah ketinggalan jaman tapi masih dipakai.

        Lahirnya feature baru harus ditambahkan tanpa menghapus feature lama, jadi lebih baik menggunakan @Deprecated untuk mengarahkan team memakai feature yang baru.
    */
    @Deprecated
    public static void obsoleteSample(){
        System.out.println("This function is obsolete");
    }

    /*
        Category 2: Marker Annotations
        Marker annotation adalah marker yang tidak memiliki member, karena tujuannya hanya untuk memberi tanda, antara ada atau
        tidak ada annotationnya. @Override dan @Deprecated termasuk ke dalam built-in marker annotation.

        Berikut ini adalah contoh menggunakan marker annotation.
    */
    public static void markerAnnotation(){
        System.out.println("===============markerAnnotation()================");
        Annotation supplierMarked = Supplier.class.getAnnotation(Marked.class);
        if(supplierMarked != null){
            System.out.println("Supplier class is marked");
        }

        Annotation productMarked = Product.class.getAnnotation(Marked.class);
        if(productMarked != null){
            System.out.println("Product class is marked");
        }
    }

    /*
        Category 3: Single value Annotations
        Single value annotations adalah anotasi yang hanya memiliki 1 member, jadi hanya membawa 1 value saja.
        Karena hanya membawa 1 value saja, kita tidak perlu memberikan nama pada membernya.
        Untuk memakai short hand notation ini (syntatic sugar), nama membernya harus "value".
    */
    public static void singleValueAnnotation(){
        System.out.println("===============singleValueAnnotation()================");
        Method[] methods = Supplier.class.getDeclaredMethods();
        for(Method method : methods){
            MethodType annotation = method.getAnnotation(MethodType.class);
            System.out.println(annotation.value());
        }
    }

    /*
        Category 4: Full Annotations
        Full annotations adalah annotation yang memiliki lebih dari satu member dengan nama member yang berbeda masing-masing.
        (Mirip seperti field)
    */
    public static void fullAnnotations(){
        System.out.println("===============fullAnnotations()================");
        EntityType entityType = OrderDetail.class.getAnnotation(EntityType.class);
        System.out.printf("Order Detail --> Database system %s, Relational type %s\n", entityType.databaseSystem(), entityType.relationalType());
        entityType = Order.class.getAnnotation(EntityType.class);
        System.out.printf("Order --> Database system %s, Relational type %s\n", entityType.databaseSystem(), entityType.relationalType());
        entityType = Supplier.class.getAnnotation(EntityType.class);
        System.out.printf("Supplier --> Database system %s, Relational type %s\n", entityType.databaseSystem(), entityType.relationalType());
    }

    public static void fieldAnnotation(){
        System.out.println("===============fieldAnnotation()================");
        Field[] fields = Product.class.getDeclaredFields();
        for(Field field : fields){
            Annotation annotation = field.getAnnotation(ColumnDataType.class);
            System.out.println(annotation.toString());
        }
    }

    /*
        Category 7: Repeatable Annotations
        Repeatable annotation adalah annotation yang bisa diaplikasikan berkali-kali pada satu element dengan jenis annotation yang sama.
        (Note: annotation yang lain tidak bisa diberikan berkali-kali pada element yang sama)
        Repeatable annotation simplenya adalah collection annotation, sehingga kita harus membuat 2 macam annotation, annotationnya itu sendiri dan containernya.
        Containernya berisikan collection dari annotation itu sendiri.
    */
    public static void repeatableAnnotation(){
        System.out.println("===============repeatableAnnotation()================");
        UpdateSchedule[] schedules = Product.class.getAnnotationsByType(UpdateSchedule.class);
        for(UpdateSchedule schedule : schedules){
            System.out.printf("%s-%s-%s\n", schedule.dayOfMonth(), schedule.month(), schedule.year());
        }
    }
}
