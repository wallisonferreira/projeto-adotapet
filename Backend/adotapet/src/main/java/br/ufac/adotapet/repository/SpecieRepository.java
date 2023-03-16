package br.ufac.adotapet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ufac.adotapet.model.Specie;

public interface SpecieRepository extends JpaRepository<Specie, Long> {
    @Query("SELECT s FROM Specie s WHERE s.specieName LIKE %?1%")
    List<Specie> findByAll(String term);
}
