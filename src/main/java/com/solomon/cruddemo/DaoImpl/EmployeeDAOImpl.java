package com.solomon.cruddemo.DaoImpl;

import com.solomon.cruddemo.Dao.EmployeeDAO;
import com.solomon.cruddemo.Model.Employee;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {

        // get the current session
        Session currentSession = this.entityManager.unwrap(Session.class);

        // create the query
        Query<Employee> query = currentSession.createQuery("FROM Employee e", Employee.class);

        // execute the query and get the result list
        List<Employee> employeeList = query.getResultList();

        // return the result set

        return employeeList;
    }

    @Override
    @Transactional
    public Employee findEmployeeById(int index) {
        // Get the current session
        Session currentSession = this.entityManager.unwrap(Session.class);


        // create the query
        Query<Employee> query = currentSession.createQuery("FROM Employee e WHERE e.id=:index");

        query.setParameter("index", index);

        // execute the query and get the result list
        Employee employee = query.getSingleResult();

        // return the result set
        return employee;
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        // create the session
        Session currentSession = this.entityManager.unwrap(Session.class);

        // let the session save or update
        currentSession.persist(employee);

        // log the action
        System.out.println(">> Save the employee " + employee.toString());

    }

    @Override
    @Transactional
    public void updateEmployee(Employee employee) {
        // create the session
        Session currentSession = this.entityManager.unwrap(Session.class);
        // let the session save or update
        currentSession.merge(employee);
        // log the action
        System.out.println(">> Update the employee " + employee.toString());

    }

    @Override
    @Transactional
    public void deleteEmployee(Employee employee) {
        // create the session
        Session currentSession = this.entityManager.unwrap(Session.class);
        // let the session delete the employee
        currentSession.remove(employee);
        // log the action
        System.out.println(">> Delete the employee " + employee.toString());
    }
}
