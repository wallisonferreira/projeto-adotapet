package br.ufac.adotapet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.ufac.adotapet.model.Question;
import br.ufac.adotapet.repository.QuestionRepository;

@Service
public class QuestionService implements ICrudService<Question> {

    private final QuestionRepository repo;

    public QuestionService(QuestionRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Question> getAll() {
        return repo.findAll();
    }

    @Override
    public Question getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Question> getByAll(String term) {
        return repo.findByAll(term);
    }

    @Override
    public Question save(Question object) {
        return repo.save(object);
    }

    @Override
    public Question save(Question object, Long id) {
        object.setId(id);
        return repo.save(object);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
    
}
