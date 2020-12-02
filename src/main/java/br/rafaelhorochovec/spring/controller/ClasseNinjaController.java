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
import br.rafaelhorochovec.spring.service.ClasseNinjaService;

@Controller
@RequestMapping("/classes")
public class ClasseNinjaController {

	@Autowired
	private ClasseNinjaService classeNinjaService;

	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<ClasseNinja> classes = classeNinjaService.listAll();
		model.addAttribute("classes", classes);
		return "classes";
	}

	@RequestMapping("/nova")
	public String showNewClasseNinjaPage(Model model) {
		ClasseNinja classe = new ClasseNinja();
		model.addAttribute("classe", classe);
		return "nova-classe";
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String saveClasseNinja(@ModelAttribute("classe") ClasseNinja classe) {
		classeNinjaService.save(classe);
		return "redirect:/classes/";
	}
	
	@RequestMapping("/editar/{id}")
	public ModelAndView showEditClasseNinjaPage(@PathVariable(name = "id") Long id) {
	    ModelAndView mav = new ModelAndView("editar-classe");
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
