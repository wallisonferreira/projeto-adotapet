package br.ufac.adotapet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.ufac.adotapet.model.Like;
import br.ufac.adotapet.model.Pet;

public interface LikeRepository extends JpaRepository<Like, Long> {

    @Query("SELECT l.pet FROM Like l WHERE l.user.id = :userId")
    List<Pet> findPetsByUserId(@Param("userId") Long userId);

    Like findFirstByUserIdAndPetId(Long userId, Long petId);

    boolean existsByUserIdAndPetId(Long userId, Long petId);
}
