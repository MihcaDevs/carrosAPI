package com.acosta.carros.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {
	
	@GetMapping
	public String Hello() {
		return "Hello spring Boot";
	}
	
	@GetMapping ("/teste")
	public String test () {
		return" Teste Spring Boot";
	}

}
