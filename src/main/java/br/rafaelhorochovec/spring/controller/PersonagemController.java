package br.rafaelhorochovec.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.rafaelhorochovec.spring.model.Personagem;
import br.rafaelhorochovec.spring.service.PersonagemService;

@Controller
public class PersonagemController {

	@Autowired
	private PersonagemService service;

	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Personagem> personagens = service.listAll();
		model.addAttribute("personagens", personagens);
		return "index";
	}

	@RequestMapping("/novo")
	public String showNewPersonagemPage(Model model) {
		Personagem personagem = new Personagem();
		model.addAttribute("personagem", personagem);
		return "novo-personagem";
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String savePersonagem(@ModelAttribute("personagem") Personagem personagem) {
		service.save(personagem);
		return "redirect:/";
	}
	
	@RequestMapping("/editar/{id}")
	public ModelAndView showEditPersonagemPage(@PathVariable(name = "id") Long id) {
	    ModelAndView mav = new ModelAndView("editar-personagem");
	    Personagem personagem = service.get(id);
	    mav.addObject("personagem", personagem);
	    return mav;
	}
	
	@RequestMapping("/excluir/{id}")
	public String deletePersonagem(@PathVariable(name = "id") Long id) {
	    service.delete(id);
	    return "redirect:/";       
	}
}
