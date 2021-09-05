package com.aimprosoft.departments;

import com.aimprosoft.departments.dao.Dao;
import com.aimprosoft.departments.dao.impl.DepartmentsDaoFactory;
import com.aimprosoft.departments.entities.impl.Department;

import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        Dao<Department> departmentsDao = DepartmentsDaoFactory.getDepartmentsDao();
        Department department = new Department();
        department.setTitle("Security");
        System.out.println(departmentsDao.edit(department));
        Collection<Department> departments = departmentsDao.getAll();
        for (Department department1 : departments){
            System.out.println(department1.toString());
        }
        System.out.println(departmentsDao.remove(department.getId()));
    }
}
