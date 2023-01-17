package com.example.ConsultorioSpringAcosta.repository;

import com.example.ConsultorioSpringAcosta.model.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Le sirve a SpringBoot para hacer la inyección de dependencias (Capa de repositoro o sea de acceso a datos)
public interface ITurnoRepository extends JpaRepository<Turno, Long> {
}
