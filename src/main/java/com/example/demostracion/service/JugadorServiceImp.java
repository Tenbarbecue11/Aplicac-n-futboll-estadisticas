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
        existente.setNombre(jugador.getNombre());
        existente.setEquipo(jugador.getEquipo());
        existente.setDorsal(jugador.getDorsal());
        existente.setPosicion(jugador.getPosicion());
        existente.setFechaNacimiento(jugador.getFechaNacimiento());
        existente.setNacionalidad(jugador.getNacionalidad());
        return jugadorRepository.save(existente);
    }

    @Override
    public void eliminarJugador(long id) {
        jugadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jugador no encontrado"));
        jugadorRepository.deleteById(id);
    }
}
