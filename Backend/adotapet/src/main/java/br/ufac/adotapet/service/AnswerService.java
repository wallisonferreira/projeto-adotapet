package br.ufac.adotapet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.ufac.adotapet.model.Answer;
// import br.ufac.adotapet.model.Question;
import br.ufac.adotapet.repository.AnswerRepository;

@Service
public class AnswerService implements ICrudService<Answer> {

    private final AnswerRepository repo;

    public AnswerService(AnswerRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Answer> getAll() {
        return repo.findAll();
    }

    @Override
    public Answer getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Answer> getByAll(String term) {
        return repo.findByAll(term);
    }

    @Override
    public Answer save(Answer object) {
        return repo.save(object);
    }

    @Override
    public Answer save(Answer object, Long id) {
        object.setId(id);
        return repo.save(object);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    // List<Answer> findByQuestion(Question question) {
    // return repo.findByQuestion(question);
    // }

}
