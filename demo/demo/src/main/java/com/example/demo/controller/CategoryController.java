package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoryController {
    @Autowired
    private CategoryService categoryServiceService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category> listCategories() {

        return CategoryService.listCategories();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable Long id) {
        Category c = categoryService.buscarCategoria(id);
        if (c != null) {

            return ResponseEntity.ok(c);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Category crearCategoria(@RequestBody Category c) {
        return categoryService.guardarCategoria(c);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarCategoria(@PathVariable Long id)
    {
        boolean deleted = categoryService.deleteCategory(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}