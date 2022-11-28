package com.solomon.cruddemo.Controller;

import com.solomon.cruddemo.Exception.EmployeeNotFoundException;
import com.solomon.cruddemo.Model.Employee;
import com.solomon.cruddemo.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return this.employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId) {
        try {
            Employee employee = this.employeeService.findEmployeeById(employeeId);
        } catch (EmptyResultDataAccessException emptyResultDataAccessException){
            throw new EmployeeNotFoundException("Employee with id " + employeeId + " is not found in the database");
        }
        return this.employeeService.findEmployeeById(employeeId);
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee) {
        employee.setId(0);
        this.employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        this.employeeService.updateEmployee(employee);
        return employee;
    }


    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {

        try {
            Employee employee = this.employeeService.findEmployeeById(employeeId);
        } catch (EmptyResultDataAccessException emptyResultDataAccessException){
            throw new EmployeeNotFoundException("Employee with id " + employeeId + " is not found in the database");
        }

        this.employeeService.deleteEmployeeById(employeeId);

        return "Employee with id " + employeeId + " is deleted from the database";

    }


}
