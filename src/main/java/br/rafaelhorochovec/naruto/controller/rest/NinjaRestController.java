package br.rafaelhorochovec.naruto.controller.rest;

import br.rafaelhorochovec.naruto.service.NinjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.rafaelhorochovec.naruto.model.Ninja;
import br.rafaelhorochovec.naruto.repository.NinjaRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NinjaRestController {
	
	@Autowired
	private NinjaService ninjaService;

	@GetMapping("/ninjas")
	public List<Ninja> getNinjas() {
		return ninjaService.listAll();
	}

	@GetMapping("/ninjas/{id}")
	public Ninja getNinja(@PathVariable(value = "id") Long id) {
		return ninjaService.get(id);
	}
}
