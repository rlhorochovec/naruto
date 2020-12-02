package br.rafaelhorochovec.spring.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "classe_seq", sequenceName = "classe_seq", initialValue = 1, allocationSize = 1)
public class ClasseNinja {
	
	private Long id;
	private String nome;
	private List<Personagem> personagens;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "classe_seq")
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
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "classe")
	public List<Personagem> getPersonagens() {
		return personagens;
	}

	public void setPersonagens(List<Personagem> personagens) {
		this.personagens = personagens;
	}
}
