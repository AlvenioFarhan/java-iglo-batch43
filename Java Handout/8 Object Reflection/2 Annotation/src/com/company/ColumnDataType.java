package com.company;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ColumnDataType {
    public String name();
    public int length() default 0;
    public boolean nullable() default true;
    public String constraint() default "NO_CONSTRAINT";
}
