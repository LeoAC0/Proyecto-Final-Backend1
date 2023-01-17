package com.example.ConsultorioSpringAcosta.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity  // Se lo asigna como entidad para persistir
@Table(name = "turnos") // Se le asigna el nombre a la tabla para persistir

//--------------------------- Getter & Setter generados por Lambok --------------
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//--------------------------------------------------------------------------------

public class Turno {

    //--------------------------- Atributos --------------------------------------
    @Id // Identificador en nuestra BD
    @SequenceGenerator(name = "turno_seq", sequenceName = "turno_seq", allocationSize = 1) // Consulta el id de la secuencia generada por la linea siguiente.
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "turno_seq") // Anotacion para que se auto genere el ID
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE) // Relacion entre Paciente y Turno.
    @JoinColumn(name = "paciente_id") // Con esta columna tiene que realizar la relación.
    private Paciente pacientes;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE) // Relacion entre Odontologo y Turno.
    @JoinColumn(name = "odontologo_id") // Con esta columna tiene que realizar la relación.
    private Odontologo odontologo;

    private String fechaHora;

}
