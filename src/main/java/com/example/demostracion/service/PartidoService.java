package com.example.demostracion.service;

import com.example.demostracion.model.Partido;

import java.util.List;

public interface PartidoService {
    Partido guardarPartido(Partido partido);
    List<Partido> listarPartidos();
    Partido buscarPartido(long id);
    Partido actualizarPartido(long id, Partido partido);
    void eliminarPartido(long id);

    //Agregados
    Integer totalGolesEquipo(Long id);

    List<Object[]> resultadosPartidos();
}
