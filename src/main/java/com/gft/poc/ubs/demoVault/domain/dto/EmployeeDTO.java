package com.gft.poc.ubs.demoVault.domain.dto;

import com.gft.poc.ubs.demoVault.domain.entity.Employee;

public class EmployeeDTO {

    private Long id;
    private String name;
    private String gender;

    public EmployeeDTO(Employee employee) {
        this.id = employee.getId();
        this.name = employee.getName();
        this.gender = employee.getGender();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

}
