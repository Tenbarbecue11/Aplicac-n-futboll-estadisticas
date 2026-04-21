package com.example.demostracion.service;

import com.example.demostracion.model.EstadisticasJugador;

public interface EstadisticasJugadorService {
    EstadisticasJugador guardarEstadisticas(EstadisticasJugador estadisticasJugador);
    EstadisticasJugador obtenerEstadisticas(long id);
    EstadisticasJugador ActualizarEstadisticas(long id,EstadisticasJugador estadisticasJugador);
    void EliminarEstadisticas(long id);
}
