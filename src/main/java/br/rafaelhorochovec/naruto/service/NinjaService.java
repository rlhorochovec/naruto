package br.rafaelhorochovec.naruto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.rafaelhorochovec.naruto.model.Ninja;
import br.rafaelhorochovec.naruto.repository.NinjaRepository;

@Service
@Transactional
public class NinjaService {
	
	@Autowired
    private NinjaRepository repo;
     
    public List<Ninja> listAll() {
        return repo.findAll();
    }
     
    public void save(Ninja ninja) {
        repo.save(ninja);
    }
     
    public Ninja get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
}