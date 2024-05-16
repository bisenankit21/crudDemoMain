package com.example.springboot.crudDemoMain.dao;

import com.example.springboot.crudDemoMain.entity.Employee;
import org.antlr.v4.runtime.atn.EmptyPredictionContext;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    void deleteById(int id);


}
