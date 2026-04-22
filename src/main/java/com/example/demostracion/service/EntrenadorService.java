package com.example.demostracion.service;

import com.example.demostracion.DTO.EntrenadorRequestDTO;
import com.example.demostracion.DTO.EntrenadorResponseDTO;

import java.util.List;

public interface EntrenadorService {
    EntrenadorResponseDTO guardarEntrenador(EntrenadorRequestDTO request);
    List<EntrenadorResponseDTO> listarEntrenadores();
    EntrenadorResponseDTO buscarPorIdEntrenador(long id);
    EntrenadorResponseDTO actualizarEntrenador(long id, EntrenadorRequestDTO request);
    void eliminarEntrenador(long id);
}