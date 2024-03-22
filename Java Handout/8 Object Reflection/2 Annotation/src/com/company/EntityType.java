package com.company;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
    Contoh full annotation dengan 2 member.
    di sini juga dicontohkan apabila ingin menggunakan default value.

    Category 5: Meta-Annotations
    Baik @Target, @Retention, @Repeateable, adalah macam-macam meta annotation, atau
    bisa dibilang adalah annotation yang diberikan targetnya untuk annotation lain.
*/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface EntityType {
    public String databaseSystem() default "Master";
    public String relationalType() default "Header";
}
