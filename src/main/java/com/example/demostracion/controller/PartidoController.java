package com.example.demostracion.controller;

import com.example.demostracion.model.Partido;
import com.example.demostracion.service.PartidoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Partido")
public class PartidoController {

    private final PartidoService partidoService;
    public PartidoController(PartidoService partidoService) {
        this.partidoService = partidoService;
    }

    @PostMapping
    public Partido save(@RequestBody Partido partido) {
        return partidoService.guardarPartido(partido);
    }

    @GetMapping
    public List<Partido> findAll() {
        return partidoService.listarPartidos();
    }
    @GetMapping("/{id}")
    public Partido findById(@PathVariable long id) {
        return partidoService.buscarPartido(id);
    }
    @GetMapping("/equipos/{id}/goles")
    public Integer totalGoles(@PathVariable Long id) {
        return partidoService.totalGolesEquipo(id);
    }
    @GetMapping("/resultados")
    public List<Object[]> resultados() {
        return partidoService.resultadosPartidos();
    }
    @PutMapping("/{id}")
    public Partido update(@PathVariable long id, @RequestBody Partido partido) {
        return partidoService.actualizarPartido(id, partido);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        partidoService.eliminarPartido(id);
    }
}
