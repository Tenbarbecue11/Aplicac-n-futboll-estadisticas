package com.example.demostracion.service;

import com.example.demostracion.model.Jugador;

import java.util.List;

public interface JugadorService {
    Jugador guardarJugador(Jugador jugador);
    List<Jugador> listarJugadores();
    Jugador buscarJugadorPorId(long id);
    Jugador actualizarJugador(long id,Jugador jugador);
    void eliminarJugador(long id);

    //Añadidos

    List<Jugador> jugadoresPorEquipo(Long id);

    List<Jugador> jugadoresConMasDeXGoles(int goles);
}
