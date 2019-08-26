package com.acosta.carros.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acosta.carros.domain.Carro;
import com.acosta.carros.repository.CarroRepository;

@Service
public class CarroService {
	
	@Autowired
	private CarroRepository rep;
	
	public List<Carro> getCarros() {
		return (List<Carro>) rep.findAll();
	}
	
	public Optional<Carro> getCarroById(Long id) {
		return rep.findById(id);
	}
	

}
