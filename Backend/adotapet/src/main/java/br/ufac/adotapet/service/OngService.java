package br.ufac.adotapet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.ufac.adotapet.projections.CountPetByOng;
import br.ufac.adotapet.projections.FeedPets;
import br.ufac.adotapet.repository.AdoptionRepository;
import br.ufac.adotapet.repository.OngRepository;

@Service
public class OngService {

    private final OngRepository ongRepository;

    public OngService(
            OngRepository ongRepository,
            AdoptionRepository adoptionRepository) {
        this.ongRepository = ongRepository;
    }

    // public void changeStatusAdoption(
    // Long adoptionId,
    // String status) {
    // Adoption adoption = adoptionRepository.findById(adoptionId)
    // .orElse(null);
    // }

    public List<CountPetByOng> getCountPetsByOng() {

        return ongRepository.getCountPetsByOng();
    }

    public List<FeedPets> getFeedPets() {
        return ongRepository.getFeedPets();
    }

}
