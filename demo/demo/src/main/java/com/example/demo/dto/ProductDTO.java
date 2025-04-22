package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long id;
    private String nombre;
    private Double precio;
    // Nombre de la categoría en lugar del id
    private String categoriaNombre;
// Getters y Setters
}
