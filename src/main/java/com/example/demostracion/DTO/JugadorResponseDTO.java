package com.example.demostracion.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JugadorResponseDTO {
    private Long id;
    private String nombre;
    private String posicion;
    private Integer dorsal;
    private String fechaNacimiento;
    private String nacionalidad;
    private Long idEquipo;        // ✅ para filtrar por equipo
    private String nombreEquipo;  // ✅ para mostrar en pantalla
}