package br.ufac.adotapet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ufac.adotapet.model.Color;

public interface ColorRepository extends JpaRepository<Color, Long> {
    @Query("SELECT c FROM Color c WHERE c.colorName LIKE %?1%")
    List<Color> findByAll(String term);
    Color findByColorName(String term);
}
