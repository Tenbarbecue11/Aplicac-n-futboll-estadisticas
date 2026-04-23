package com.example.demostracion.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JugadorRequestDTO {
    private String nombre;
    private String posicion;
    private Integer dorsal;
    private String fechaNacimiento;  // ✅ String formato "2024-01-15"
    private String nacionalidad;
    private Long idEquipo;           // ✅ solo el id para asociar el equipo
}