package br.rafaelhorochovec.naruto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "classe_seq", sequenceName = "classe_seq", initialValue = 1, allocationSize = 1)
public class ClasseNinja {
	
	private Long id;
	private String nome;

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
}
