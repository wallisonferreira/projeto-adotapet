package br.ufac.adotapet.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.ufac.adotapet.model.User;
import br.ufac.adotapet.projections.CountPetByOng;
import br.ufac.adotapet.projections.FeedPets;

@Repository
public interface OngRepository extends JpaRepository<User, Long> {

    @Transactional
    @Query(value = "SELECT u.name AS name, u.email AS email, u.role AS role, count(p.id) as petcount FROM " +
            "pet AS p INNER JOIN user AS u ON p.user_id_creator = u.id GROUP BY u.id ORDER BY petcount", nativeQuery = true)
    List<CountPetByOng> getCountPetsByOng();

    @Transactional
    @Query(value = "SELECT u.id AS ongid, u.name AS ongname, u.email AS ongemail, u.role AS role, p.id AS petid, p.name AS petname, p.profile_picture AS petprofilepicture FROM "
            +
            "pet AS p INNER JOIN user AS u ON p.user_id_creator = u.id ORDER BY petname", nativeQuery = true)
    List<FeedPets> getFeedPets();
}
