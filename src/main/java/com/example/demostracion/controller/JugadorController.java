package com.example.demostracion.controller;

import com.example.demostracion.model.Jugador;
import com.example.demostracion.service.JugadorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Jugador")
public class JugadorController {
    private final JugadorService jugadorService;

    public JugadorController(JugadorService jugadorService) {
        this.jugadorService = jugadorService;
    }

    @PostMapping
    public Jugador create(@RequestBody Jugador jugador) {
        return jugadorService.guardarJugador(jugador);
    }
    @GetMapping
    public List<Jugador> findAll() {
        return jugadorService.listarJugadores();
    }
    @GetMapping("/{id}")
    public Jugador findById(@PathVariable long id) {
        return jugadorService.buscarJugadorPorId(id);
    }
    @GetMapping("/goles/{goles}")
    public List<Jugador> jugadoresConMasGoles(@PathVariable int goles) {
        return jugadorService.jugadoresConMasDeXGoles(goles);
    }
    @GetMapping("/equipo/{id}")
    public List<Jugador> jugadoresPorEquipo(@PathVariable Long id) {
        return jugadorService.jugadoresPorEquipo(id);
    }

    @PutMapping("/{id}")
    public Jugador update(@PathVariable long id,@RequestBody Jugador jugador) {
        return jugadorService.actualizarJugador(id,jugador);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        jugadorService.eliminarJugador(id);
    }
}
