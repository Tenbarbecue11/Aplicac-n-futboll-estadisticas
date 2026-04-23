package com.example.demostracion.service;

import com.example.demostracion.DTO.EstadisticasJugadorRequestDTO;
import com.example.demostracion.DTO.EstadisticasJugadorResponseDTO;
import com.example.demostracion.DTO.EstadisticasJugadorUpdateDTO;

public interface EstadisticasJugadorService {
    EstadisticasJugadorResponseDTO guardarEstadisticas(EstadisticasJugadorRequestDTO dto);
    EstadisticasJugadorResponseDTO obtenerEstadisticas(long id);
    EstadisticasJugadorResponseDTO ActualizarEstadisticas(long id, EstadisticasJugadorUpdateDTO dto);
    void EliminarEstadisticas(long id);
}
