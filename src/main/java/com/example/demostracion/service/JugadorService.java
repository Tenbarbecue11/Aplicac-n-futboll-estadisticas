package com.example.demostracion.service;

import com.example.demostracion.DTO.JugadorRequestDTO;
import com.example.demostracion.DTO.JugadorResponseDTO;

import java.util.List;

public interface JugadorService {
    JugadorResponseDTO guardarJugador(JugadorRequestDTO request);
    List<JugadorResponseDTO> listarJugadores();
    JugadorResponseDTO buscarJugadorPorId(long id);
    JugadorResponseDTO actualizarJugador(long id, JugadorRequestDTO request);
    void eliminarJugador(long id);
    List<JugadorResponseDTO> jugadoresPorEquipo(Long id);
    List<JugadorResponseDTO> jugadoresConMasDeXGoles(int goles);
}