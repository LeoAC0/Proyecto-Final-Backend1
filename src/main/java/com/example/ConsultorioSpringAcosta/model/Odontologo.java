package com.example.ConsultorioSpringAcosta.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity  // Se lo asigna como entidad para persistir
@Table(name = "odontologos") // Se le asigna el nombre a la tabla para persistir

//--------------------------- Getter & Setter generados por Lambok --------------
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//--------------------------------------------------------------------------------

public class Odontologo {
    //--------------------------- Atributos --------------------------------------

    @Id // Identificador en nuestra BD
    @SequenceGenerator(name = "odontologo_seq", sequenceName = "odontologo_seq", allocationSize = 1) // Consulta el id de la secuencia generada por la linea siguiente.
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "odontologo_seq") // Anotacion para que se auto genere el ID
    private Long id;

    private String apellido;
    private String nombre;
    private String matricula;

    @OneToMany(mappedBy = "odontologo", fetch = FetchType.LAZY) // Relacion entre Odontologo y Turno, se recupera solo cuando se haga una petición sobre ella (LAZY).
    @JsonIgnore // Cuando se utilice o realice el mapeo, no llama a esta propiedad (en realaciones de uno a muchos).
    private Set<Turno> turnos = new HashSet<>();

    @OneToMany(mappedBy = "odontologo", fetch = FetchType.LAZY)
    @JsonIgnore // Cuando se utilice o realice el mapeo, no llama a esta propiedad (en realaciones de uno a muchos).
    private Set<Paciente> pacientes = new HashSet<>();;
}
