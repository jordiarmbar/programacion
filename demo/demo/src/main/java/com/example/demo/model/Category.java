package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Category {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;

    // Relación bidireccional con Producto @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = true) private List<Producto> productos;
    // Constructores, Getters, Setters
}
