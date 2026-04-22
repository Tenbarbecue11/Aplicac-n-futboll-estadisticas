package com.example.demostracion.service;

import com.example.demostracion.model.Jugador;
import com.example.demostracion.repository.JugadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JugadorServiceImp implements JugadorService {
    private final JugadorRepository jugadorRepository;
    public JugadorServiceImp(JugadorRepository jugadorRepository) {
        this.jugadorRepository = jugadorRepository;
    }

    @Override
    public Jugador guardarJugador(Jugador jugador) {
        return  jugadorRepository.save(jugador);
    }

    @Override
    public List<Jugador> listarJugadores() {
        return jugadorRepository.findAll();
    }

    @Override
    public Jugador buscarJugadorPorId(long id) {
        return jugadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jugador no encontrado"));
    }

    @Override
    public Jugador actualizarJugador(long id, Jugador jugador) {
        Jugador existente = jugadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jugador no encontrado"));
        if (jugador.getNombre()!=null){
            existente.setNombre(jugador.getNombre());
        }
        if (jugador.getEquipo()!=null){
            existente.setEquipo(jugador.getEquipo());
        }
        if (jugador.getDorsal()!= 0) {
            existente.setDorsal(jugador.getDorsal());
        }
        if (jugador.getPosicion()!=null) {
            existente.setPosicion(jugador.getPosicion());
        }
        if (jugador.getFechaNacimiento()!=null) {
            existente.setFechaNacimiento(jugador.getFechaNacimiento());
        }
        if (jugador.getNacionalidad()!=null) {
            existente.setNacionalidad(jugador.getNacionalidad());
        }
        return jugadorRepository.save(existente);
    }

    @Override
    public void eliminarJugador(long id) {
        jugadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jugador no encontrado"));
        jugadorRepository.deleteById(id);
    }

    @Override
    public List<Jugador> jugadoresPorEquipo(Long id) {
        return jugadorRepository.jugadoresPorEquipo(id);
    }

    @Override
    public List<Jugador> jugadoresConMasDeXGoles(int goles) {
        return jugadorRepository.jugadoresConMasDeXGoles(goles);
    }
}
