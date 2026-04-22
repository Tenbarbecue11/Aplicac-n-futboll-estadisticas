package com.example.demostracion.service;

import com.example.demostracion.DTO.EntrenadorRequestDTO;
import com.example.demostracion.DTO.EntrenadorResponseDTO;
import com.example.demostracion.model.Entrenador;
import com.example.demostracion.model.Equipo;
import com.example.demostracion.repository.EntrenadorRepository;
import com.example.demostracion.repository.EquipoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntrenadorServiceImp implements EntrenadorService {

    private final EntrenadorRepository entrenadorRepository;
    private final EquipoRepository equipoRepository;  // ✅ necesario para buscar el equipo

    public EntrenadorServiceImp(EntrenadorRepository entrenadorRepository,
                                EquipoRepository equipoRepository) {
        this.entrenadorRepository = entrenadorRepository;
        this.equipoRepository = equipoRepository;
    }

    // ✅ Convierte Entrenador -> EntrenadorResponseDTO
    private EntrenadorResponseDTO toResponse(Entrenador e) {
        return new EntrenadorResponseDTO(
                e.getId(),
                e.getNombre(),
                e.getEspecialidad(),
                e.getEquipo().getId(),
                e.getEquipo().getNombre()
        );
    }

    @Override
    public EntrenadorResponseDTO guardarEntrenador(EntrenadorRequestDTO request) {
        Equipo equipo = equipoRepository.findById(request.getIdEquipo())
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado"));

        Entrenador entrenador = new Entrenador();
        entrenador.setNombre(request.getNombre());
        entrenador.setEspecialidad(request.getEspecialidad());
        entrenador.setEquipo(equipo);

        return toResponse(entrenadorRepository.save(entrenador));
    }

    @Override
    public List<EntrenadorResponseDTO> listarEntrenadores() {
        return entrenadorRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public EntrenadorResponseDTO buscarPorIdEntrenador(long id) {
        Entrenador entrenador = entrenadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entrenador no encontrado"));
        return toResponse(entrenador);
    }

    @Override
    public EntrenadorResponseDTO actualizarEntrenador(long id, EntrenadorRequestDTO request) {
        Entrenador existente = entrenadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entrenador no encontrado"));

        Equipo equipo = equipoRepository.findById(request.getIdEquipo())
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado"));

        existente.setNombre(request.getNombre());
        existente.setEspecialidad(request.getEspecialidad());
        existente.setEquipo(equipo);

        return toResponse(entrenadorRepository.save(existente));
    }

    @Override
    public void eliminarEntrenador(long id) {
        entrenadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entrenador no encontrado"));
        entrenadorRepository.deleteById(id);
    }
}