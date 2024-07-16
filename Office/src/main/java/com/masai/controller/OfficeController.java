package com.masai.controller;


import com.masai.exception.OfficeException;
import com.masai.model.Office;
import com.masai.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("offices")
public class OfficeController {

    @Autowired
    private OfficeService officeService;

    @PostMapping("/")
    public ResponseEntity<Office> registerNewOffice(@RequestBody Office office) throws OfficeException {
        Office savedOffice = officeService.registerNewOffice(office);
        return new ResponseEntity<>(savedOffice, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Office>> getOffices() throws OfficeException {
        List<Office> offices = officeService.getOffices();
        return new ResponseEntity<>(offices,HttpStatus.CREATED);
    }

}
