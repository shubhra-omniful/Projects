package com.masai.service;

import com.masai.model.Category;
import com.masai.repository.CategoryRepository;
import com.masai.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public String addCategory(Category category) {

        if ( category.getImages() != null ){
            category.getImages().forEach(image -> image.setCategory(category));
        }

        categoryRepository.save(category);
        return "category added";
    }
}
