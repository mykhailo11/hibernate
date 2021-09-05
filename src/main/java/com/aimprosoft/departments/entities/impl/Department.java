package com.aimprosoft.departments.entities.impl;

import com.aimprosoft.departments.entities.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "departments")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Department extends AbstractEntity {

    @Id
    @Column(name = "department_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer departmentId;

    @Override
    @JsonGetter("department_id")
    public Integer getId() {
        return departmentId;
    }
    @Override
    @JsonSetter("department_id")
    public void setId(Integer id){
        this.departmentId = id;
    }

    @Length(max = 30, min = 4, message = "The title must be 4-30 characters in length")
    @Pattern(regexp = "(^[A-Z])([a-zA-Z]+)", message = "The title is invalid")
    @Column(name = "title", unique = true, nullable = false)
    private String title;

    @JsonGetter("title")
    public String getTitle(){
        return title;
    }
    @JsonSetter("title")
    public void setTitle(String title){
        this.title = title;
    }
}
