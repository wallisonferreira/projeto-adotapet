package br.ufac.adotapet.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufac.adotapet.model.Adoption;
import br.ufac.adotapet.model.Pet;
import br.ufac.adotapet.model.User;

@Repository
public interface UserAdoptionPetRepository extends JpaRepository<Adoption, Long> {

    List<Adoption> findByUserOwner(User userOwner);

    List<Adoption> findByPetAdopted(Pet petAdopted);

    List<Adoption> findByReqCode(String requestsCode);

    List<Adoption> findByReqStatus(String requestsStatus);

    List<Adoption> findByAdoptionDate(LocalDate adoptionDate);

    List<Adoption> findByAdoptionActive(Boolean adoptionActive);

    Boolean existsByUserOwner_IdAndPetAdopted_Id(Long user_id, Long pet_id);
}
