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

import br.rafaelhorochovec.naruto.model.Vila;
import br.rafaelhorochovec.naruto.service.VilaService;

@Controller
@RequestMapping("/vilas")
public class VilaController {

	@Autowired
	private VilaService vilaService;

	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Vila> vilas = vilaService.listAll();
		model.addAttribute("vilas", vilas);
		return "vilas";
	}

	@RequestMapping("/nova")
	public String showNewVilaPage(Model model) {
		Vila vila = new Vila();
		model.addAttribute("vila", vila);
		model.addAttribute("titulo", "Nova Vila");
		return "vila_form";
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String saveVila(@ModelAttribute("vila") Vila vila) {
		vilaService.save(vila);
		return "redirect:/vilas/";
	}
	
	@RequestMapping("/editar/{id}")
	public ModelAndView showEditVilaPage(@PathVariable(name = "id") Long id, Model model) {
		model.addAttribute("titulo", "Editar Vila (ID: " + id + ")");
	    ModelAndView mav = new ModelAndView("vila_form");
	    Vila vila = vilaService.get(id);
	    mav.addObject("vila", vila);
	    return mav;
	}
	
	@RequestMapping("/excluir/{id}")
	public String deleteVila(@PathVariable(name = "id") Long id) {
	    vilaService.delete(id);
	    return "redirect:/vilas/";       
	}
}
