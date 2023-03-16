package br.ufac.adotapet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufac.adotapet.model.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
