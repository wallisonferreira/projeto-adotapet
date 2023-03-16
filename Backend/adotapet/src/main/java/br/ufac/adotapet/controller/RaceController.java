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

import br.ufac.adotapet.model.Race;
import br.ufac.adotapet.model.Specie;
import br.ufac.adotapet.service.RaceService;
import br.ufac.adotapet.service.SpecieService;

@RestController
@RequestMapping("/race")
public class RaceController implements IController<Race> {

    private final RaceService raceService;
    private final SpecieService specieService;

    public RaceController(RaceService raceService, SpecieService specieService) {
        this.raceService = raceService;
        this.specieService = specieService;
    }

    @Override
    @GetMapping("/")
    public ResponseEntity<List<Race>> getAll() {
        List<Race> races = raceService.getAll();
        return new ResponseEntity<>(races, HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Race> getById(@PathVariable("id") Long id) {
        Race race = raceService.getById(id);
        return new ResponseEntity<>(race, HttpStatus.OK);
    }

    @GetMapping("/specie/{id}")
    public ResponseEntity<List<Race>> getByRace(@PathVariable("id") Long id) {
        Specie specie = specieService.getById(id);
        List<Race> race = raceService.getBySpecie(specie);
        return new ResponseEntity<>(race, HttpStatus.OK);
    }

    @Override
    @RequestMapping(value = "search", method = RequestMethod.GET)
    public ResponseEntity<List<Race>> getByAll(@PathParam("term") String term) {
        List<Race> races = raceService.getByAll(term);
        return new ResponseEntity<>(races, HttpStatus.OK);
    }

    @Override
    @PostMapping("/")
    public ResponseEntity<Race> insert(@RequestBody Race object) {
        Race race = raceService.save(object);
        return new ResponseEntity<>(race, HttpStatus.OK);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Race> update(@PathVariable("id") Long id, @RequestBody Race object) {
        Race race = raceService.save(object, id);
        return new ResponseEntity<>(race, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        raceService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
