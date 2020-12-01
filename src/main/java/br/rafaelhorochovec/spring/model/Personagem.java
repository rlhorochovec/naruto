package br.rafaelhorochovec.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "personagem_seq", sequenceName = "personagem_seq", initialValue = 1, allocationSize = 1)
public class Personagem {

	public Long id;
	public String nome;

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
}
