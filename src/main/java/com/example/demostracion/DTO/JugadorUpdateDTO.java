package com.example.demostracion.DTO;

import lombok.Data;

@Data
public class JugadorUpdateDTO {

    private String nombre;
    private String posicion;
    private Integer dorsal;
    private String nacionalidad;
    private Long idEquipo;
}