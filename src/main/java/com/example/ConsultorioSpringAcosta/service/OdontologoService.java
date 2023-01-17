package com.example.ConsultorioSpringAcosta.service;

import com.example.ConsultorioSpringAcosta.model.Odontologo;
import com.example.ConsultorioSpringAcosta.model.OdontologoDTO;
import com.example.ConsultorioSpringAcosta.repository.IOdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OdontologoService implements IOdontologoService{
    @Autowired
    private IOdontologoRepository odontologoRepository;
    @Autowired
    ObjectMapper mapper;

    private static final Logger logger = Logger.getLogger(OdontologoService.class);

    private void guardarOdontologo(OdontologoDTO odontologoDTO){
        Odontologo odontologo = mapper.convertValue(odontologoDTO,Odontologo.class);
        odontologoRepository.save(odontologo);
    }

    @Override
    public void agregarOdontologo(OdontologoDTO odontologoDTO) {
        guardarOdontologo(odontologoDTO);
        logger.info("Se agregó con éxito el siguiente Odontólogo: " + odontologoDTO);
    }

    @Override
    public OdontologoDTO listarOdontologo(Long id) {
        Optional<Odontologo> odontologo = odontologoRepository.findById(id);
        OdontologoDTO odontologoDTO = null;
        if(odontologo.isPresent()){
            odontologoDTO = mapper.convertValue(odontologo, OdontologoDTO.class);
            logger.info("Se encontró el Odontólogo con id = " + id);}
        return odontologoDTO;
    }

    @Override
    public void modificarOdontologo(OdontologoDTO odontologoDTO) {
        guardarOdontologo(odontologoDTO);
        logger.info("Se modificó con éxito el siguiente Odontólogo: " + odontologoDTO);
    }

    @Override
    public void eliminarOdontologo(Long id) {
        odontologoRepository.deleteById(id);
        logger.info("Se eliminó el Odontólogo con id = " + id);
    }

    @Override
    public Set<OdontologoDTO> getTodos() {
        List<Odontologo> odontologos = odontologoRepository.findAll();
        Set<OdontologoDTO> odontologoDTO = new HashSet<>();

        for(Odontologo odontologo : odontologos){
            odontologoDTO.add(mapper.convertValue(odontologo,OdontologoDTO.class));}

        logger.info("Se listaron todos los Odontólogos");
        return odontologoDTO;
    }
}
