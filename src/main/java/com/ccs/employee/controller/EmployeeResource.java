package com.ccs.employee.controller;

import com.ccs.employee.model.Employee;
import com.ccs.employee.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/employee")
@RequiredArgsConstructor
public class EmployeeResource {
    private final EmployeeService employeeService;
    @GetMapping("/employees")
    public ResponseEntity<Object> getAll(){
       return ResponseEntity.ok().body(employeeService.findAllEmployees());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id){
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.findById(id));
    }
    @PostMapping("/")
    public ResponseEntity<Object> findById(@RequestBody Employee employee){
        return ResponseEntity.ok().body(employeeService.addEmployee(employee));
    }
    @PutMapping("/")
    public ResponseEntity<Object> update(@RequestBody Employee employee){
        return ResponseEntity.ok().body(employeeService.updateEmployee(employee));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok().build();
    }

}
