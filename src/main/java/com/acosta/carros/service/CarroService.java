package com.acosta.carros.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.acosta.carros.domain.Carro;
import com.acosta.carros.domain.dto.CarroDTO;
import com.acosta.carros.repository.CarroRepository;

@Service
public class CarroService {
	
	@Autowired
	private CarroRepository rep;
	
	public List<CarroDTO> getCarros() {
				
		return rep.findAll().stream().map(CarroDTO::new).collect(Collectors.toList());
		
	}
	
	public Optional<Carro> getCarroById(Long id) {
		return rep.findById(id);
	}

	public List<CarroDTO> getCarroByTipo(String tipo) {		
		return rep.findByTipo(tipo).stream().map(CarroDTO::new).collect(Collectors.toList());
	}

	public Carro insert(Carro carro) {
		return rep.save(carro);		
		
	}
	
	public Carro update(Carro carro, Long id) {
		Assert.notNull(id, "Não foi possível atualizar o registro");
		
		Optional<Carro> optional = getCarroById(id);
		if(optional.isPresent()) {
			Carro db= optional.get();
			
			db.setNome(carro.getNome());
			db.setTipo(carro.getTipo());
			System.out.println("Carro id " + db.getId());
			
			rep.save(db);
			
			return db;
		} else {
			throw new RuntimeException("Não foi possivel atualizar o registro");
		}
	}

	public void delete(Long id) {
		Optional<Carro> carro = getCarroById(id);
		if(carro.isPresent()) {
			rep.deleteById(id);
		}
	}

}
