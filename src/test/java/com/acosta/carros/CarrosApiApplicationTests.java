package com.acosta.carros;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.acosta.carros.domain.Carro;
import com.acosta.carros.service.CarroService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarrosApiApplicationTests {
	
	@Autowired
	private CarroService service;
	
	@Test
	public void test1() {
		Carro carro = new Carro();
		carro.setNome("ferrari");
		carro.setTipo("esportivos");
		
		service.insert(carro);
	}

	@Test
	public void contextLoads() {
	}

}
