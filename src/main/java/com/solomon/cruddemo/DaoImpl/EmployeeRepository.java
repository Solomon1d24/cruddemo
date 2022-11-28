package com.solomon.cruddemo.DaoImpl;

import com.solomon.cruddemo.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
