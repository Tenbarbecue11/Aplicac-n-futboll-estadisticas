package com.example.demostracion.service;

import com.example.demostracion.DTO.EquipoRequestDTO;
import com.example.demostracion.DTO.EquipoResponseDTO;
import com.example.demostracion.DTO.JugadorResponseDTO;
import com.example.demostracion.model.Equipo;
import com.example.demostracion.repository.EquipoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EquipoServiceImp implements EquipoService {

    private final EquipoRepository equipoRepository;

    public EquipoServiceImp(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }

    // ✅ Convierte Equipo -> EquipoResponseDTO con lista de jugadores
    private EquipoResponseDTO toResponse(Equipo e) {
        List<JugadorResponseDTO> jugadoresDTO = e.getJugadores()
                .stream()
                .map(j -> new JugadorResponseDTO(
                        j.getId(),
                        j.getNombre(),
                        j.getPosicion(),
                        j.getDorsal(),
                        j.getFechaNacimiento().toString(),
                        j.getNacionalidad(),
                        j.getEquipo().getId(),      // ✅ idEquipo
                        j.getEquipo().getNombre()   // ✅ nombreEquipo
                ))
                .collect(Collectors.toList());

        return new EquipoResponseDTO(
                e.getId(),
                e.getNombre(),
                e.getCiudad(),
                e.getFecha().toString(),
                jugadoresDTO
        );
    }

    @Override
    public EquipoResponseDTO guardarEquipo(EquipoRequestDTO request) {
        Equipo equipo = new Equipo();
        equipo.setNombre(request.getNombre());
        equipo.setCiudad(request.getCiudad());
        equipo.setFecha(LocalDate.parse(request.getFecha()));
        return toResponse(equipoRepository.save(equipo));
    }

    @Override
    public List<EquipoResponseDTO> listarEquipos() {
        return equipoRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public EquipoResponseDTO buscarPorIdEquipo(long id) {
        Equipo equipo = equipoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado"));
        return toResponse(equipo);
    }

    @Override
    public EquipoResponseDTO actualizarEquipo(long id, EquipoRequestDTO request) {
        Equipo existente = equipoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado"));
        if (request.getNombre() != null) {
            existente.setNombre(request.getNombre());
        }
        if (request.getCiudad() != null) {
            existente.setCiudad(request.getCiudad());
        }
        if (request.getFecha() != null) {
            existente.setFecha(LocalDate.parse(request.getFecha()));
        }
        return toResponse(equipoRepository.save(existente));
    }

    @Override
    public void eliminarEquipo(long id) {
        equipoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado"));
        equipoRepository.deleteById(id);
    }
}