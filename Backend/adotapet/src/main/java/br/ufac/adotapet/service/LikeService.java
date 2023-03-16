package br.ufac.adotapet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.ufac.adotapet.model.Like;
import br.ufac.adotapet.model.Pet;
import br.ufac.adotapet.repository.LikeRepository;

@Service
public class LikeService {

    private final LikeRepository likeRepository;

    public LikeService(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    public List<Pet> getPetsLikedByUserId(Long userId) {
        return likeRepository.findPetsByUserId(userId);
    }

    public Like saveLike(Like like) {
        return likeRepository.save(like);
    }

    public void deleteLike(Like like) {
        likeRepository.delete(like);
    }

    public Like getByUserIdAndPetId(Long userId, Long petId) {
        return likeRepository.findFirstByUserIdAndPetId(userId, petId);
    }

    public boolean existsByUserIdAndPetId(Long userId, Long petId) {
        return likeRepository.existsByUserIdAndPetId(userId, petId);
    }
}
