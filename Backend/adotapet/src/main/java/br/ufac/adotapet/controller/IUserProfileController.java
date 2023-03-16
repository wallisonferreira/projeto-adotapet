package br.ufac.adotapet.controller;

import org.springframework.http.ResponseEntity;

public interface IUserProfileController<T> {
    
    public ResponseEntity<T> insert(T object);
    public ResponseEntity<T> update(Long id, T object);
    public ResponseEntity<?> delete(Long id);
}
