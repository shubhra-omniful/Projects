package com.masai.controller;

import com.masai.exception.EmployeeException;
import com.masai.model.Employee;
import com.masai.service.EmployeeService;
import com.masai.service.ManagerService;
import com.masai.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/employees")
@RestController
public class EmployeeController {

    @Autowired
    private OfficeService officeService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ManagerService managerService;

    @PostMapping("/")
    public ResponseEntity<Employee> registerNewEmployee(@RequestBody Employee employee) throws EmployeeException {
        Employee savedEmployee = employeeService.joinNewEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

}
