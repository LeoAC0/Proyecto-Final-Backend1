package com.example.ConsultorioSpringAcosta.service;

import com.example.ConsultorioSpringAcosta.model.OdontologoDTO;
import com.example.ConsultorioSpringAcosta.model.TurnoDTO;

import java.util.Set;

public interface ITurnoService {
    void agregarTurno(TurnoDTO turnoDTO);
    TurnoDTO listarTurno(Long id);
    void modificarTurno(TurnoDTO turnoDTO);
    void eliminarTurno(Long id);
    Set<TurnoDTO> getTodos();
}
