package com.example.springboot.crudDemoMain.service;

import com.example.springboot.crudDemoMain.dao.EmployeeDAO;
import com.example.springboot.crudDemoMain.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;
@Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeDAO.findById(id);
    }

    @Override
    @Transactional   //since we are modefying the database we will use annnotation at service layer
    public Employee save(Employee employee) {
        return employeeDAO.save(employee);
    }

    @Override
    @Transactional   //since we are modefying the database we will use annnotation at service layer
    public void deleteById(int id) {
      employeeDAO.deleteById(id);
    }
}
