package com.aimprosoft.departments.services;

import com.aimprosoft.departments.entities.Entity;

import java.util.Collection;

public interface DepartmentsService<E extends Entity> {
    Collection<E> getDepartments();
    E getDepartmentById(int id);

    int editDepartments(E... departments);
    int editDepartment(E department);

    int removeDepartments(int... ids);
    int removeDepartment(int id);

    E getEmployees();
}
