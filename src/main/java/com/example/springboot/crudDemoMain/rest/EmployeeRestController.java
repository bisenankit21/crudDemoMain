package com.example.springboot.crudDemoMain.rest;

import com.example.springboot.crudDemoMain.dao.EmployeeDAO;
import com.example.springboot.crudDemoMain.entity.Employee;
import com.example.springboot.crudDemoMain.service.EmployeeService;
import com.example.springboot.crudDemoMain.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
   private EmployeeService employeeService;
@Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")

    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("employees/{employeeId}")
    public ResponseEntity<Employee> findEmployeebyId(@PathVariable int employeeId){
       Employee employee= employeeService.findById(employeeId);
    if(employee==null){
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    else {
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }
}


@PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
    //also just in case they pass an id in JSON ....set id to 0
    //this is to force a save of new item...instead of update
    employee.setId(0);
    Employee employee1=employeeService.save(employee);
    return employee1;
}

@PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
   return employeeService.save(employee);
}
@DeleteMapping("/employees/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int employeeId){
    Employee employee=employeeService.findById(employeeId);
    if(employee==null){
        throw  new RuntimeException("Emplotyee id Not found " + employeeId);
    }
    employeeService.deleteById(employeeId);
    return new ResponseEntity<>("Employee Deleted successfully", HttpStatus.OK);
}
}
