package com.gft.poc.ubs.demoVault.controller;

import com.gft.poc.ubs.demoVault.domain.dto.EmployeeDTO;
import com.gft.poc.ubs.demoVault.domain.form.EmployeeForm;
import com.gft.poc.ubs.demoVault.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public List<EmployeeDTO> listAll() {
        return service.listAll();
    }

    @PostMapping()
    public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody @Valid EmployeeForm form) {
        EmployeeDTO savedDto = service.saveEmployee(form);
        return ResponseEntity.ok(savedDto);
    }

    @PostMapping("/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable Long id, @RequestBody @Valid EmployeeForm form) {
        EmployeeDTO dto;
        try {
            dto = service.updateEmployee(id, form);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(dto);
    }

}
