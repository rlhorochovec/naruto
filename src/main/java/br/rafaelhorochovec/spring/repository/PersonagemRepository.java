package br.rafaelhorochovec.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.rafaelhorochovec.spring.model.Personagem;

public interface PersonagemRepository extends JpaRepository<Personagem, Long> {

}