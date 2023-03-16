package br.ufac.adotapet.service;

public interface IUserProfileService<T> {

    public T save(T object, Long id);
    public void delete(Long id);
}
