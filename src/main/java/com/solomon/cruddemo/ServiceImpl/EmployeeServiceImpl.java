package com.solomon.cruddemo.ServiceImpl;

import com.solomon.cruddemo.Dao.EmployeeDAO;
import com.solomon.cruddemo.Model.Employee;
import com.solomon.cruddemo.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
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
    public Employee findEmployeeById(int index) throws EmptyResultDataAccessException {
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
    @Override
    @Transactional
    public void saveEmployee(Employee employee)
    {
        this.employeeDAO.saveEmployee(employee);
    }

    @Override
    @Transactional
    public void updateEmployee(Employee employee){
        this.employeeDAO.updateEmployee(employee);
    }
}
