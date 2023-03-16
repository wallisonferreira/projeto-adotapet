package br.ufac.adotapet.service;

import java.util.List;

public interface ICrudService<T> {
    
    public List<T> getAll();
    public T getById(Long id);
    public List<T> getByAll(String term);
    public T save(T object);
    public T save(T object, Long id);
    public void delete(Long id);
}
