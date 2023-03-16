package br.ufac.adotapet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufac.adotapet.model.User;

@Repository
public interface UserProfileRepository extends JpaRepository<User, Long>{
    
}
