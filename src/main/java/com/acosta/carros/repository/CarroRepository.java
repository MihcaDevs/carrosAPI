package com.acosta.carros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acosta.carros.domain.Carro;
import com.acosta.carros.domain.dto.CarroDTO;

public interface CarroRepository extends JpaRepository<Carro, Long>{
	
	List<Carro> findByTipo(String tipo);

	

}
