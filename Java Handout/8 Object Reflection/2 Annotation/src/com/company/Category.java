package com.company;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
* Contoh single value annotation yang hanya ditujukan kepada method, tetapi retention policynya hanya pada source code.
* Informasi category ini tidak akan bisa dibaca oleh reflection.
* */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.METHOD)
public @interface Category {
    public String value();
}
