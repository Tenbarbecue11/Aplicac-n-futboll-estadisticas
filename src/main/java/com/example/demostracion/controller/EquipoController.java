package com.example.demostracion.controller;

import com.example.demostracion.model.Equipo;
import com.example.demostracion.service.EquipoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Equipo")
public class EquipoController {
    private final EquipoService equipoService;

    public EquipoController(EquipoService equipoService){
        this.equipoService = equipoService;
    }

    @PostMapping
    public Equipo crearEquipo(@RequestBody Equipo equipo){
        return equipoService.guardarEquipo(equipo);
    }
    @GetMapping
    public List<Equipo> listarEquipos(){
        return equipoService.listarEquipos();
    }
    @GetMapping("/{id}")
    public Equipo buscarEquipo(@PathVariable long id){
        return equipoService.buscarPorIdEquipo(id);
    }
    @PutMapping("/{id}")
    public Equipo ActualizarEquipo(@PathVariable long id, @RequestBody Equipo equipo){
        return equipoService.ActualizarEquipo(id, equipo);
    }
    @DeleteMapping("/{id}")
    public void eliminarEquipo(@PathVariable long id){
        equipoService.EliminarEquipo(id);
    }
}
