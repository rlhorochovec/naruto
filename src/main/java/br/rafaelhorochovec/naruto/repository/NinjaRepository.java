package br.rafaelhorochovec.naruto.repository;

import br.rafaelhorochovec.naruto.model.Ninja;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NinjaRepository extends JpaRepository<Ninja, Long> {
    Page<Ninja> findByNomeContainingIgnoreCase(String keyword, Pageable pageable);
}