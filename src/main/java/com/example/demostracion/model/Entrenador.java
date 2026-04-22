package com.example.demostracion.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Entrenador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false, length = 100)
    private String nombre;
    @Column(unique = true, nullable = false, length = 100)
    private String especialidad;

    @ManyToOne (optional = false, fetch = FetchType.EAGER)
    @JoinColumn (name = "IdEquipo",nullable = false)
    @JsonBackReference("Entrenadaor_equipo")
    private Equipo equipo;
}

