package com.employeemangement.employee.services;

import java.util.List;

import com.employeemangement.employee.model.Employee;

public interface EmployeeService{

    Employee createEmployee(Employee employee);

    List<Employee> getAllEmployees();

    boolean deleteEmployee(Long id);


    
}
