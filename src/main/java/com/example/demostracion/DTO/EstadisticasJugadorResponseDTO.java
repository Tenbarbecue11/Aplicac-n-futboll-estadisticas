package com.example.demostracion.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstadisticasJugadorResponseDTO {

    private Long id;
    private Integer minutosJugados;
    private Integer goles;
    private Integer asistecias;
    private Integer tarjetas_Amarillas;
    private Integer tarjetas_Rojas;

    private Long idJugador;
    private String nombreJugador;

    private Long idPartido;
}