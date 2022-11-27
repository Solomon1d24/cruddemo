package com.solomon.cruddemo.ServiceImpl;

import com.solomon.cruddemo.Dao.EmployeeDAO;
import com.solomon.cruddemo.Model.Employee;
import com.solomon.cruddemo.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    @Transactional
    public List<Employee> findAll() {
        return this.employeeDAO.findAll();
    }

    @Override
    @Transactional
    public Employee findEmployeeById(int index) {
        return this.employeeDAO.findEmployeeById(index);
    }

    @Override
    @Transactional
    public void addEmployee(Employee employee) {
        this.employeeDAO.saveEmployee(employee);
    }

    @Override
    @Transactional
    public void deleteEmployeeById(int index) {
        this.employeeDAO.deleteEmployeeById(index);
    }
}
