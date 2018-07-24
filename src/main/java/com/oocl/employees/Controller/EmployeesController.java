package com.oocl.employees.Controller;

import com.oocl.employees.Model.Employee;
import com.oocl.employees.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeesController {
    @Autowired
    private EmployeeService employeeService;

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
        Employee employee = employeeService.getEmployeesById(employees,id);
        return employee;
    }

    @PostMapping("")
    public List<Employee> addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employees,employee);
        return employees;
    }

    @DeleteMapping("/{id}")
    public List<Employee> deleteEmployee(@PathVariable int id){
        employeeService.deleteEmployee(employees,id);
        return employees;
    }

    @PatchMapping("")
    public List<Employee> modifyEmployee(@RequestBody Employee employee){
        employeeService.modifyEmployee(employees,employee);
        return employees;
    }

}
