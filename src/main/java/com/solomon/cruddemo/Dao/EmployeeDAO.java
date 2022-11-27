package com.solomon.cruddemo.Dao;

import com.solomon.cruddemo.Model.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> findAll();

    public Employee findEmployeeById(int index);

    public void updateEmployee(Employee employee);

    public void saveEmployee(Employee employee);

    public void deleteEmployee(Employee employee);

    public void deleteEmployeeById(int index);
}
