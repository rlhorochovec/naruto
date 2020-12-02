package br.rafaelhorochovec.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.rafaelhorochovec.spring.model.ClasseNinja;
import br.rafaelhorochovec.spring.repository.ClasseNinjaRepository;

@Service
@Transactional
public class ClasseNinjaService {
	
	@Autowired
    private ClasseNinjaRepository repo;
     
    public List<ClasseNinja> listAll() {
        return repo.findAll();
    }
     
    public void save(ClasseNinja ClasseNinja) {
        repo.save(ClasseNinja);
    }
     
    public ClasseNinja get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
}