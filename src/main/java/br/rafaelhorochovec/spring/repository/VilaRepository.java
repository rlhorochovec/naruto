package br.rafaelhorochovec.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.rafaelhorochovec.spring.model.Vila;

public interface VilaRepository extends JpaRepository<Vila, Long> {

}