package com.solomon.cruddemo.Service;

import com.solomon.cruddemo.Model.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();

    public Employee findEmployeeById(int index);

    public void addEmployee(Employee employee);

    public void deleteEmployeeById(int index);

    public void saveEmployee(Employee employee);

    public void updateEmployee(Employee employee);

}
