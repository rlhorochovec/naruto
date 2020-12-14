package br.rafaelhorochovec.naruto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.rafaelhorochovec.naruto.model.Personagem;
import br.rafaelhorochovec.naruto.repository.PersonagemRepository;

@Service
@Transactional
public class PersonagemService {
	
	@Autowired
    private PersonagemRepository repo;
     
    public List<Personagem> listAll() {
        return repo.findAll();
    }
     
    public void save(Personagem personagem) {
        repo.save(personagem);
    }
     
    public Personagem get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
}