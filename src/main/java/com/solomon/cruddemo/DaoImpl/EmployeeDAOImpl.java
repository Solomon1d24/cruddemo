package com.solomon.cruddemo.DaoImpl;

import com.solomon.cruddemo.Dao.EmployeeDAO;
import com.solomon.cruddemo.Model.Employee;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("EmployeeDAOImpl")
public class EmployeeDAOImpl implements EmployeeDAO {
    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
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
    public Employee findEmployeeById(int index) throws EmptyResultDataAccessException {
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
    public void saveEmployee(Employee employee) {
        // create the session
        Session currentSession = this.entityManager.unwrap(Session.class);

        // let the session save or update
        currentSession.saveOrUpdate(employee);

        // log the action
        System.out.println(">> Save the employee " + employee.toString());

    }

    @Override
    public void updateEmployee(Employee employee) {
        // create the session
        Session currentSession = this.entityManager.unwrap(Session.class);
        // let the session save or update
        currentSession.saveOrUpdate(employee);
        // log the action
        System.out.println(">> Update the employee " + employee.toString());

    }

    @Override
    public void deleteEmployee(Employee employee) {
        // create the session
        Session currentSession = this.entityManager.unwrap(Session.class);
        // let the session delete the employee
        currentSession.remove(employee);
        // log the action
        System.out.println(">> Delete the employee " + employee.toString());
    }

    @Override
    public void deleteEmployeeById(int index){
        // create the session
        Session currentSession = this.entityManager.unwrap(Session.class);
        // create the query
        Query query = currentSession.createQuery("DELETE FROM Employee e WHERE e.id=:id");
        query.setParameter("id",index);
        // execute the query
        query.executeUpdate();
    }

}
