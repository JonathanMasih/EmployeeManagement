package com.employeemangement.employee.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.employeemangement.employee.entity.EmployeeEntity;
import com.employeemangement.employee.model.Employee;
import com.employeemangement.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;

    }
    
    @Override
    public Employee createEmployee(Employee employee) {
        EmployeeEntity employeeEntity =  new EmployeeEntity();

        BeanUtils.copyProperties(employee, employeeEntity);
        employeeRepository.save(employeeEntity);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> employeesEntities = employeeRepository.findAll();

        List<Employee> employees = employeesEntities
        .stream()
        .map(emp -> new Employee(
                emp.getId(),
                emp.getFirstName(),
                emp.getLastName(),
                emp.getEmailId()))
        .collect(Collectors.toList());

        return employees;
    }

    @Override
    public boolean deleteEmployee(Long id) {
       EmployeeEntity employee = employeeRepository.findById(id).get();
       employeeRepository.delete(employee);
       return true;
    }



}
