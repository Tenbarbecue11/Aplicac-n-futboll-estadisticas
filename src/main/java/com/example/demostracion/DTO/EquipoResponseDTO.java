package com.example.demostracion.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipoResponseDTO {
    private Long id;
    private String nombre;
    private String ciudad;
    private String fecha;
    private List<JugadorResponseDTO> jugadores;  // ✅ lista limpia sin referencias circulares
}