package com.example.demostracion.controller;

import com.example.demostracion.model.EstadisticasJugador;
import com.example.demostracion.service.EstadisticasJugadorService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/Estadisticas")
public class EstadisticasJugadorController {

    private final EstadisticasJugadorService estadisticasJugadorService;

    public EstadisticasJugadorController(EstadisticasJugadorService estadisticasJugadorService) {
        this.estadisticasJugadorService = estadisticasJugadorService;
    }

    @PostMapping
    public EstadisticasJugador save(@RequestBody EstadisticasJugador estadisticasJugador) {
        return estadisticasJugadorService.guardarEstadisticas(estadisticasJugador);
    }
    @GetMapping("/{id}")
    public EstadisticasJugador get(@PathVariable long id) {
        return estadisticasJugadorService.obtenerEstadisticas(id);
    }
    @PutMapping("/{id}")
    public EstadisticasJugador update(@PathVariable long id, @RequestBody EstadisticasJugador estadisticasJugador) {
        return estadisticasJugadorService.ActualizarEstadisticas(id, estadisticasJugador);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        estadisticasJugadorService.EliminarEstadisticas(id);
    }
}
