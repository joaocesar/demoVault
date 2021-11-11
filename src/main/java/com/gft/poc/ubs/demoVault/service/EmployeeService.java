package com.gft.poc.ubs.demoVault.service;

import com.gft.poc.ubs.demoVault.domain.dto.EmployeeDTO;
import com.gft.poc.ubs.demoVault.domain.entity.Employee;
import com.gft.poc.ubs.demoVault.domain.form.EmployeeForm;
import com.gft.poc.ubs.demoVault.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<EmployeeDTO> listAll() {
        List<Employee> employees = repository.findAll();
        return employees.stream().map(EmployeeDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public EmployeeDTO getEmployeeById(Long id) {
        return repository.findById(id).map(EmployeeDTO::new).orElse(null);
    }

    @Transactional
    public EmployeeDTO saveEmployee(EmployeeForm form) {
        Employee employee = repository.save(form.toEntity());
        return new EmployeeDTO(employee);
    }

    @Transactional
    public EmployeeDTO updateEmployee(Long id, EmployeeForm form) {
        Employee employee = repository.getById(id);
        if (Objects.isNull(employee)) {
            throw new EntityNotFoundException();
        }
        employee.setName(form.getName());
        employee.setGender(form.getGender());
        employee = repository.save(employee);
        return new EmployeeDTO(employee);
    }
}
