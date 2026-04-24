package com.example.demostracion.service;

import com.example.demostracion.DTO.EstadisticasJugadorRequestDTO;
import com.example.demostracion.DTO.EstadisticasJugadorResponseDTO;
import com.example.demostracion.DTO.EstadisticasJugadorUpdateDTO;
import com.example.demostracion.model.EstadisticasJugador;
import com.example.demostracion.model.Jugador;
import com.example.demostracion.model.Partido;
import com.example.demostracion.repository.EstadisticasJugadorRepository;
import com.example.demostracion.repository.JugadorRepository;
import com.example.demostracion.repository.PartidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadisticasJugadorServiceImp implements EstadisticasJugadorService{

    private final EstadisticasJugadorRepository estadisticasJugadorRepository;
    private final JugadorRepository jugadorRepository;
    private final PartidoRepository partidoRepository;

    public EstadisticasJugadorServiceImp(EstadisticasJugadorRepository estadisticasJugadorRepository, JugadorRepository jugadorRepository, PartidoRepository partidoRepository) {
        this.estadisticasJugadorRepository = estadisticasJugadorRepository;
        this.jugadorRepository = jugadorRepository;
        this.partidoRepository = partidoRepository;
    }

    public EstadisticasJugadorResponseDTO guardarEstadisticas(EstadisticasJugadorRequestDTO dto) {
        Jugador jugador = jugadorRepository.findById(dto.getIdJugador())
                .orElseThrow(() -> new RuntimeException("Jugador no encontrado"));

        Partido partido = partidoRepository.findById(dto.getIdPartido())
                .orElseThrow(() -> new RuntimeException("Partido no encontrado"));

        EstadisticasJugador e = new EstadisticasJugador();

        e.setJugador(jugador);
        e.setPartido(partido);

        e.setMinutosJugados(dto.getMinutosJugados());
        e.setGoles(dto.getGoles());
        e.setAsistecias(dto.getAsistencias());
        e.setTarjetas_Amarillas(dto.getTarjetasAmarillas());
        e.setTarjetas_Rojas(dto.getTarjetasRojas());

        return convertir(estadisticasJugadorRepository.save(e));
    }

    @Override
    public EstadisticasJugadorResponseDTO obtenerEstadisticas(long id) {
        EstadisticasJugador e = estadisticasJugadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("EstadisticasJugador no existe"));
        return convertir(e);
    }

    @Override
    public EstadisticasJugadorResponseDTO ActualizarEstadisticas(long id, EstadisticasJugadorUpdateDTO dto) {
        EstadisticasJugador existente=obtenerEntidad(id);
        if (dto.getMinutosJugados() != null) {
            existente.setMinutosJugados(dto.getMinutosJugados());
        }
        if (dto.getGoles() != null) {
            existente.setGoles(dto.getGoles());
        }
        if (dto.getAsistencias() != null) {
            existente.setAsistecias(dto.getAsistencias());
        }
        if (dto.getTarjetasAmarillas() != null) {
            existente.setTarjetas_Amarillas(dto.getTarjetasAmarillas());
        }
        if (dto.getTarjetasRojas() != null) {
            existente.setTarjetas_Rojas(dto.getTarjetasRojas());
        }
        return convertir(estadisticasJugadorRepository.save(existente));

    }

    @Override
    public void EliminarEstadisticas(long id) {
        obtenerEntidad(id);
        estadisticasJugadorRepository.deleteById(id);

    }
    private EstadisticasJugadorResponseDTO convertir(EstadisticasJugador e) {
        return new EstadisticasJugadorResponseDTO(
                e.getId(),
                e.getMinutosJugados(),
                e.getGoles(),
                e.getAsistecias(),
                e.getTarjetas_Amarillas(),
                e.getTarjetas_Rojas(),
                e.getJugador().getId(),
                e.getJugador().getNombre(),
                e.getPartido().getId()
        );
    }
    private EstadisticasJugador obtenerEntidad(long id) {
        return estadisticasJugadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No encontrado"));
    }
    @Override
    public List<EstadisticasJugadorResponseDTO> obtenerPorJugador(Long id) {

        List<EstadisticasJugador> lista =
                estadisticasJugadorRepository.findByJugador_Id(id);

        return lista.stream()
                .map(this::convertir)
                .toList();
    }
}
