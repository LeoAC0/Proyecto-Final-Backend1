package com.example.ConsultorioSpringAcosta.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity // Se lo asigna como entidad para persistir
@Table(name = "domicilios")
//--------------------------- Getter & Setter generados por Lambok --------------
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//--------------------------------------------------------------------------------

public class Domicilio {

    //--------------------------- Atributos --------------------------------------
    @Id // Identificador en nuestra BD
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String calle;
    private String numero;
    private String codigoPostal;
    private String localidad;
    private String provincia;

    @ManyToOne // Relacion entre Domicilio y Paciente.
    @JoinColumn(name = "pacientes_id") // Con esta columna tiene que realizar la relación.
    private Paciente pacientes;
}
