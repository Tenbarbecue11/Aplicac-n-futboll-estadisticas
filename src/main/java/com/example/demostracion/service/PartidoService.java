package com.example.demostracion.service;

import com.example.demostracion.DTO.PartidoRequestDTO;
import com.example.demostracion.DTO.PartidoResponseDTO;

import java.util.List;

public interface PartidoService {
    PartidoResponseDTO guardarPartido(PartidoRequestDTO request);
    List<PartidoResponseDTO> listarPartidos();
    PartidoResponseDTO buscarPartido(long id);
    PartidoResponseDTO actualizarPartido(long id, PartidoRequestDTO request);
    void eliminarPartido(long id);

    // ✅ estos no cambian porque no devuelven Partido
    Integer totalGolesEquipo(Long id);
    List<Object[]> resultadosPartidos();
}