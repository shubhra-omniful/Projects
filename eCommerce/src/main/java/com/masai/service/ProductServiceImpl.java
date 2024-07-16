package com.masai.service;

import com.masai.exception.ProductException;
import com.masai.model.Category;
import com.masai.model.Product;
import com.masai.repository.CategoryRepository;
import com.masai.repository.ImageRepository;
import com.masai.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ImageRepository imageRepository;


    @Override
    public String addProduct(Product product) throws ProductException {

        if ( product.getCategoryID() == null || product.getCategoryID() <= 0 ){
            throw new ProductException("Please enter category ID");
        }

        Optional<Category> categoryOptional = categoryRepository.findById(product.getCategoryID());
        if ( categoryOptional.isEmpty()  ) throw new ProductException("Category not found");

        if ( product.getImages() != null  ){
            product.getImages().forEach( image -> image.setProduct(product));
        }

        product.setCategory(categoryOptional.get());
        productRepository.save(product);
        return "Product added";
    }
}
