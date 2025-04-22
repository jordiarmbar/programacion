package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductCreateDTO {
    private String nombre;
    private Double precio;
    private Integer stock;
    private Double costeFabricacion;
    private Long categoriaId;

}
