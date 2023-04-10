package br.rafaelhorochovec.naruto.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.rafaelhorochovec.naruto.model.Classificacao;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassificacaoRepository extends JpaRepository<Classificacao, Long> {
    Page<Classificacao> findByNomeContainingIgnoreCase(String keyword, Pageable pageable);
}