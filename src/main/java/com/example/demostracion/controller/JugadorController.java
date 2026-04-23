package com.example.demostracion.controller;

import com.example.demostracion.DTO.JugadorRequestDTO;
import com.example.demostracion.DTO.JugadorResponseDTO;
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
    public JugadorResponseDTO create(@RequestBody JugadorRequestDTO request) {
        return jugadorService.guardarJugador(request);
    }

    @GetMapping
    public List<JugadorResponseDTO> findAll() {
        return jugadorService.listarJugadores();
    }

    @GetMapping("/{id}")
    public JugadorResponseDTO findById(@PathVariable long id) {
        return jugadorService.buscarJugadorPorId(id);
    }

    @GetMapping("/goles/{goles}")
    public List<JugadorResponseDTO> jugadoresConMasGoles(@PathVariable int goles) {
        return jugadorService.jugadoresConMasDeXGoles(goles);
    }

    @GetMapping("/equipo/{id}")
    public List<JugadorResponseDTO> jugadoresPorEquipo(@PathVariable Long id) {
        return jugadorService.jugadoresPorEquipo(id);
    }

    @PutMapping("/{id}")
    public JugadorResponseDTO update(@PathVariable long id,
                                     @RequestBody JugadorRequestDTO request) {
        return jugadorService.actualizarJugador(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        jugadorService.eliminarJugador(id);
    }
}