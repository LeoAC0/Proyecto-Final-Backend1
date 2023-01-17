package com.example.ConsultorioSpringAcosta.service;

import com.example.ConsultorioSpringAcosta.model.PacienteDTO;

import java.util.Set;

public interface IPacienteService {
    void agregarPaciente(PacienteDTO pacienteDTO);
    PacienteDTO listarPaciente(Long id);
    void modificarPaciente(PacienteDTO pacienteDTO);
    void eliminarPaciente(Long id);
    Set<PacienteDTO> getTodos();
}
