package com.company;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
    Container annotation berisikan collection dari repeatable annotation.
    Pada container ini juga, kita mendeklarasikan Targetnya.
*/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface UpdateSchedules {
    UpdateSchedule[] value();
}
