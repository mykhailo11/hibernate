package com.aimprosoft.departments.entities.impl;

import com.aimprosoft.departments.entities.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name = "employees")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee extends AbstractEntity {


    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer employeeId;

    @Override
    @JsonGetter("employee_id")
    public Integer getId() {
        return employeeId;
    }
    @Override
    @JsonSetter("employee_id")
    public void setId(Integer id){
        this.employeeId = id;
    }

    @Length(max = 20, min = 4, message = "The name must be 4-20 characters in length")
    @Pattern(regexp = "(^[A-Z])([a-zA-Z]+)", message = "The name is invalid")
    @NotNull(message = "The name is required")
    @Column(name = "first_name", length = 20, nullable = false)
    private String firstName;

    @Length(max = 20, min = 4, message = "The last name must be 4-20 characters in length")
    @Pattern(regexp = "(^[A-Z])([a-zA-Z]+)", message = "The last name is invalid")
    @NotNull(message = "The last name is required")
    @Column(name = "last_name", length = 20, nullable = false)
    private String lastName;

    @Column(name = "birth_date")
    @Past
    private Date birthDate;

    @Email(message = "Email is invalid")
    @Length(min = 5, max = 50, message = "The email must be 5-50 characters in length")
    @NotNull(message = "The email is required")
    @Column(name = "email", nullable = false, unique = true, length = 50)
    private String email;

    @Column(name = "phone", unique = true, length = 10)
    @Pattern(regexp = "\\d{9}",
            message = "The number must be 9 digits in length (without country code)")
    private String phone;

    @Column(name = "salary", length = 100)
    @Min(value = 0, message = "The salary must be greater or equal to zero")
    private Integer salary;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @JsonGetter("first_name")
    public String getFirstName() {
        return firstName;
    }
    @JsonGetter("last_name")
    public String getLastName(){
        return lastName;
    }
    @JsonGetter("birth_date")
    public long getBirthDate(){
        return birthDate.getTime();
    }
    @JsonGetter("email")
    public String getEmail(){
        return email;
    }
    @JsonGetter("phone")
    public String getPhone(){
        return phone;
    }
    @JsonGetter("salary")
    public Integer getSalary(){
        return salary;
    }
    @JsonGetter("department")
    public Department getDepartment(){
        return department;
    }
    @JsonSetter("first_name")
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    @JsonSetter("last_name")
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    @JsonSetter("birth_date")
    public void setBirthDate(long birthDate){
        this.birthDate = new Date(birthDate);
    }
    @JsonSetter("email")
    public void setEmail(String email){
        this.email = email;
    }
    @JsonSetter("phone")
    public void setPhone(String phone){
        this.phone = phone;
    }
    @JsonSetter("salary")
    public void setSalary(Integer salary){
        this.salary = salary;
    }
    @JsonSetter("department")
    public void setDepartment(Department department){
        this.department = department;
    }
}
