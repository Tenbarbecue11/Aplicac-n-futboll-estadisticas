package com.example.demostracion.controller;

import com.example.demostracion.DTO.EstadisticasJugadorRequestDTO;
import com.example.demostracion.DTO.EstadisticasJugadorResponseDTO;
import com.example.demostracion.DTO.EstadisticasJugadorUpdateDTO;
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
    public EstadisticasJugadorResponseDTO save(@RequestBody EstadisticasJugadorRequestDTO dto) {
        return estadisticasJugadorService.guardarEstadisticas(dto);
    }
    @GetMapping("/{id}")
    public EstadisticasJugadorResponseDTO get(@PathVariable long id) {
        return estadisticasJugadorService.obtenerEstadisticas(id);
    }
    @PutMapping("/{id}")
    public EstadisticasJugadorResponseDTO update(@PathVariable long id, @RequestBody EstadisticasJugadorUpdateDTO dto) {
        return estadisticasJugadorService.ActualizarEstadisticas(id, dto);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        estadisticasJugadorService.EliminarEstadisticas(id);
    }
}
