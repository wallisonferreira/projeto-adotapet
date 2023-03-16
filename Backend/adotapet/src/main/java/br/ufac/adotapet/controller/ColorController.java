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

import br.ufac.adotapet.model.Color;
import br.ufac.adotapet.service.ColorService;

@RestController
@RequestMapping("/color")
public class ColorController implements IController<Color> {

    private final ColorService colorService;

    public ColorController(ColorService colorService) {
        this.colorService = colorService;
    }

    @Override
    @GetMapping("/")
    public ResponseEntity<List<Color>> getAll() {
        List<Color> colors = colorService.getAll();
        return new ResponseEntity<>(colors, HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Color> getById(@PathVariable("id") Long id) {
        Color color = colorService.getById(id);
        return new ResponseEntity<>(color, HttpStatus.OK);
    }

    @Override
    @RequestMapping(value = "search", method = RequestMethod.GET)
    public ResponseEntity<List<Color>> getByAll(@PathParam("term") String term) {
        List<Color> colors = colorService.getByAll(term);
        return new ResponseEntity<>(colors, HttpStatus.OK);
    }

    @Override
    @PostMapping("/")
    public ResponseEntity<Color> insert(@RequestBody Color object) {
        Color color = colorService.save(object);
        return new ResponseEntity<>(color, HttpStatus.OK);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Color> update(@PathVariable Long id, @RequestBody Color object) {
        Color color = colorService.save(object, id);
        return new ResponseEntity<>(color, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        colorService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}