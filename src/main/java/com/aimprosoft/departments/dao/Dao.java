package com.aimprosoft.departments.dao;

import com.aimprosoft.departments.entities.Entity;

import java.util.Collection;

public interface Dao<E extends Entity> {
    Collection<E> getAll();
    E getById(int id);

    int edit(E entity);
    int editAll(E... entities);

    int remove(int id);
    int removeAll(int... ids);
}
