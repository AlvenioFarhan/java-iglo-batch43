package com.company;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/*Generic template juga bisa diaplikasikan kepada class.*/
public class GroupOfSomething<T> {
    private List<T> items = new ArrayList<>();
    private List<String> fieldNames = new ArrayList<>();

    public GroupOfSomething(List<T> items) {
        this.items = items;
        setFieldNames();
    }

    public List<T> getItems() {
        return items;
    }

    public void setFieldNames(){
        for(T item : this.items){
            /*Pada java kita tidak bisa mengambil langsung class atau type dari <T>, dikarenakan
              informasi generic type tidak bisa di dapat dari <T> di saat run time. */
            Field[] fields = item.getClass().getDeclaredFields();
            for(Field field: fields){
                String info = String.format("Item Class: %s, Field Name: %s", item.getClass().getSimpleName(), field.getName());
                fieldNames.add(info);
            }
        }
    }

    public void printAllSelectedField(String fieldName){
        System.out.printf("Printing: %s\n", fieldName);
        for(T item : items){
            try{
                Field selectedField = item.getClass().getSuperclass().getDeclaredField(fieldName);
                selectedField.setAccessible(true);
                Object value = selectedField.get(item);
                System.out.printf("Field Name: %s, Value: %s\n", selectedField.getName(), value.toString());
            }catch (Exception exception){}
        }
    }

    public void printAllFieldNames(){
        for(String fieldName : fieldNames){
            System.out.println(fieldName);
        }
    }
}
