package com.example.demostracion.repository;

import com.example.demostracion.model.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PartidoRepository extends JpaRepository<Partido,Long> {
        @Query(value = """
    SELECT SUM(goles_local + goles_visitante)
    FROM partido
    WHERE equipo_local = :id OR equipo_visitante = :id
    """, nativeQuery = true)
        Integer totalGolesEquipo(@Param("id") Long id);

    @Query(value = """
SELECT p.id, e1.nombre AS local, e2.nombre AS visitante,
       p.goles_local, p.goles_visitante
FROM partido p
JOIN equipo e1 ON p.equipo_local = e1.id
JOIN equipo e2 ON p.equipo_visitante = e2.id
""", nativeQuery = true)
    List<Object[]> resultadosPartidos();

}
