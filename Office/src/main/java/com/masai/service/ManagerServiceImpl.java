package com.masai.service;

import com.masai.exception.ManagerException;
import com.masai.model.Manager;
import com.masai.model.Office;
import com.masai.repository.ManagerRepository;
import com.masai.repository.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ManagerServiceImpl implements ManagerService{

    @Autowired
    private OfficeRepository officeRepository;
    @Autowired
    private ManagerRepository managerRepository;

    @Override
    public Manager registerNewManager(Manager manager) throws ManagerException {
        if ( manager == null) throw new ManagerException("Please valid details for manager");

        if ( manager.getOffice() == null ) throw new ManagerException("Please provide valid office id");

        Optional<Office> optionalOffice = officeRepository.findById(manager.getOffice().getId());
        if ( optionalOffice.isEmpty()) throw new ManagerException("Please provide valid office ID");

        manager.setOffice(optionalOffice.get());
        return managerRepository.save(manager);
    }
}
