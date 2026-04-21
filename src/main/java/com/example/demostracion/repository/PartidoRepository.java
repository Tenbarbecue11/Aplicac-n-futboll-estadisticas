package com.example.demostracion.repository;

import com.example.demostracion.model.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PartidoRepository extends JpaRepository<Partido,Long> {

}
