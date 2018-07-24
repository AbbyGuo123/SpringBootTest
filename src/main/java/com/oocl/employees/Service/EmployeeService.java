package com.oocl.employees.Service;

import com.oocl.employees.Model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {
    public Employee getEmployeesById(List<Employee> employees, int id);
    public List<Employee> addEmployee(List<Employee> employees,Employee employee);
    public List<Employee> deleteEmployee(List<Employee> employees,int id);
    public List<Employee> modifyEmployee(List<Employee> employees,Employee employee);
}
