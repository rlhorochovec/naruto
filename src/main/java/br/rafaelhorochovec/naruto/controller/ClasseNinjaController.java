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
import br.rafaelhorochovec.naruto.service.ClasseNinjaService;

@Controller
@RequestMapping("/classes")
public class ClasseNinjaController {

	@Autowired
	private ClasseNinjaService classeNinjaService;

	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<ClasseNinja> classes = classeNinjaService.listAll();
		model.addAttribute("titulo", "Classes");
		model.addAttribute("classes", classes);
		return "classes";
	}

	@RequestMapping("/nova")
	public String showNewClasseNinjaPage(Model model) {
		ClasseNinja classe = new ClasseNinja();
		model.addAttribute("classe", classe);
		model.addAttribute("titulo", "Nova Classe Ninja");
		return "classe_form";
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String saveClasseNinja(@ModelAttribute("classe") ClasseNinja classe) {
		classeNinjaService.save(classe);
		return "redirect:/classes/";
	}
	
	@RequestMapping("/editar/{id}")
	public ModelAndView showEditClasseNinjaPage(@PathVariable(name = "id") Long id, Model model) {
		model.addAttribute("titulo", "Editar Classe Ninja (ID: " + id + ")");
	    ModelAndView mav = new ModelAndView("classe_form");
	    ClasseNinja classe = classeNinjaService.get(id);
	    mav.addObject("classe", classe);
	    return mav;
	}
	
	@RequestMapping("/excluir/{id}")
	public String deleteClasseNinja(@PathVariable(name = "id") Long id) {
	    classeNinjaService.delete(id);
	    return "redirect:/classes/";       
	}
}
