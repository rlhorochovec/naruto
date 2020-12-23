package br.rafaelhorochovec.naruto.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.rafaelhorochovec.naruto.model.Ninja;
import br.rafaelhorochovec.naruto.repository.NinjaRepository;

@RestController
@RequestMapping("/api")
public class NinjaRestController {
	
	@Autowired
	private NinjaRepository ninjaRepository;

	@GetMapping("/ninjas")
	public Page<Ninja> getPersonagens(Pageable pageable) {
		return ninjaRepository.findAll(pageable);
	}
}
