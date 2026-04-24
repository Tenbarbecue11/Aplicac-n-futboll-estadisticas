package com.example.demostracion.DTO;

import lombok.Data;

@Data
public class EstadisticasJugadorUpdateDTO {

    private Integer minutosJugados;
    private Integer goles;
    private Integer asistencias;
    private Integer tarjetasAmarillas;
    private Integer tarjetasRojas;

}
