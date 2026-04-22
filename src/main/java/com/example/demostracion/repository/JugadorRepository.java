package com.example.demostracion.repository;

import com.example.demostracion.model.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador,Long> {
    @Query(value = "SELECT * FROM jugador WHERE id_equipo = :id", nativeQuery = true)
    List<Jugador> jugadoresPorEquipo(@Param("id") Long id);

    @Query(value = """
SELECT j.* 
FROM jugador j
JOIN estadisticas_jugador e ON j.id = e.id_jugador
WHERE e.goles > :goles
""", nativeQuery = true)
    List<Jugador> jugadoresConMasDeXGoles(@Param("goles") int goles);

}
