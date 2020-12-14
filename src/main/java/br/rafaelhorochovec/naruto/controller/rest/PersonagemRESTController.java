package br.rafaelhorochovec.naruto.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.rafaelhorochovec.naruto.model.Personagem;
import br.rafaelhorochovec.naruto.repository.PersonagemRepository;

@RestController
@RequestMapping("/api")
public class PersonagemRESTController {
	
	@Autowired
	private PersonagemRepository personagemRepository;

	@GetMapping("/personagens")
	public Page<Personagem> getPersonagens(Pageable pageable) {
		return personagemRepository.findAll(pageable);
	}
}
