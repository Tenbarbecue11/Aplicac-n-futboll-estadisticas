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
public class Partido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (nullable = false)
    private Date fechadelPartido;
    @Column (nullable = false, length = 100)
    private String Estadio;

    @ManyToOne (optional = false,fetch = FetchType.EAGER)
    @JoinColumn (name = "EquipoLocal",nullable = false)
    private Equipo EquipoLocal;

    @ManyToOne (optional = false,fetch = FetchType.EAGER)
    @JoinColumn (name = "EquipoVisitante" ,nullable = false)
    private Equipo EquipoVisitante;

    @Column (nullable = false, length = 100)
    private int GolesLocal;
    @Column (nullable = false, length = 100)
    private int GolesVisitante;

    @OneToMany (mappedBy = "Partido",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<EstadisticasJugador> EstadisticasJugadores=new ArrayList<>();

}
