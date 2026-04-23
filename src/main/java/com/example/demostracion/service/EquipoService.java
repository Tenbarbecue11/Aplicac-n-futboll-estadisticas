package com.example.demostracion.service;

import com.example.demostracion.DTO.EquipoRequestDTO;
import com.example.demostracion.DTO.EquipoResponseDTO;

import java.util.List;

public interface EquipoService {
    EquipoResponseDTO guardarEquipo(EquipoRequestDTO request);
    List<EquipoResponseDTO> listarEquipos();
    EquipoResponseDTO buscarPorIdEquipo(long id);
    EquipoResponseDTO actualizarEquipo(long id, EquipoRequestDTO request);  // ✅ minúscula
    void eliminarEquipo(long id);  // ✅ minúscula
}