package com.example.ConsultorioSpringAcosta.repository;

import com.example.ConsultorioSpringAcosta.model.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Le sirve a SpringBoot para hacer tomar los datos desde la base de datos.
public interface IOdontologoRepository extends JpaRepository<Odontologo, Long> {
}
