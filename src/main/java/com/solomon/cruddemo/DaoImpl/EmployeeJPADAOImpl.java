package com.solomon.cruddemo.DaoImpl;

import com.solomon.cruddemo.Dao.EmployeeDAO;
import com.solomon.cruddemo.Model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("EmployeeJPADAOImpl")
public class EmployeeJPADAOImpl implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeJPADAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = this.entityManager.createQuery("FROM Employee e", Employee.class);

        List<Employee> employeeList = query.getResultList();

        return employeeList;
    }

    @Override
    public Employee findEmployeeById(int index) {
        Employee employee = this.entityManager.find(Employee.class, index);
        return employee;
    }

    @Override
    public void updateEmployee(Employee employee) {
        this.entityManager.merge(employee);
    }

    @Override
    public void saveEmployee(Employee employee) {
        Employee employee1 = this.entityManager.merge(employee);
        employee.setId(employee1.getId());
    }

    @Override
    public void deleteEmployee(Employee employee) {
        this.entityManager.remove(employee);
    }

    @Override
    public void deleteEmployeeById(int index) {
        Query query = this.entityManager.createQuery("DELETE FROM Employee e WHERE e.id=:employeeId");
        query.setParameter("employeeId", index);
        query.executeUpdate();
    }
}
