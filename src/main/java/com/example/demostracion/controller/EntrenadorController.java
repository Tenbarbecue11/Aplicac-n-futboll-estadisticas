package com.example.demostracion.controller;

import com.example.demostracion.model.Entrenador;
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
    public Entrenador createEntrenador(@RequestBody Entrenador entrenador){
        return entrenadorService.guardarEntrenador(entrenador);
    }
    @GetMapping
    public List<Entrenador> getEntrenadores(){
        return entrenadorService.listarEntrenadores();
    }
    @GetMapping("/{id}")
    public Entrenador getEntrenadorById(@PathVariable long id){
        return entrenadorService.buscarPorIdEntrenador(id);
    }
    @PutMapping("/{id}")
    public Entrenador Actualizar(@PathVariable long id, @RequestBody Entrenador entrenador){
        return entrenadorService.ActualizarEntrenador(id, entrenador);
    }
    @DeleteMapping("/{id}")
    public void eliminarEntrenador(@PathVariable long id){
        entrenadorService.EliminarEntrenador(id);
    }
}
