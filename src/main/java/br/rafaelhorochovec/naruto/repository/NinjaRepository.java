package br.rafaelhorochovec.naruto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.rafaelhorochovec.naruto.model.Ninja;

public interface NinjaRepository extends JpaRepository<Ninja, Long> {

}