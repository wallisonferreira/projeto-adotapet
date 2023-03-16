package br.ufac.adotapet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.ufac.adotapet.model.Race;
import br.ufac.adotapet.model.Specie;
import br.ufac.adotapet.repository.RaceRepository;

@Service
public class RaceService implements ICrudService<Race> {

    private final RaceRepository repo;

    public RaceService(RaceRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Race> getAll() {
        return repo.findAll();
    }

    @Override
    public Race getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<Race> getBySpecie(Specie specie) {
        return repo.findBySpecie(specie);
    }

    @Override
    public List<Race> getByAll(String term) {
        return repo.findByAll(term);
    }

    @Override
    public Race save(Race object) {
        return repo.save(object);
    }

    @Override
    public Race save(Race object, Long id) {
        object.setId(id);
        return repo.save(object);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);

    }
}
