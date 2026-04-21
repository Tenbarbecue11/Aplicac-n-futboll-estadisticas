package com.example.demostracion.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true, length = 100)
    private String nombre;
    @Column(nullable = false, length = 50)
    private String posicion;
    @Column(nullable = false)
    private int dorsal;
    @Column(nullable = false)
    private Date fechaNacimiento;
    @Column(nullable = false, length = 100)
    private String Nacionalidad;

    @ManyToOne (optional = false, fetch = FetchType.EAGER)
    @JoinColumn (name = "IdEquipo",nullable = false)
    private Equipo equipo;

    @OneToMany (mappedBy = "Jugador",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<EstadisticasJugador> EstadisticasJugador=new ArrayList<>();
}
