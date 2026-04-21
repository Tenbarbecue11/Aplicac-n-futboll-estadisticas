package com.example.demostracion.service;

import com.example.demostracion.model.Equipo;

import java.util.List;

public interface EquipoService {

    Equipo guardarEquipo(Equipo equipo);
    List<Equipo> listarEquipos();
    Equipo buscarPorIdEquipo(long id);
    Equipo ActualizarEquipo(long id,Equipo equipo);
    void EliminarEquipo(long id);
}
