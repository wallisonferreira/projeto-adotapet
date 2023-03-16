package br.ufac.adotapet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ufac.adotapet.model.Answer;
import br.ufac.adotapet.model.Question;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

    @Query("SELECT a FROM Answer a" +
    // " LEFT JOIN Question q ON q.id = a.question" +
            " WHERE a.text LIKE %?1%")
    List<Answer> findByAll(String term);

    List<Answer> findByQuestion(Question question);

}
