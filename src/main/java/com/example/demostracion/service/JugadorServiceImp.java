package com.example.demostracion.service;

import com.example.demostracion.DTO.JugadorRequestDTO;
import com.example.demostracion.DTO.JugadorResponseDTO;
import com.example.demostracion.model.Equipo;
import com.example.demostracion.model.Jugador;
import com.example.demostracion.repository.EquipoRepository;
import com.example.demostracion.repository.JugadorRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JugadorServiceImp implements JugadorService {

    private final JugadorRepository jugadorRepository;
    private final EquipoRepository equipoRepository;  // ✅ para buscar el equipo

    public JugadorServiceImp(JugadorRepository jugadorRepository,
                             EquipoRepository equipoRepository) {
        this.jugadorRepository = jugadorRepository;
        this.equipoRepository = equipoRepository;
    }

    // ✅ Convierte Jugador -> JugadorResponseDTO
    private JugadorResponseDTO toResponse(Jugador j) {
        return new JugadorResponseDTO(
                j.getId(),
                j.getNombre(),
                j.getPosicion(),
                j.getDorsal(),
                j.getFechaNacimiento().toString(),
                j.getNacionalidad(),
                j.getEquipo().getId(),      // ✅ idEquipo
                j.getEquipo().getNombre()   // ✅ nombreEquipo
        );
    }


    @Override
    public JugadorResponseDTO guardarJugador(JugadorRequestDTO request) {
        Equipo equipo = equipoRepository.findById(request.getIdEquipo())
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado"));

        Jugador jugador = new Jugador();
        jugador.setNombre(request.getNombre());
        jugador.setPosicion(request.getPosicion());
        jugador.setDorsal(request.getDorsal());
        jugador.setFechaNacimiento(LocalDate.parse(request.getFechaNacimiento()));
        jugador.setNacionalidad(request.getNacionalidad());
        jugador.setEquipo(equipo);

        return toResponse(jugadorRepository.save(jugador));
    }

    @Override
    public List<JugadorResponseDTO> listarJugadores() {
        return jugadorRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public JugadorResponseDTO buscarJugadorPorId(long id) {
        Jugador jugador = jugadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jugador no encontrado"));
        return toResponse(jugador);
    }

    @Override
    public JugadorResponseDTO actualizarJugador(long id, JugadorRequestDTO request) {
        Jugador existente = jugadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jugador no encontrado"));

        if (request.getNombre() != null) {
            existente.setNombre(request.getNombre());
        }
        if (request.getPosicion() != null) {
            existente.setPosicion(request.getPosicion());
        }
        if (request.getDorsal() != null) {
            existente.setDorsal(request.getDorsal());
        }
        if (request.getFechaNacimiento() != null) {
            existente.setFechaNacimiento(LocalDate.parse(request.getFechaNacimiento()));
        }
        if (request.getNacionalidad() != null) {
            existente.setNacionalidad(request.getNacionalidad());
        }
        if (request.getIdEquipo() != null) {
            Equipo equipo = equipoRepository.findById(request.getIdEquipo())
                    .orElseThrow(() -> new RuntimeException("Equipo no encontrado"));
            existente.setEquipo(equipo);
        }

        return toResponse(jugadorRepository.save(existente));
    }

    @Override
    public void eliminarJugador(long id) {
        jugadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jugador no encontrado"));
        jugadorRepository.deleteById(id);
    }

    @Override
    public List<JugadorResponseDTO> jugadoresPorEquipo(Long id) {
        return jugadorRepository.jugadoresPorEquipo(id)
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<JugadorResponseDTO> jugadoresConMasDeXGoles(int goles) {
        return jugadorRepository.jugadoresConMasDeXGoles(goles)
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}