package com.example.demostracion.repository;

import com.example.demostracion.model.EstadisticasJugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadisticasJugadorRepository extends JpaRepository<EstadisticasJugador, Long> {
    // ✅ solo agregar esta línea — Jugador es el nombre del campo en el modelo
    List<EstadisticasJugador> findByJugador_Id(Long id);
}