package br.rafaelhorochovec.naruto.repository;

import br.rafaelhorochovec.naruto.model.Vila;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VilaRepository extends JpaRepository<Vila, Long> {
    Page<Vila> findByNomeContainingIgnoreCase(String keyword, Pageable pageable);
}