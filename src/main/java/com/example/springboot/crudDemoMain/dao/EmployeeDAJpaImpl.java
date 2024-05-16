package com.example.springboot.crudDemoMain.dao;

import com.example.springboot.crudDemoMain.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAJpaImpl implements EmployeeDAO{
    //define field for entityManager
    private EntityManager entityManager;
@Autowired
    public EmployeeDAJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        //createQuery
        TypedQuery<Employee> query=entityManager.createQuery("from Employee", Employee.class);
        //execute query and get result list
        List<Employee> employees=query.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int id) {
        Employee employee=entityManager.find(Employee.class,id);
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        Employee employee1=entityManager.merge(employee);  //if id==0 them insert/save else update

        return  employee1;
    }

    @Override
    public void deleteById(int id) {
      Employee employee=entityManager.find(Employee.class,id);
      entityManager.remove(employee
      );
    }
}
