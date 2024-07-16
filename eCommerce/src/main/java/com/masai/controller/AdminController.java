package com.masai.controller;

import com.masai.exception.MyError;
import com.masai.model.Category;
import com.masai.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/categories")
    public ResponseEntity<String> addCategory(@RequestBody Category category) {
        String addCategory = categoryService.addCategory(category);
        return new ResponseEntity<>(addCategory, HttpStatus.CREATED);
    }

}
