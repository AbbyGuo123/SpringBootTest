package com.oocl.employees.ServiceImpl;

import com.oocl.employees.Model.Employee;
import com.oocl.employees.Service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

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
        for(int i=0;i<employees.size();i++){
            if(employees.get(i).getId()==employee.getId()){
                employees.get(i).setName(employee.getName());
                employees.get(i).setAge(employee.getAge());
                employees.get(i).setGender(employee.getGender());
            }
        }
        return employees;
    }

}
