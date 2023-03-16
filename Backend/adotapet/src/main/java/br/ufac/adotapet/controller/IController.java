package br.ufac.adotapet.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface IController<T> {

    public ResponseEntity<List<T>> getAll();

    public ResponseEntity<T> getById(Long id);

    public ResponseEntity<List<T>> getByAll(String term);

    public ResponseEntity<T> insert(T object);

    public ResponseEntity<T> update(Long id, T object);

    public ResponseEntity<?> delete(Long id);
}
