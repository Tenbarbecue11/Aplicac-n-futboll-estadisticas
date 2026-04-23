package com.example.demostracion.DTO;

import lombok.Data;

@Data
public class EstadisticasJugadorUpdateDTO {

    private Integer minutosJugados;
    private Integer goles;
    private Integer asistecias;
    private Integer tarjetas_Amarillas;
    private Integer tarjetas_Rojas;

}
