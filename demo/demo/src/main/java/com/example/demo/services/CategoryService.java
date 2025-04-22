package com.example.demo.services;

import com.example.demo.model.Category;

import com.example.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> listCategories() {
        return categoryRepository.findAll();
    }
    public Category buscarCategoria(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }
    public Category guardarCategoria(Category c) {
        return categoryRepository.save(c);
    }
    public boolean deleteCategory(Long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
