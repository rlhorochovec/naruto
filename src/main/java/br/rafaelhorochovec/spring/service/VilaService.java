package br.rafaelhorochovec.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.rafaelhorochovec.spring.model.Vila;
import br.rafaelhorochovec.spring.repository.VilaRepository;

@Service
@Transactional
public class VilaService {
	
	@Autowired
    private VilaRepository repo;
     
    public List<Vila> listAll() {
        return repo.findAll();
    }
     
    public void save(Vila Vila) {
        repo.save(Vila);
    }
     
    public Vila get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
}