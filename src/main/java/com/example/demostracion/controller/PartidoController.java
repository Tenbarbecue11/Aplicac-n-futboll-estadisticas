package com.example.demostracion.controller;

import com.example.demostracion.DTO.PartidoRequestDTO;
import com.example.demostracion.DTO.PartidoResponseDTO;
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
    public PartidoResponseDTO save(@RequestBody PartidoRequestDTO request) {
        return partidoService.guardarPartido(request);
    }

    @GetMapping
    public List<PartidoResponseDTO> findAll() {
        return partidoService.listarPartidos();
    }

    @GetMapping("/{id}")
    public PartidoResponseDTO findById(@PathVariable long id) {
        return partidoService.buscarPartido(id);
    }

    @GetMapping("/equipos/{id}/goles")
    public Integer totalGoles(@PathVariable Long id) {
        return partidoService.totalGolesEquipo(id);  // ✅ este no cambia
    }

    @GetMapping("/resultados")
    public List<Object[]> resultados() {
        return partidoService.resultadosPartidos();  // ✅ este no cambia
    }

    @PutMapping("/{id}")
    public PartidoResponseDTO update(@PathVariable long id,
                                     @RequestBody PartidoRequestDTO request) {
        return partidoService.actualizarPartido(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        partidoService.eliminarPartido(id);
    }
}