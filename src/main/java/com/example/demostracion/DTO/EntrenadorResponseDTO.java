package com.example.demostracion.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntrenadorResponseDTO {
    private Long id;
    private String nombre;
    private String especialidad;
    private Long idEquipo;
    private String nombreEquipo;  // ✅ solo el nombre, sin objeto anidado
}