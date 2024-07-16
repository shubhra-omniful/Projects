package com.masai.controller;

import com.masai.exception.ManagerException;
import com.masai.model.Manager;
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

@RestController
@RequestMapping("/managers")
public class ManagerController {

    @Autowired
    private ManagerService managerService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private OfficeService officeService;

    @PostMapping("/")
    public ResponseEntity<Manager> registerNewManager(@RequestBody Manager manager) throws ManagerException {
        Manager savedManager =  managerService.registerNewManager(manager);
        return new ResponseEntity<>(savedManager,HttpStatus.CREATED);
    }

}
