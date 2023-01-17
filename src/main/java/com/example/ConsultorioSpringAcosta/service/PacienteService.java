package com.example.ConsultorioSpringAcosta.service;

import com.example.ConsultorioSpringAcosta.model.Paciente;
import com.example.ConsultorioSpringAcosta.model.PacienteDTO;
import com.example.ConsultorioSpringAcosta.repository.IPacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class PacienteService implements IPacienteService{

    @Autowired
    private IPacienteRepository pacienteRepository;
    @Autowired
    ObjectMapper mapper;

    private static final Logger logger = Logger.getLogger(OdontologoService.class);

    private void guardarPaciente(PacienteDTO pacienteDTO){
        Paciente paciente = mapper.convertValue(pacienteDTO,Paciente.class);
        pacienteRepository.save(paciente);
    }

    @Override
    public void agregarPaciente(PacienteDTO pacienteDTO) {
        guardarPaciente(pacienteDTO);
        logger.info("Se agregó con éxito el siguiente Paciente: " + pacienteDTO);
    }

    @Override
    public PacienteDTO listarPaciente(Long id) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        PacienteDTO pacienteDTO = null;
        if(paciente.isPresent()){
            pacienteDTO = mapper.convertValue(paciente, PacienteDTO.class);
            logger.info("Se encontró el Paciente con id = " + id);}

        return pacienteDTO;
    }

    @Override
    public void modificarPaciente(PacienteDTO pacienteDTO) {
        guardarPaciente(pacienteDTO);
        logger.info("Se modificó con éxito el siguiente Paciente: " + pacienteDTO);
    }

    @Override
    public void eliminarPaciente(Long id) {
        pacienteRepository.deleteById(id);
        logger.info("Se eliminó el Paciente con id = " + id);
    }

    @Override
    public Set<PacienteDTO> getTodos() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        Set<PacienteDTO> pacienteDTO = new HashSet<>();

        for(Paciente paciente : pacientes){
            pacienteDTO.add(mapper.convertValue(paciente,PacienteDTO.class));}

        logger.info("Se listaron todos los Pacientes");
        return pacienteDTO;
    }
}
