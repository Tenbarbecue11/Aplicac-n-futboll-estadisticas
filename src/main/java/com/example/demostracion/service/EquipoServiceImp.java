package com.example.demostracion.service;

import com.example.demostracion.model.Equipo;
import com.example.demostracion.repository.EquipoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipoServiceImp implements EquipoService {

    private final EquipoRepository equipoRepository;

    public EquipoServiceImp(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }
    @Override
    public Equipo guardarEquipo(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    @Override
    public List<Equipo> listarEquipos() {
        return equipoRepository.findAll();
    }

    @Override
    public Equipo buscarPorIdEquipo(long id) {
        return equipoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado"));
    }

    @Override
    public Equipo ActualizarEquipo(long id, Equipo equipo) {
        Equipo existente=equipoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Entrenador no encontrado"));
        existente.setNombre(equipo.getNombre());
        existente.setCiudad(equipo.getCiudad());
        existente.setFecha(equipo.getFecha());
        return equipoRepository.save(existente);
    }

    @Override
    public void EliminarEquipo(long id) {
        equipoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado"));
        equipoRepository.deleteById(id);

    }
}
