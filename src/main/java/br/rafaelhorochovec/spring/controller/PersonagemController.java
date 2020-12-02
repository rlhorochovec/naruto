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

import br.rafaelhorochovec.spring.model.ClasseNinja;
import br.rafaelhorochovec.spring.model.Personagem;
import br.rafaelhorochovec.spring.model.Vila;
import br.rafaelhorochovec.spring.service.ClasseNinjaService;
import br.rafaelhorochovec.spring.service.PersonagemService;
import br.rafaelhorochovec.spring.service.VilaService;

@Controller
public class PersonagemController {

	@Autowired
	private PersonagemService personagemService;
	
	@Autowired
	private VilaService vilaService;
	
	@Autowired
	private ClasseNinjaService classeNinjaService;

	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Personagem> personagens = personagemService.listAll();
		model.addAttribute("personagens", personagens);
		model.addAttribute("classes", classeNinjaService.listAll());
		model.addAttribute("vilas", vilaService.listAll());
		return "index";
	}

	@RequestMapping("/novo")
	public String showNewPersonagemPage(Model model) {
		Personagem personagem = new Personagem();
		model.addAttribute("personagem", personagem);
		model.addAttribute("classes", classeNinjaService.listAll());
		model.addAttribute("vilas", vilaService.listAll());
		return "novo-personagem";
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String savePersonagem(@ModelAttribute("personagem") Personagem personagem) {
		personagemService.save(personagem);
		return "redirect:/";
	}
	
	@RequestMapping("/editar/{id}")
	public ModelAndView showEditPersonagemPage(@PathVariable(name = "id") Long id) {
	    ModelAndView mav = new ModelAndView("editar-personagem");
	    Personagem personagem = personagemService.get(id);
	    List<ClasseNinja> classes = classeNinjaService.listAll();
	    List<Vila> vilas = vilaService.listAll();
	    mav.addObject("personagem", personagem);
	    mav.addObject("classes", classes);
	    mav.addObject("vilas", vilas);
	    return mav;
	}
	
	@RequestMapping("/excluir/{id}")
	public String deletePersonagem(@PathVariable(name = "id") Long id) {
	    personagemService.delete(id);
	    return "redirect:/";       
	}
}
