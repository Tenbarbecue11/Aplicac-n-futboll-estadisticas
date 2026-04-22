package com.example.demostracion.service;

import com.example.demostracion.model.EstadisticasJugador;
import com.example.demostracion.repository.EstadisticasJugadorRepository;
import org.springframework.stereotype.Service;

@Service
public class EstadisticasJugadorServiceImp implements EstadisticasJugadorService{

    private final EstadisticasJugadorRepository estadisticasJugadorRepository;

    public EstadisticasJugadorServiceImp(EstadisticasJugadorRepository estadisticasJugadorRepository) {
        this.estadisticasJugadorRepository = estadisticasJugadorRepository;
    }

    @Override
    public EstadisticasJugador guardarEstadisticas(EstadisticasJugador estadisticasJugador) {
        return estadisticasJugadorRepository.save(estadisticasJugador);
    }

    @Override
    public EstadisticasJugador obtenerEstadisticas(long id) {
        return estadisticasJugadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("EstadisticasJugador no existe"));
    }

    @Override
    public EstadisticasJugador ActualizarEstadisticas(long id, EstadisticasJugador estadisticasJugador) {
        EstadisticasJugador existente=obtenerEstadisticas(id);

        existente.setMinutosJugados(estadisticasJugador.getMinutosJugados());
        existente.setGoles(estadisticasJugador.getGoles());
        existente.setAsistecias(estadisticasJugador.getAsistecias());
        existente.setTarjetas_Amarillas(estadisticasJugador.getTarjetas_Amarillas());
        existente.setTarjetas_Rojas(estadisticasJugador.getTarjetas_Rojas());
        return estadisticasJugadorRepository.save(existente);

    }

    @Override
    public void EliminarEstadisticas(long id) {
        obtenerEstadisticas(id);
        estadisticasJugadorRepository.deleteById(id);

    }
}
