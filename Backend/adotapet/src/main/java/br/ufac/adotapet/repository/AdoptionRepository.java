package br.ufac.adotapet.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ufac.adotapet.model.Adoption;
import br.ufac.adotapet.model.Pet;
import br.ufac.adotapet.model.User;

public interface AdoptionRepository extends JpaRepository<Adoption, Long> {

    @Query("SELECT a FROM Adoption a JOIN a.petAdopted p WHERE p.user.id = :userId")
    Page<Adoption> findByPetUser_Id(Long userId, Pageable pageable);

    List<Adoption> findByUserOwner(User userOwner);

    List<Adoption> findByPetAdopted(Pet petAdopted);

    List<Adoption> findByReqCode(String requestsCode);

    List<Adoption> findByReqStatus(String requestsStatus);

    List<Adoption> findByAdoptionDate(LocalDate adoptionDate);

    List<Adoption> findByAdoptionActive(Boolean adoptionActive);

    Boolean existsByUserOwner_IdAndPetAdopted_Id(Long user_id, Long pet_id);
}
