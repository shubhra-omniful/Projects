package com.masai.service;

import com.masai.exception.EmployeeException;
import com.masai.model.Employee;
import com.masai.model.Manager;
import com.masai.model.Office;
import com.masai.repository.EmployeeRepository;
import com.masai.repository.ManagerRepository;
import com.masai.repository.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class EmployeeServiceImpl implements EmployeeService{


    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private OfficeRepository officeRepository;

    @Override
    public Employee joinNewEmployee(Employee employee) throws EmployeeException {
        if ( employee.getOffice() == null ) throw new EmployeeException("Please provide office details");

        if ( employee.getManager() == null ) throw new EmployeeException("Please provide manager details");


        String officeName = employee.getOffice().getName();
        Office office = officeRepository.getOfficeByName(officeName);
        if (office.getId() == 0) throw new EmployeeException("No office found given name "+officeName);


        Integer managerID = employee.getManager().getId();
        Optional<Manager> foundManager = managerRepository.findById(managerID);
        if (foundManager.isEmpty()) throw new EmployeeException("No manager found given ID "+managerID);

        Manager manager = foundManager.get();

        if (!office.getId().equals(manager.getOffice().getId())) throw new EmployeeException("Office with manager id are not mismatched");

        employee.setManager(manager);
        employee.setOffice(office);
        return employeeRepository.save(employee);
    }
}
