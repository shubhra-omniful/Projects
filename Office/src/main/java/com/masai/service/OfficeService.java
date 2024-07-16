package com.masai.service;

import com.masai.exception.OfficeException;
import com.masai.model.Office;

import java.util.List;

public interface OfficeService {
    Office registerNewOffice(Office office) throws OfficeException;
    List<Office> getOffices() throws OfficeException;
}
