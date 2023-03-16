package br.ufac.adotapet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.ufac.adotapet.model.Color;
import br.ufac.adotapet.repository.ColorRepository;

@Service
public class ColorService implements ICrudService<Color> {

    private final ColorRepository repo;

    public ColorService(ColorRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Color> getAll() {
        return repo.findAll();
    }

    @Override
    public Color getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Color> getByAll(String term) {
        return repo.findByAll(term);
    }

    @Override
    public Color save(Color object) {
        return repo.save(object);
    }

    @Override
    public Color save(Color object, Long id) {
        object.setId(id);
        return repo.save(object);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    public Color getByColorName(String term) {
        return repo.findByColorName(term);
    }

}
