package com.example.demostracion.service;

import com.example.demostracion.model.Entrenador;

import java.util.List;

public interface EntrenadorService {
    Entrenador guardarEntrenador(Entrenador entrenador);
    List<Entrenador> listarEntrenadores();
    Entrenador buscarPorIdEntrenador(long id);
    Entrenador ActualizarEntrenador(long id,Entrenador entrenador);
    void EliminarEntrenador(long id);
}
