package com.example.ConsultorioSpringAcosta.service;

import com.example.ConsultorioSpringAcosta.model.OdontologoDTO;
import com.example.ConsultorioSpringAcosta.model.PacienteDTO;

import java.util.Set;

public interface IOdontologoService {
    void agregarOdontologo(OdontologoDTO odontologoDTO);
    OdontologoDTO listarOdontologo(Long id);
    void modificarOdontologo(OdontologoDTO odontologoDTO);
    void eliminarOdontologo(Long id);
    Set<OdontologoDTO> getTodos();
}
