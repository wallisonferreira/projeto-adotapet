package br.ufac.adotapet.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufac.adotapet.model.Adoption;
import br.ufac.adotapet.model.Question;
import br.ufac.adotapet.model.User;
import br.ufac.adotapet.service.AdoptionService;
import br.ufac.adotapet.service.QuestionService;

@RestController
@RequestMapping("/adoption")
public class AdoptionController implements IController<Adoption> {

    private final AdoptionService adoptionService;
    private final QuestionService questionService;

    public AdoptionController(
            AdoptionService adoptionService,
            QuestionService questionService) {

        this.adoptionService = adoptionService;
        this.questionService = questionService;
    }

    @GetMapping("/questions")
    public ResponseEntity<List<Question>> getQuestions(Authentication authentication) {

        List<Question> questions = questionService.getAll();

        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    @Override
    @GetMapping("/")
    public ResponseEntity<List<Adoption>> getAll() {
        List<Adoption> adoptions = adoptionService.getAll();
        return new ResponseEntity<>(adoptions, HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Adoption> getById(@PathVariable("id") Long id) {
        Adoption adoption = adoptionService.getById(id);
        return new ResponseEntity<>(adoption, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Adoption>> getByAll(String term) {
        return null;
    }

    @Override
    public ResponseEntity<Adoption> insert(Adoption object) {
        return null;
    }

    @PostMapping("/")
    public ResponseEntity<Adoption> insertAdoption(
            @RequestBody Adoption object,
            @AuthenticationPrincipal User loggedUser) {

        Adoption adoption = adoptionService.save(object);
        return new ResponseEntity<>(adoption, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Adoption> update(Long id, Adoption object) {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Adoption> updateAdoption(@PathVariable Long id, @RequestBody Adoption object,
            @AuthenticationPrincipal User loggedUser) {

        Adoption adoption = adoptionService.save(object, id);
        return new ResponseEntity<>(adoption, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(Long id) {
        adoptionService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
