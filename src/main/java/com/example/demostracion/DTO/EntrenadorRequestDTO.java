package com.example.demostracion.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntrenadorRequestDTO {
    private String nombre;
    private String especialidad;
    private Long idEquipo;  // ✅ solo el id para asociar el equipo
}