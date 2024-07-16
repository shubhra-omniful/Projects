package com.masai.service;

import com.masai.exception.ProductException;
import com.masai.model.Product;

public interface ProductService {

    public String addProduct(Product product) throws ProductException;

}
