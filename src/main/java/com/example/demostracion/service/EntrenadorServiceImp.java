package com.example.demostracion.service;

import com.example.demostracion.model.Entrenador;
import com.example.demostracion.repository.EntrenadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntrenadorServiceImp implements EntrenadorService{
    private final EntrenadorRepository entrenadorRepository;

    public EntrenadorServiceImp(EntrenadorRepository entrenadorRepository) {
        this.entrenadorRepository = entrenadorRepository;
    }

    @Override
    public Entrenador guardarEntrenador(Entrenador entrenador){
        return entrenadorRepository.save(entrenador);
    }
    @Override
    public List<Entrenador> listarEntrenadores(){
        return entrenadorRepository.findAll();
    }
    @Override
    public Entrenador buscarPorIdEntrenador(long id){
        return entrenadorRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Entrenador no encontrado"));
    }
    @Override
    public  Entrenador ActualizarEntrenador(long id,Entrenador entrenador){
        Entrenador existente=entrenadorRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Entrenador no encontrado"));
        if (entrenador.getNombre()!=null){
            existente.setNombre(entrenador.getNombre());
        }
        if (entrenador.getEquipo()!=null){
            existente.setEquipo(entrenador.getEquipo());

        }
        if (entrenador.getEspecialidad()!=null){
            existente.setEspecialidad(entrenador.getEspecialidad());
        }

        return entrenadorRepository.save(existente);
    }
    @Override
    public void EliminarEntrenador(long id){
        entrenadorRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Entrenador no encontrado"));
        entrenadorRepository.deleteById(id);
    }



}
