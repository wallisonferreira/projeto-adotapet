package br.ufac.adotapet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.ufac.adotapet.model.Pet;
import br.ufac.adotapet.model.User;
import br.ufac.adotapet.repository.criteria.PetRepositoryCustom;

public interface PetRepository extends JpaRepository<Pet, Long>, PetRepositoryCustom {

    @Query("SELECT p FROM Pet p" +
            " LEFT JOIN User u ON u.id = p.user" +
            " LEFT JOIN Color c ON c.id = p.color" +
            " LEFT JOIN Size s ON s.id = p.size" +
            " LEFT JOIN Race r ON r.id = p.race" +
            " LEFT JOIN Specie sp ON sp.id = p.specie" +
            " WHERE p.name LIKE %?1%")
    List<Pet> findByAll(String term);

    // find pet lost true
    List<Pet> findByLostOrderByCreatedAtDesc(Boolean lost);

    // find pet by id or tag
    Pet findByIdOrTag(Long id, String tag);

    // Get animals of a particular user
    // @Query("SELECT p FROM Pet p JOIN p.user u WHERE u.id = :userId AND p.hasOwner
    // = true AND u.role = 'ROLE_USER'")
    @Query("SELECT p FROM Pet p JOIN p.user u WHERE u.id = :userId AND p.hasOwner = true")
    List<Pet> findByUserAndHasOwnerIsTrueAndUserRoleIsUser(@Param("userId") Long userId);

    // Get all animals by createdAt
    @Query("SELECT p FROM Pet p ORDER BY p.createdAt DESC")
    List<Pet> findAllOrderedByCreatedAtDesc();

    // Get all animals that are available for adoption by createdAt (ADOPTION)
    @Query("SELECT p FROM Pet p JOIN p.user u WHERE p.hasOwner = false AND p.active = true AND u.role = 'ROLE_ONG' ORDER BY p.createdAt DESC")
    List<Pet> findAllUnownedAndActiveOrderedByCreatedAtDesc();

    // Get all animals that are lost by createdAt (LOST)
    @Query("SELECT p FROM Pet p WHERE p.hasOwner = true AND p.lost = true AND p.active = true ORDER BY p.createdAt DESC")
    List<Pet> findAllOwnedAndLostAndActiveOrderedByCreatedAtDesc();

    Pet findByName(String term);

    List<Pet> findByUser(User user);
}
