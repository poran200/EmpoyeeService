package com.ccs.employee.services;

import com.ccs.employee.exception.ResourceNOtFound;
import com.ccs.employee.model.Employee;
import com.ccs.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();
    }
    public Employee updateEmployee(Employee employee){
        Employee emp = employeeRepository.getOne(employee.getId());
        employee.setId(emp.getId());
        return employeeRepository.save(employee);
    }
    public Employee findById(Long id) throws ResourceNOtFound {
        return  employeeRepository.findById(id).orElseThrow(()-> new ResourceNOtFound("Employee not found id: "+id));
    }
    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }
}
