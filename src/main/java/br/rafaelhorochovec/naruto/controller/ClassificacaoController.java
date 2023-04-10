package br.rafaelhorochovec.naruto.controller;

import br.rafaelhorochovec.naruto.model.Classificacao;
import br.rafaelhorochovec.naruto.repository.ClassificacaoRepository;
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
public class ClassificacaoController {

	@Autowired
	private ClassificacaoRepository classificacaoRepository;

	@GetMapping("/classificacoes")
	public String getAll(Model model, @RequestParam(required = false) String keyword,
						 @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "3") int size) {
		try {
			List<Classificacao> classificacoes;
			Pageable paging = PageRequest.of(page - 1, size);

			Page<Classificacao> pageClassification;
			if (keyword == null) {
				pageClassification = classificacaoRepository.findAll(paging);
			} else {
				pageClassification = classificacaoRepository.findByNomeContainingIgnoreCase(keyword, paging);
				model.addAttribute("keyword", keyword);
			}

			classificacoes = pageClassification.getContent();

			model.addAttribute("classificacoes", classificacoes);
			model.addAttribute("currentPage", pageClassification.getNumber() + 1);
			model.addAttribute("totalItems", pageClassification.getTotalElements());
			model.addAttribute("totalPages", pageClassification.getTotalPages());
			model.addAttribute("pageSize", size);
			model.addAttribute("pageTitle", "Classificacoes");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
		}
		return "classificacoes";
	}

	@GetMapping("/classificacoes/new")
	public String addClassificacao(Model model) {
		Classificacao classificacao = new Classificacao();

		model.addAttribute("classificacao", classificacao);
		model.addAttribute("pageTitle", "Nova Classificação");

		return "classificacao_form";
	}

	@PostMapping("/classificacoes/save")
	public String saveClassificacao(Classificacao classificacao, RedirectAttributes redirectAttributes) {
		try {
			classificacaoRepository.save(classificacao);

			redirectAttributes.addFlashAttribute("message", "A Classificação foi salva com sucesso!");
		} catch (Exception e) {
			redirectAttributes.addAttribute("message", e.getMessage());
		}

		return "redirect:/classificacoes";
	}

	@GetMapping("/classificacoes/{id}")
	public String editClassificacao(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes) {
		try {
			Classificacao classificacao = classificacaoRepository.findById(id).get();

			model.addAttribute("classificacao", classificacao);
			model.addAttribute("pageTitle", "Alterar Classificação (ID: " + id + ")");

			return "classificacao_form";
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("message", e.getMessage());

			return "redirect:/classificacoes";
		}
	}

	@GetMapping("/classificacoes/delete/{id}")
	public String deleteClassificacao(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes) {
		try {
			classificacaoRepository.deleteById(id);

			redirectAttributes.addFlashAttribute("message", "A Classificação com id=" + id + " foi deletada com sucesso!");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("message", e.getMessage());
		}

		return "redirect:/classificacoes";
	}
}
