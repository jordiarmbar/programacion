package com.example.demo.controller;

import com.example.demo.dto.ProductCreateDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.services.CategoryService;
import com.example.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Product>> ProductList() {
        List<Product> products = productService.ProductList();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        Product p = productService.search(id);
        if (p != null) {
            return ResponseEntity.ok(p);
        }
        return ResponseEntity.notFound().build();
    }

    // Crear producto usando DTO de entrada (ProductoCreateDTO)
    @PostMapping
    public ResponseEntity<ProductDTO> createProducto(@RequestBody ProductCreateDTO dto) {
        // Convertir DTO -> Entidad
        Product p = new Product();
        p.setName(dto.getNombre());
        p.setPrice(dto.getPrecio());
        p.setStock(dto.getStock());
        p.setCosteFabricacion(dto.getCosteFabricacion());

        // Asignar categoría si se indica
        if (dto.getCategoriaId() != null) {
            Category c = categoryService.buscarCategoria(dto.getCategoriaId());
            p.setCategoria(c);
        }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product p) {
       Product created = productService.save(p);
       return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody Product product) {
            Product existente = productService.search(id);
            if (existente != null) {
                existente.setName(product.getName());
                existente.setPrice(product.getPrice());
                Product updated = productService.save(existente);
                return  ResponseEntity.ok(updated);
            }
            return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        boolean deleted = productService.delete(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


}