package br.rafaelhorochovec.naruto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.rafaelhorochovec.naruto.model.Personagem;

public interface PersonagemRepository extends JpaRepository<Personagem, Long> {

}