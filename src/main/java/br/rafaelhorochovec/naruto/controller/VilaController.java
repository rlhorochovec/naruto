package br.rafaelhorochovec.naruto.controller;

import br.rafaelhorochovec.naruto.model.Vila;
import br.rafaelhorochovec.naruto.repository.VilaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class VilaController {

	@Autowired
	private VilaRepository vilaRepository;

	@GetMapping("/vilas")
	public String getAll(Model model, @RequestParam(required = false) String keyword,
						 @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "3") int size) {
		try {
			List<Vila> vilas;
			Pageable paging = PageRequest.of(page - 1, size);

			Page<Vila> pageVille;
			if (keyword == null) {
				pageVille = vilaRepository.findAll(paging);
			} else {
				pageVille = vilaRepository.findByNomeContainingIgnoreCase(keyword, paging);
				model.addAttribute("keyword", keyword);
			}

			vilas = pageVille.getContent();

			model.addAttribute("vilas", vilas);
			model.addAttribute("currentPage", pageVille.getNumber() + 1);
			model.addAttribute("totalItems", pageVille.getTotalElements());
			model.addAttribute("totalPages", pageVille.getTotalPages());
			model.addAttribute("pageSize", size);
			model.addAttribute("pageTitle", "Vilas");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
		}
		return "vilas";
	}

	@GetMapping("/vilas/new")
	public String addVila(Model model) {
		Vila vila = new Vila();
		
		model.addAttribute("vila", vila);
		model.addAttribute("pageTitle", "Create new Vila");
		
		return "vila_form";
	}

	@PostMapping("/vilas/save")
	public String saveVila(Vila vila, RedirectAttributes redirectAttributes) {
		try {
			vilaRepository.save(vila);

			redirectAttributes.addFlashAttribute("message", "A Vila foi salva com sucesso!");
		} catch (Exception e) {
			redirectAttributes.addAttribute("message", e.getMessage());
		}

		return "redirect:/vilas";
	}

	@GetMapping("/vilas/{id}")
	public String editVila(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes) {
		try {
			Vila vila = vilaRepository.findById(id).get();

			model.addAttribute("vila", vila);
			model.addAttribute("pageTitle", "Alterar Vila (ID: " + id + ")");

			return "vila_form";
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("message", e.getMessage());

			return "redirect:/vilas";
		}
	}

	@GetMapping("/vilas/delete/{id}")
	public String deleteVila(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes) {
		try {
			vilaRepository.deleteById(id);

			redirectAttributes.addFlashAttribute("message", "A Vila com id=" + id + " foi deletado com sucesso!");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("message", e.getMessage());
		}

		return "redirect:/vilas";
	}
}
