package com.example.ConsultorioSpringAcosta.repository;

import com.example.ConsultorioSpringAcosta.model.AppUser;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional
public interface IAppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByUser(String usuario);
}
