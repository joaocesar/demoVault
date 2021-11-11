package com.gft.poc.ubs.demoVault.domain.form;

import com.gft.poc.ubs.demoVault.domain.entity.Employee;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EmployeeForm {

    @NotNull @NotEmpty @Size(max = 100)
    private String name;
    @NotNull @NotEmpty @Size(min = 1, max = 1)
    private String gender;

    public EmployeeForm() {
    }

    public EmployeeForm(Employee employee) {
        this.name = employee.getName();
        this.gender = employee.getGender();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Employee toEntity() {
        Employee employee = new Employee();
        employee.setName(getName());
        employee.setGender(getGender());
        return  employee;
    }

}
