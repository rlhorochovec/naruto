package br.rafaelhorochovec.naruto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.rafaelhorochovec.naruto.model.ClasseNinja;
import br.rafaelhorochovec.naruto.model.Ninja;
import br.rafaelhorochovec.naruto.model.Vila;
import br.rafaelhorochovec.naruto.service.ClasseNinjaService;
import br.rafaelhorochovec.naruto.service.NinjaService;
import br.rafaelhorochovec.naruto.service.VilaService;

@Controller
public class NinjaController {

	@Autowired
	private NinjaService ninjaService;
	
	@Autowired
	private VilaService vilaService;
	
	@Autowired
	private ClasseNinjaService classeNinjaService;

	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Ninja> ninjas = ninjaService.listAll();
		model.addAttribute("ninjas", ninjas);
		model.addAttribute("classes", classeNinjaService.listAll());
		model.addAttribute("vilas", vilaService.listAll());
		return "index";
	}

	@RequestMapping("/novo")
	public String showNewNinjaPage(Model model) {
		Ninja ninja = new Ninja();
		model.addAttribute("ninja", ninja);
		model.addAttribute("classes", classeNinjaService.listAll());
		model.addAttribute("vilas", vilaService.listAll());
		return "novo-ninja";
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String saveNinja(@ModelAttribute("ninja") Ninja ninja) {
		ninjaService.save(ninja);
		return "redirect:/";
	}
	
	@RequestMapping("/editar/{id}")
	public ModelAndView showEditNinjaPage(@PathVariable(name = "id") Long id) {
	    ModelAndView mav = new ModelAndView("editar-ninja");
	    Ninja ninja = ninjaService.get(id);
	    List<ClasseNinja> classes = classeNinjaService.listAll();
	    List<Vila> vilas = vilaService.listAll();
	    mav.addObject("ninja", ninja);
	    mav.addObject("classes", classes);
	    mav.addObject("vilas", vilas);
	    return mav;
	}
	
	@RequestMapping("/excluir/{id}")
	public String deleteNinja(@PathVariable(name = "id") Long id) {
	    ninjaService.delete(id);
	    return "redirect:/";       
	}
}
