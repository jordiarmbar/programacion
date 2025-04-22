package com.example.demo.services;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;


    public List<Product> ProductList() {
        return productRepository.findAll();
    }

    public Product search(Long id) {
        Product p =productRepository.findById(id).orElse(null);
        return p;
    }

    public Product save(Product p) {
        return productRepository.save(p);
    }

    public boolean delete(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }
}