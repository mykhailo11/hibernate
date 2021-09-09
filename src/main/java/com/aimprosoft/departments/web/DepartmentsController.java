package com.aimprosoft.departments.web;

import com.aimprosoft.departments.dao.Dao;
import com.aimprosoft.departments.entities.impl.Department;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Departments")
public class DepartmentsController {

    private final Dao<Department> departmentDao;

    public DepartmentsController(Dao<Department> departmentDao){
        this.departmentDao = departmentDao;
    }
    @GetMapping
    public String getDepartments(Model model){
        model.addAttribute("departments", departmentDao.getAll());
        return "form";
    }
}
