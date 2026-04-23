package com.example.demostracion.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PartidoRequestDTO {
    private String fechadelPartido;  // ✅ String formato "2024-01-15"
    private String estadio;
    private Integer golesLocal;
    private Integer golesVisitante;
    private Long idEquipoLocal;      // ✅ solo el id
    private Long idEquipoVisitante;  // ✅ solo el id
}