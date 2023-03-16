package br.ufac.adotapet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ufac.adotapet.model.Size;

public interface SizeRepository extends JpaRepository<Size, Long> {
    @Query("SELECT s FROM Size s WHERE s.sizeName LIKE %?1%")
    List<Size> findByAll(String term);
    Size findBySizeName(String term);
}
