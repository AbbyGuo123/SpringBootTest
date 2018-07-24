package com.oocl.employees.Service;

import com.oocl.employees.Model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    public Employee getEmployeesById(List<Employee> employees,int id){
        Employee employee = employees.stream().filter(e->e.getId()==id).collect(Collectors.toList()).get(0);
        return employee;
    }
    public List<Employee> addEmployee(List<Employee> employees,Employee employee){
        employees.add(employee);
        return employees;
    }
    public List<Employee> deleteEmployee(List<Employee> employees,int id){
        Employee employee = employees.stream().filter(e->e.getId()==id).collect(Collectors.toList()).get(0);
        employees.remove(employee);
        return employees;
    }
    public List<Employee> modifyEmployee(List<Employee> employees,Employee employee){
        Employee oldEmployee = employees.stream().filter(e->e.getId()==employee.getId()).collect(Collectors.toList()).get(0);
        employees.remove(oldEmployee);
        employees.add(employee);
        return employees;
    }

}
