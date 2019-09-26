package com.acosta.carros.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

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

	public Iterable<Carro> getCarroByTipo(String tipo) {		
		return rep.findByTipo(tipo);
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
	

}
