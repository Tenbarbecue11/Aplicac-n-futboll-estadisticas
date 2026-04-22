package com.example.demostracion.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (nullable = false, unique = true, length = 100)
    private String nombre;
    @Column (nullable = false,unique = true, length = 100)
    private String ciudad;
    @Column  (nullable = false, length = 100)
    private LocalDate fecha;

    @OneToMany (mappedBy = "equipo",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Jugador> jugadores=new ArrayList<>();
 
    @OneToMany (mappedBy = "equipo",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Entrenador> entrenadores=new ArrayList<>();

    @OneToMany (mappedBy = "EquipoLocal",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Partido> partidosComoLocal=new ArrayList<>();

    @OneToMany (mappedBy = "EquipoVisitante",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Partido> partidosComoVisitante=new ArrayList<>();

}
