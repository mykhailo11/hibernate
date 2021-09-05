package com.aimprosoft.departments.dao.impl;

import com.aimprosoft.departments.dao.Dao;
import com.aimprosoft.departments.entities.impl.Employee;

public class EmployeesDaoFactory {

    private static Dao<Employee> employeesDao;

    private EmployeesDaoFactory(){}
    public static Dao<Employee> getEmployeesDao(){
        if (employeesDao == null){
            employeesDao = new EmployeesDao();
        }
        return employeesDao;
    }
}
