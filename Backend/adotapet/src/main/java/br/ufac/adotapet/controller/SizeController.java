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

import br.ufac.adotapet.model.Size;
import br.ufac.adotapet.service.SizeService;

@RestController
@RequestMapping("/size")
public class SizeController implements IController<Size> {

    private final SizeService sizeService;

    public SizeController(SizeService sizeService) {
        this.sizeService = sizeService;
    }

    @Override
    @GetMapping("/")
    public ResponseEntity<List<Size>> getAll() {
        List<Size> size = sizeService.getAll();
        return new ResponseEntity<>(size, HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Size> getById(@PathVariable("id") Long id) {
        Size size = sizeService.getById(id);
        return new ResponseEntity<>(size, HttpStatus.OK);
    }

    @Override
    @RequestMapping(value = "search", method = RequestMethod.GET)
    public ResponseEntity<List<Size>> getByAll(@PathParam("term") String term) {
        List<Size> sizes = sizeService.getByAll(term);
        return new ResponseEntity<>(sizes, HttpStatus.OK);
    }

    @Override
    @PostMapping("/")
    public ResponseEntity<Size> insert(@RequestBody Size object) {
        Size size = sizeService.save(object);
        return new ResponseEntity<>(size, HttpStatus.OK);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Size> update(@PathVariable("id") Long id, @RequestBody Size object) {
        Size size = sizeService.save(object, id);
        return new ResponseEntity<>(size, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        sizeService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
