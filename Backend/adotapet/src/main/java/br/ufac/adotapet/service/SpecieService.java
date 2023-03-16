package br.ufac.adotapet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.ufac.adotapet.model.Specie;
import br.ufac.adotapet.repository.SpecieRepository;

@Service
public class SpecieService implements ICrudService<Specie> {

    private final SpecieRepository repo;

    public SpecieService(SpecieRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Specie> getAll() {
        return repo.findAll();
    }

    @Override
    public Specie getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Specie> getByAll(String term) {
        return repo.findByAll(term);
    }

    @Override
    public Specie save(Specie object) {
        return repo.save(object);
    }

    @Override
    public Specie save(Specie object, Long id) {
        object.setId(id);
        return repo.save(object);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
