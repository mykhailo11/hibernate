package com.aimprosoft.departments.services;

import com.aimprosoft.departments.entities.Entity;

import java.util.Collection;

public interface EmployeesService<E extends Entity> {
    Collection<E> getEmployees();
    E getEmployeeById(int id);

    int editEmployees(E... employees);
    int editEmployee(E employee);

    int removeEmployees(int... ids);
    int removeEmployee(int id);
}
