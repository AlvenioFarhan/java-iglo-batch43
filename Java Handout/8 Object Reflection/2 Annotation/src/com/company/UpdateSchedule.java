package com.company;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/*
    Repeatable annotation di deklarasi dengan cara, membuat repeatable annotation beserta container annotationnya.
    Container annotation dari UpdateSchedule sendiri adalah UpdateSchedules.
*/
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(UpdateSchedules.class)
public @interface UpdateSchedule {
    public int dayOfMonth() default 1;
    public String month() default "January";
    public int year() default 1753;
}
