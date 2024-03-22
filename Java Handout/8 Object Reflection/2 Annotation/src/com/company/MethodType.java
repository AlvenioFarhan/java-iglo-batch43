package com.company;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
    Ini adalah contoh dari Single Value Annotation.
    Di annotation ini juga diberikan @TargetAnnotation, target annotation berfungsi untuk memberikan setting
    untuk annotation ini bisa digunakan pada element apa saja.
*/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
public @interface MethodType {
    public String value();
}
