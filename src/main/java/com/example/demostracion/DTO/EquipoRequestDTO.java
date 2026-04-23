package com.example.demostracion.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipoRequestDTO {
    private String nombre;
    private String ciudad;
    private String fecha;
}