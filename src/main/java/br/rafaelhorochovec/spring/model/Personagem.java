package br.rafaelhorochovec.spring.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "personagem_seq", sequenceName = "personagem_seq", initialValue = 1, allocationSize = 1)
public class Personagem {

	private Long id;
	private String nome;
	private ClasseNinja classe;
	private Vila vila;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "personagem_seq")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "classe_id", nullable = true)
	public ClasseNinja getClasse() {
		return classe;
	}

	public void setClasse(ClasseNinja classe) {
		this.classe = classe;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vila_id", nullable = true)
	public Vila getVila() {
		return vila;
	}

	public void setVila(Vila vila) {
		this.vila = vila;
	}
}