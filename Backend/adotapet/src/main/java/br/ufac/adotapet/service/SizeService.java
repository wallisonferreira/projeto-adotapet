package br.ufac.adotapet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.ufac.adotapet.model.Size;
import br.ufac.adotapet.repository.SizeRepository;

@Service
public class SizeService implements ICrudService<Size> {

    private final SizeRepository repo;

    public SizeService(SizeRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Size> getAll() {
        return repo.findAll();
    }

    @Override
    public Size getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Size> getByAll(String term) {
        return repo.findByAll(null);
    }

    @Override
    public Size save(Size object) {
        return repo.save(object);
    }

    @Override
    public Size save(Size object, Long id) {
        object.setId(id);
        return repo.save(object);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }   
}
