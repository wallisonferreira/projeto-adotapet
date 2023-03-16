package br.ufac.adotapet.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ufac.adotapet.model.Question;
import br.ufac.adotapet.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController implements IController<Question> {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    @GetMapping("/")
    public ResponseEntity<List<Question>> getAll() {
        List<Question> questions = questionService.getAll();
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }
    
    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Question> getById(@PathVariable("id") Long id) {
        Question question = questionService.getById(id);
        return new ResponseEntity<>(question, HttpStatus.OK);
    }
    
    @Override
    @RequestMapping(value = "search", method = RequestMethod.GET)
    public ResponseEntity<List<Question>> getByAll(@PathParam("term") String term) {
        List<Question> questions = questionService.getByAll(term);
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    @Override
    @PostMapping("/")
    public ResponseEntity<Question> insert(@RequestBody Question object) {
        Question question = questionService.save(object);
        return new ResponseEntity<>(question, HttpStatus.OK);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Question> update(@PathVariable Long id, @RequestBody Question object) {
        Question question = questionService.save(object, id);
        return new ResponseEntity<>(question, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        questionService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
