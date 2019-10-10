package com.acosta.carros;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.acosta.carros.domain.Carro;
import com.acosta.carros.domain.dto.CarroDTO;
import com.acosta.carros.service.CarroService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarrosApiApplicationTests {
	
	@Autowired
	private CarroService service;
	
	@Test
	public void testSave() {
		Carro carro = new Carro();
		carro.setNome("Ferrari");
		carro.setTipo("esportivos");
		
		CarroDTO c = service.insert(carro);
		
		assertNotNull(c);
		
		Long id = c.getId();
		assertNotNull(id);
		
		//Buscar o objeto
		Optional<CarroDTO>op = service.getCarroById(id);
		assertTrue(op.isPresent());
		
		c = op.get();
		assertEquals( "Ferrari",c.getNome());
		assertEquals( "esportivos",c.getTipo());
		
		// Deletar o objeto
		service.delete(id);
		
		// verificar se deletou
		assertFalse(service.getCarroById(id).isPresent());
		
		
		
	}

	@Test
	public void testLista() {
		
		List<CarroDTO> carros = service.getCarros();
		
		assertEquals(28, carros.size());
	}
	
	@Test
	public void testGet() {
		
		Optional<CarroDTO> op = service.getCarroById(1L);
		
		assertTrue(op.isPresent());
		
		CarroDTO c = op.get();
		
		assertEquals("Tucker 1948", c.getNome());
		
		
	}
	
	

}
