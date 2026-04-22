package com.example.demostracion.controller;

import com.example.demostracion.DTO.EntrenadorRequestDTO;
import com.example.demostracion.DTO.EntrenadorResponseDTO;
import com.example.demostracion.service.EntrenadorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Entrenador")
public class EntrenadorController {

    private final EntrenadorService entrenadorService;

    public EntrenadorController(EntrenadorService entrenadorService) {
        this.entrenadorService = entrenadorService;
    }

    @PostMapping
    public EntrenadorResponseDTO createEntrenador(@RequestBody EntrenadorRequestDTO request) {
        return entrenadorService.guardarEntrenador(request);
    }

    @GetMapping
    public List<EntrenadorResponseDTO> getEntrenadores() {
        return entrenadorService.listarEntrenadores();
    }

    @GetMapping("/{id}")
    public EntrenadorResponseDTO getEntrenadorById(@PathVariable long id) {
        return entrenadorService.buscarPorIdEntrenador(id);
    }

    @PutMapping("/{id}")
    public EntrenadorResponseDTO actualizar(@PathVariable long id,
                                            @RequestBody EntrenadorRequestDTO request) {
        return entrenadorService.actualizarEntrenador(id, request);
    }

    @DeleteMapping("/{id}")
    public void eliminarEntrenador(@PathVariable long id) {
        entrenadorService.eliminarEntrenador(id);
    }
}