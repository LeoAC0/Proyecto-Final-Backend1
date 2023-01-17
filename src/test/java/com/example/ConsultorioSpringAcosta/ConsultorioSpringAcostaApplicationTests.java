package com.example.ConsultorioSpringAcosta;

import com.example.ConsultorioSpringAcosta.model.PacienteDTO;
import com.example.ConsultorioSpringAcosta.service.IPacienteService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class ConsultorioSpringAcostaApplicationTests {

	@Autowired
	private IPacienteService pacienteService;

	@Test
	@Order(1)
	public void testCrearPaciente(){

		PacienteDTO pacienteDTO = new PacienteDTO();
		pacienteDTO.setNombre("Leandro");
		pacienteDTO.setApellido("Acosta");
		pacienteService.agregarPaciente(pacienteDTO);
		PacienteDTO pacienteYo = pacienteService.listarPaciente(1L);

		assertTrue(pacienteYo != null);
	}

	@Test
	@Order(2)
	public void testModificarPaciente(){
		PacienteDTO pacienteDTO = new PacienteDTO();
		pacienteDTO = pacienteService.listarPaciente(1L);
		pacienteDTO.setNombre("Leandro Manuel");
		pacienteService.modificarPaciente(pacienteDTO);
		pacienteDTO = pacienteService.listarPaciente(1L);

		assertTrue(pacienteDTO.getNombre() != "Leandro");
	}

	@Test
	@Order(3)
	public void testEliminarPaciente(){
		PacienteDTO pacienteDTO = new PacienteDTO();
		pacienteService.eliminarPaciente(1L);
		pacienteDTO = pacienteService.listarPaciente(1L);

		assertFalse(pacienteDTO != null);
	}

}
