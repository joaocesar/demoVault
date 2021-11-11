package com.gft.poc.ubs.demoVault.repository;

import com.gft.poc.ubs.demoVault.domain.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
