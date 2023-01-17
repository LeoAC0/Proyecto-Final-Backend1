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
@Table(name = "pacientes") // Se le asigna el nombre a la tabla para persistir

//--------------------------- Getter & Setter generados por Lambok --------------
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//--------------------------------------------------------------------------------

public class Paciente {

    //--------------------------- Atributos --------------------------------------
    @Id // Identificador en nuestra BD
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Anotacion para que se auto genere el ID
    @Column(name = "id")
    private Long id;

    private String nombre;
    private String apellido;
    private String dni;
    private String fechaDeAlta;

    @OneToMany(mappedBy = "pacientes", fetch = FetchType.LAZY) // Relacion entre Paciente y Turno.
    @JsonIgnore // Cuando se utilice o realice el mapeo, no llama a esta propiedad (en realaciones de uno a muchos).
    private Set<Turno> turnos = new HashSet<>();

    @OneToOne // Relacion entre Domicilo y Paciente.
    @JoinColumn(name = "domicilio_id") // Con esta columna tiene que realizar la relación.
    private Domicilio domicilios;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "odontologo_id")
    private Odontologo odontologo;
}
