package com.masai.controller;

import com.masai.exception.ProductException;
import com.masai.model.Product;
import com.masai.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sellers")
public class SellerController {

    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    private ResponseEntity<String> addProduct(@RequestBody Product product) throws ProductException {
        String addProduct = productService.addProduct(product);
        return new ResponseEntity<>(addProduct, HttpStatus.CREATED);
    }

}
