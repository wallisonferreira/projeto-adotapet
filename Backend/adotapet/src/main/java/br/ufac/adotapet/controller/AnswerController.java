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

import br.ufac.adotapet.model.Answer;
import br.ufac.adotapet.service.AnswerService;

@RestController
@RequestMapping("/answer")
public class AnswerController implements IController<Answer> {
    
    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @Override
    @GetMapping("/")
    public ResponseEntity<List<Answer>> getAll() {
        List<Answer> answers = answerService.getAll();
        return new ResponseEntity<>(answers, HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Answer> getById(@PathVariable("id") Long id) {
        Answer answer = answerService.getById(id);
        return new ResponseEntity<>(answer, HttpStatus.OK);
    }

    @Override
    @RequestMapping(value = "search", method = RequestMethod.GET)
    public ResponseEntity<List<Answer>> getByAll(@PathParam("term") String term) {
        List<Answer> answers = answerService.getByAll(term);
        return new ResponseEntity<>(answers, HttpStatus.OK);
    }

    @Override
    @PostMapping("/")
    public ResponseEntity<Answer> insert(@RequestBody Answer object) {
        Answer answer = answerService.save(object);
        return new ResponseEntity<>(answer, HttpStatus.OK);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Answer> update(@PathVariable("id") Long id, @RequestBody Answer object) {
        Answer answer = answerService.save(object, id);
        return new ResponseEntity<>(answer, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        answerService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
