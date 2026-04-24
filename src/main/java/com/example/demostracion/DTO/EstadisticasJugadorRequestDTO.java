package com.example.demostracion.DTO;

import lombok.Data;

@Data
public class EstadisticasJugadorRequestDTO {

    private Long idJugador;
    private Long idPartido;

    private Integer minutosJugados;
    private Integer goles;
    private Integer asistencias;
    private Integer tarjetasAmarillas;
    private Integer tarjetasRojas;
}
