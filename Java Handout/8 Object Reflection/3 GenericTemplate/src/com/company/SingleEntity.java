package com.company;

public class SingleEntity<T> {
    //tidak bisa static
    public T entity;

    public SingleEntity(T entity) {
        this.entity = entity;
    }

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }
}
