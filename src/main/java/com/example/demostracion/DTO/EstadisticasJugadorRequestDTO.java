package com.example.demostracion.DTO;

import lombok.Data;

@Data
public class EstadisticasJugadorRequestDTO {

    private Long idJugador;
    private Long idPartido;

    private Integer minutosJugados;
    private Integer goles;
    private Integer asistecias;
    private Integer tarjetas_Amarillas;
    private Integer tarjetas_Rojas;
}
