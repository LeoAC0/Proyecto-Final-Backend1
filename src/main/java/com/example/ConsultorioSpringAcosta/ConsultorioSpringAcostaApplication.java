package com.example.ConsultorioSpringAcosta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.log4j.*;

import java.io.File;

@SpringBootApplication
public class ConsultorioSpringAcostaApplication {

	public static void main(String[] args) {

		File log4file = new File("C:\\DH\\BackEnd I\\TPI-TurnosOdontologo\\Consultorio.Spring\\ConsultorioSpringAcosta\\src\\main\\resources\\log4j.properties");
		PropertyConfigurator.configure(log4file.getAbsolutePath());

		SpringApplication.run(ConsultorioSpringAcostaApplication.class, args);
	}

}
