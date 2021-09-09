package com.aimprosoft.departments;

import com.aimprosoft.departments.dao.Dao;
import com.aimprosoft.departments.dao.impl.DepartmentsDao;
import com.aimprosoft.departments.entities.impl.Department;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApplicationStarter extends SpringBootServletInitializer {

    @Bean
    public Dao<Department> departmentDao(){
        return new DepartmentsDao();
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ApplicationStarter.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(ApplicationStarter.class, args);
    }
}
