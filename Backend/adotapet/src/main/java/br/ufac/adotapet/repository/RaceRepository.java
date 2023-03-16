package br.ufac.adotapet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ufac.adotapet.model.Race;
import br.ufac.adotapet.model.Specie;

public interface RaceRepository extends JpaRepository<Race, Long> {
    @Query("SELECT r FROM Race r WHERE r.raceName LIKE %?1%")
    List<Race> findByAll(String term);

    Race findByRaceName(String term);

    List<Race> findBySpecie(Specie specie);
}
