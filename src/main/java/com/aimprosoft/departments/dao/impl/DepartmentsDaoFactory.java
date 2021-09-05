package com.aimprosoft.departments.dao.impl;

import com.aimprosoft.departments.dao.Dao;
import com.aimprosoft.departments.entities.impl.Department;

public class DepartmentsDaoFactory {

    private static Dao<Department> departmentsDao;

    private DepartmentsDaoFactory(){}
    public static Dao<Department> getDepartmentsDao(){
        if (departmentsDao == null){
            departmentsDao = new DepartmentsDao();
        }
        return departmentsDao;
    }
}
