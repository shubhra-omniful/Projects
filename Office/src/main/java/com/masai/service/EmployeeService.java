package com.masai.service;

import com.masai.exception.EmployeeException;
import com.masai.model.Employee;

public interface EmployeeService {

    Employee joinNewEmployee(Employee employee) throws EmployeeException;

}
