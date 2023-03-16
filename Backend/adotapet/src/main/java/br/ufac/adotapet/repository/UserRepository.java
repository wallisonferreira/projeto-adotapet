package br.ufac.adotapet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.ufac.adotapet.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.name LIKE %?1%" +
            " OR u.email LIKE %?1%")
    List<User> findByAll(String term);

    @Query(value = "SELECT * FROM user AS u WHERE u.role = :term", nativeQuery = true)
    List<User> findAllByRole(String term);

    User findByName(String term);

    User findByEmail(String term);

    Boolean existsByName(String term);

    Boolean existsByEmail(String term);
}
