package br.ufac.adotapet.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufac.adotapet.model.Specie;
import br.ufac.adotapet.service.SpecieService;

@RestController
@RequestMapping("/specie")
public class SpecieController implements IController<Specie> {

    private final SpecieService specieService;

    public SpecieController(SpecieService specieService) {
        this.specieService = specieService;
    }

    @Override
    @GetMapping("/")
    public ResponseEntity<List<Specie>> getAll() {
        List<Specie> species = specieService.getAll();
        return new ResponseEntity<>(species, HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Specie> getById(@PathVariable("id") Long id) {
        Specie specie = specieService.getById(id);
        return new ResponseEntity<>(specie, HttpStatus.OK);
    }

    @Override
    @PostMapping("/")
    public ResponseEntity<Specie> insert(@RequestBody Specie object) {
        Specie specie = specieService.save(object);
        return new ResponseEntity<>(specie, HttpStatus.OK);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Specie> update(@PathVariable Long id, @RequestBody Specie object) {
        Specie specie = specieService.save(object, id);
        return new ResponseEntity<>(specie, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        specieService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Specie>> getByAll(String term) {
        return null;
    }

}
