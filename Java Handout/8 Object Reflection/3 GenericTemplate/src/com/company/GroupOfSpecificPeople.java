package com.company;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class GroupOfSpecificPeople<T> extends GroupOfSomething<T> {

    private List<String> methodNames = new ArrayList<>();

    public GroupOfSpecificPeople(List<T> items) {
        super(items);
        setMethodNames();
    }

    public void setMethodNames(){
        for(T item : this.getItems()){
            Method[] methods = item.getClass().getDeclaredMethods();
            for(Method method: methods){
                String info = String.format("Item Class: %s, Method Name: %s", item.getClass().getSimpleName(), method.getName());
                methodNames.add(info);
            }
        }
    }

    public void printAllMethodNames(){
        for(String methodName : methodNames){
            System.out.println(methodName);
        }
    }

}
