package com.example.demo.model;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "productos")

public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double price;

    // Nuevos campos private
    Integer stock;
    private Double costeFabricacion;

    // Relación con Categoría
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Category categoria;

    // Constructores, Getters, Setters

}
