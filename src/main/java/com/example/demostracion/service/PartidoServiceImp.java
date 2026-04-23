package com.example.demostracion.service;

import com.example.demostracion.DTO.PartidoRequestDTO;
import com.example.demostracion.DTO.PartidoResponseDTO;
import com.example.demostracion.model.Equipo;
import com.example.demostracion.model.Partido;
import com.example.demostracion.repository.EquipoRepository;
import com.example.demostracion.repository.PartidoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PartidoServiceImp implements PartidoService {

    private final PartidoRepository partidoRepository;
    private final EquipoRepository equipoRepository;

    public PartidoServiceImp(PartidoRepository partidoRepository,
                             EquipoRepository equipoRepository) {
        this.partidoRepository = partidoRepository;
        this.equipoRepository = equipoRepository;
    }

    private PartidoResponseDTO toResponse(Partido p) {
        return new PartidoResponseDTO(
                p.getId(),
                p.getFechadelPartido().toString(),
                p.getEstadio(),
                p.getGolesLocal(),
                p.getGolesVisitante(),
                p.getEquipoLocal().getId(),
                p.getEquipoVisitante().getId(),
                p.getEquipoLocal().getNombre(),
                p.getEquipoVisitante().getNombre()
        );
    }

    @Override
    public PartidoResponseDTO guardarPartido(PartidoRequestDTO request) {
        Equipo local = equipoRepository.findById(request.getIdEquipoLocal())
                .orElseThrow(() -> new RuntimeException("Equipo local no encontrado"));
        Equipo visitante = equipoRepository.findById(request.getIdEquipoVisitante())
                .orElseThrow(() -> new RuntimeException("Equipo visitante no encontrado"));

        Partido partido = new Partido();
        partido.setFechadelPartido(LocalDate.parse(request.getFechadelPartido()));
        partido.setEstadio(request.getEstadio());
        partido.setGolesLocal(request.getGolesLocal());
        partido.setGolesVisitante(request.getGolesVisitante());
        partido.setEquipoLocal(local);
        partido.setEquipoVisitante(visitante);

        return toResponse(partidoRepository.save(partido));
    }

    @Override
    public List<PartidoResponseDTO> listarPartidos() {
        return partidoRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public PartidoResponseDTO buscarPartido(long id) {
        Partido partido = partidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Partido no encontrado"));
        return toResponse(partido);
    }

    @Override
    public PartidoResponseDTO actualizarPartido(long id, PartidoRequestDTO request) {
        Partido existente = partidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Partido no encontrado"));

        if (request.getFechadelPartido() != null) {
            existente.setFechadelPartido(LocalDate.parse(request.getFechadelPartido()));
        }
        if (request.getEstadio() != null) {
            existente.setEstadio(request.getEstadio());
        }
        if (request.getGolesLocal() != null) {
            existente.setGolesLocal(request.getGolesLocal());
        }
        if (request.getGolesVisitante() != null) {
            existente.setGolesVisitante(request.getGolesVisitante());
        }
        if (request.getIdEquipoLocal() != null) {
            Equipo local = equipoRepository.findById(request.getIdEquipoLocal())
                    .orElseThrow(() -> new RuntimeException("Equipo local no encontrado"));
            existente.setEquipoLocal(local);
        }
        if (request.getIdEquipoVisitante() != null) {
            Equipo visitante = equipoRepository.findById(request.getIdEquipoVisitante())
                    .orElseThrow(() -> new RuntimeException("Equipo visitante no encontrado"));
            existente.setEquipoVisitante(visitante);
        }

        return toResponse(partidoRepository.save(existente));
    }

    @Override
    public void eliminarPartido(long id) {
        partidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Partido no encontrado"));
        partidoRepository.deleteById(id);
    }

    @Override
    public Integer totalGolesEquipo(Long id) {
        return partidoRepository.totalGolesEquipo(id);
    }

    @Override
    public List<Object[]> resultadosPartidos() {
        return partidoRepository.resultadosPartidos();
    }
}