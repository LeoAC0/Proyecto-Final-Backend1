package com.example.ConsultorioSpringAcosta.service;

import com.example.ConsultorioSpringAcosta.model.AppUser;
import com.example.ConsultorioSpringAcosta.model.AppUserRoles;
import com.example.ConsultorioSpringAcosta.repository.IAppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    private IAppUserRepository appUserRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = bCryptPasswordEncoder.encode("DigitalHouse");

        BCryptPasswordEncoder bCryptPasswordEncoder1 = new BCryptPasswordEncoder();
        String hashedPasswotrd2 = bCryptPasswordEncoder1.encode("BackEnd");

        appUserRepository.save(new AppUser(1L,"Leon","Leon_05",hashedPassword, AppUserRoles.USER));
        appUserRepository.save(new AppUser(2L,"Majo","Majo_12",hashedPasswotrd2, AppUserRoles.USER));

    }
}
