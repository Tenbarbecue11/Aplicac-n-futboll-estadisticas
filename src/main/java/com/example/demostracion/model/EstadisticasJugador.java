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
public class EstadisticasJugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne (optional = false,fetch = FetchType.EAGER)
    @JoinColumn (name = "id_Partido" ,nullable = false)
    @JsonBackReference("Estadisticas_Partido")
    private Partido Partido;

    @ManyToOne (optional = false,fetch = FetchType.EAGER)
    @JoinColumn (name = "id_Jugador" ,nullable = false)
    @JsonBackReference("Estadisticas_Jugador")
    private Jugador Jugador;

    @Column
    private int minutosJugados;
    @Column
    private int Goles;
    @Column
    private int asistecias;
    @Column
    private int Tarjetas_Amarillas;
    @Column
    private int Tarjetas_Rojas;
}
