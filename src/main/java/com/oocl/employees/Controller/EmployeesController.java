package com.oocl.employees.Controller;

import com.oocl.employees.Model.Employee;
import com.oocl.employees.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
public class EmployeesController {
//    @Autowired
//    private EmployeeService employeeService;

    @GetMapping("/getAllEmployees")
    public List<Employee> getAllEmployees(){
        List<Employee> employees = initEmployee();
        return employees;

    }

    @GetMapping("/getEmployeesById")
    public Employee getEmployeesById(@RequestBody int id){
        List<Employee> employees = initEmployee();
        Employee employee = employees.stream().filter(e->e.getId()==id).collect(Collectors.toList()).get(0);
        return employee;

    }


    public List<Employee> initEmployee(){
        Employee employee = new Employee(1,"name",1,"man");
        List<Employee> list = new ArrayList<>();
        list.add(employee);
        return list;
    }
}
