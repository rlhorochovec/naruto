package br.rafaelhorochovec.naruto.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Ninja extends Auditoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;

	@ManyToOne(fetch = FetchType.LAZY)
	private Classificacao classificacao;

	@ManyToOne(fetch = FetchType.LAZY)
	private Vila vila;
}