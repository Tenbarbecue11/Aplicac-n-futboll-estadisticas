package com.example.demostracion.controller;

import com.example.demostracion.DTO.EquipoRequestDTO;
import com.example.demostracion.DTO.EquipoResponseDTO;
import com.example.demostracion.service.EquipoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Equipo")
public class EquipoController {

    private final EquipoService equipoService;

    public EquipoController(EquipoService equipoService) {
        this.equipoService = equipoService;
    }

    @PostMapping
    public EquipoResponseDTO crearEquipo(@RequestBody EquipoRequestDTO request) {
        return equipoService.guardarEquipo(request);
    }

    @GetMapping
    public List<EquipoResponseDTO> listarEquipos() {
        return equipoService.listarEquipos();
    }

    @GetMapping("/{id}")
    public EquipoResponseDTO buscarEquipo(@PathVariable long id) {
        return equipoService.buscarPorIdEquipo(id);
    }

    @PutMapping("/{id}")
    public EquipoResponseDTO actualizarEquipo(@PathVariable long id,
                                              @RequestBody EquipoRequestDTO request) {
        return equipoService.actualizarEquipo(id, request);
    }

    @DeleteMapping("/{id}")
    public void eliminarEquipo(@PathVariable long id) {
        equipoService.eliminarEquipo(id);
    }
}