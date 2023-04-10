package br.rafaelhorochovec.naruto.controller;

import br.rafaelhorochovec.naruto.model.Classificacao;
import br.rafaelhorochovec.naruto.model.Ninja;
import br.rafaelhorochovec.naruto.model.Vila;
import br.rafaelhorochovec.naruto.repository.ClassificacaoRepository;
import br.rafaelhorochovec.naruto.repository.NinjaRepository;
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
public class NinjaController {

	@Autowired
	private NinjaRepository ninjaRepository;

	@Autowired
	private VilaRepository vilaRepository;

	@Autowired
	private ClassificacaoRepository classificacaoRepository;

	@GetMapping("/ninjas")
	public String getAll(Model model, @RequestParam(required = false) String keyword,
						 @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "3") int size) {
		try {
			List<Ninja> ninjas;
			Pageable paging = PageRequest.of(page - 1, size);
			List<Classificacao> classificacoes = classificacaoRepository.findAll();
			List<Vila> vilas = vilaRepository.findAll();

			Page<Ninja> pageNinja;
			if (keyword == null) {
				pageNinja = ninjaRepository.findAll(paging);
			} else {
				pageNinja = ninjaRepository.findByNomeContainingIgnoreCase(keyword, paging);
				model.addAttribute("keyword", keyword);
			}

			ninjas = pageNinja.getContent();

			model.addAttribute("ninjas", ninjas);
			model.addAttribute("classificacoes", classificacoes);
			model.addAttribute("vilas", vilas);
			model.addAttribute("currentPage", pageNinja.getNumber() + 1);
			model.addAttribute("totalItems", pageNinja.getTotalElements());
			model.addAttribute("totalPages", pageNinja.getTotalPages());
			model.addAttribute("pageSize", size);
			model.addAttribute("pageTitle", "Ninjas");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
		}
		return "ninjas";
	}

	@GetMapping("/ninjas/new")
	public String addNinja(Model model) {
		Ninja ninja = new Ninja();
		List<Classificacao> classificacoes = classificacaoRepository.findAll();
		List<Vila> vilas = vilaRepository.findAll();

		model.addAttribute("ninja", ninja);
		model.addAttribute("classificacoes", classificacoes);
		model.addAttribute("vilas", vilas);
		model.addAttribute("pageTitle", "Novo Ninja");

		return "ninja_form";
	}

	@PostMapping("/ninjas/save")
	public String saveNinja(Ninja ninja, RedirectAttributes redirectAttributes) {
		try {
			ninjaRepository.save(ninja);

			redirectAttributes.addFlashAttribute("message", "O Ninja foi salvo com sucesso!");
		} catch (Exception e) {
			redirectAttributes.addAttribute("message", e.getMessage());
		}

		return "redirect:/ninjas";
	}

	@GetMapping("/ninjas/{id}")
	public String editNinja(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes) {
		try {
			Ninja ninja = ninjaRepository.findById(id).get();
			List<Classificacao> classificacoes = classificacaoRepository.findAll();
			List<Vila> vilas = vilaRepository.findAll();

			model.addAttribute("ninja", ninja);
			model.addAttribute("classificacoes", classificacoes);
			model.addAttribute("vilas", vilas);
			model.addAttribute("pageTitle", "Alterar Ninja (ID: " + id + ")");

			return "ninja_form";
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("message", e.getMessage());

			return "redirect:/ninjas";
		}
	}

	@GetMapping("/ninjas/delete/{id}")
	public String deleteNinja(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes) {
		try {
			ninjaRepository.deleteById(id);

			redirectAttributes.addFlashAttribute("message", "O Ninja com id=" + id + " foi deletado com sucesso!");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("message", e.getMessage());
		}

		return "redirect:/ninjas";
	}
}
