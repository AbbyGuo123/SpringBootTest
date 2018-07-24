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

    List<Employee> employees = new ArrayList<>();
    public EmployeesController() {
        employees.add(new Employee(1,"name1",1,"man"));
        employees.add(new Employee(2,"name2",2,"man"));
    }

    @GetMapping("")
    public List<Employee> getAllEmployees(){
        return employees;

    }

    @GetMapping("/{id}")
    public Employee getEmployeesById(@PathVariable int id){
        Employee employee = employees.stream().filter(e->e.getId()==id).collect(Collectors.toList()).get(0);
        return employee;
    }

    @PostMapping("")
    public List<Employee> addEmployee(@RequestBody Employee employee){
        employees.add(employee);
        return employees;
    }
    @DeleteMapping("/{id}")
    public List<Employee> deleteEmployee(@PathVariable int id){
        Employee employee = employees.stream().filter(e->e.getId()==id).collect(Collectors.toList()).get(0);
        employees.remove(employee);
        return employees;
    }

    @PatchMapping("")
    public List<Employee> modifyEmployee(@RequestBody Employee employee){
        Employee oldEmployee = employees.stream().filter(e->e.getId()==employee.getId()).collect(Collectors.toList()).get(0);
        employees.remove(oldEmployee);
        employees.add(employee);
        return employees;
    }

}
