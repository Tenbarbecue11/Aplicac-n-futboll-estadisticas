package com.example.demostracion.service;

import com.example.demostracion.model.Partido;
import com.example.demostracion.repository.PartidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartidoServiceImp implements PartidoService {

    private final PartidoRepository partidoRepository;

    public PartidoServiceImp(PartidoRepository partidoRepository) {
        this.partidoRepository = partidoRepository;
    }

    @Override
    public Partido guardarPartido(Partido partido) {
        return  partidoRepository.save(partido);
    }

    @Override
    public List<Partido> listarPartidos() {
        return partidoRepository.findAll();
    }

    @Override
    public Partido actualizarPartido(long id,Partido partido) {
        Partido existente = buscarPartido(id);
        if (partido.getFechadelPartido()!=null) {
            existente.setFechadelPartido(partido.getFechadelPartido());
        }
        if (partido.getEstadio()!=null) {
            existente.setEstadio(partido.getEstadio());
        }
        if (partido.getEquipoLocal()!=null) {
            existente.setEquipoLocal(partido.getEquipoLocal());
        }
        if (partido.getEquipoVisitante()!=null) {
            existente.setEquipoVisitante(partido.getEquipoVisitante());
        }
        existente.setGolesLocal(partido.getGolesLocal());
        existente.setGolesVisitante(partido.getGolesVisitante());
        return partidoRepository.save(existente);
    }

    @Override
    public Partido buscarPartido(long id) {
        return partidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Partido no encontrado"));
    }

    @Override
    public void eliminarPartido(long id) {
        buscarPartido(id);
        partidoRepository.deleteById(id);

    }

    @Override
    public Integer totalGolesEquipo(Long id) {
        return partidoRepository.totalGolesEquipo(id);
    }

    @Override
    public List<Object[]> resultadosPartidos() {
        return partidoRepository.resultadosPartidos();
    }
}
