package com.example.demostracion.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PartidoResponseDTO {
    private Long id;
    private String fechadelPartido;   // ✅ LocalDate -> String
    private String estadio;
    private Integer golesLocal;
    private Integer golesVisitante;
    private Long idEquipoLocal;       // ✅ solo el id
    private Long idEquipoVisitante;   // ✅ solo el id
    private String nombreEquipoLocal;      // ✅ nombre para mostrar
    private String nombreEquipoVisitante;  // ✅ nombre para mostrar
}