package com.masai.service;

import com.masai.exception.OfficeException;
import com.masai.model.Office;
import com.masai.repository.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficeServiceImpl implements OfficeService{

    @Autowired
    private OfficeRepository officeRepository;

    @Override
    public Office registerNewOffice(Office office) throws OfficeException {
        if ( office == null) throw new OfficeException("Please provide office details");

        Office foundOffice = officeRepository.getOfficeByName(office.getName());
        if ( foundOffice != null ) throw new OfficeException("Office name : %s , already registered"+office.getName());

        return officeRepository.save(office);
    }

    @Override
    public List<Office> getOffices() throws OfficeException {
        List<Office> offices = officeRepository.findAll();
        if ( offices.isEmpty() ) throw new OfficeException("No office found");
        return offices;
    }
}
