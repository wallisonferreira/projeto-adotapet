package br.ufac.adotapet.service;

import org.springframework.stereotype.Service;

import br.ufac.adotapet.model.User;
import br.ufac.adotapet.repository.UserProfileRepository;

@Service
public class UserProfileService {

    private final UserProfileRepository repo;

    public UserProfileService(UserProfileRepository repo) {
        this.repo = repo;
    }

    public User getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public User save(User object) {
        updateVerifiedStatus(object.getId());
        return repo.save(object);
    }

    public void updateVerifiedStatus(Long userId) {
        User user = repo.findById(userId).orElse(null);
        if (user == null) {
            throw new IllegalArgumentException("Usuário não encontrado");
        }
        if (user.getName() != null &&
                user.getCpf() != null &&
                user.getPhone() != null &&
                user.getBirthDate() != null &&
                user.getJob() != null &&
                user.getIncome() != null &&
                user.getTypeResidence() != null &&
                user.getFreeTime() != null &&
                user.getChildAtHome() != null &&
                user.getPetAtHome() != null &&
                user.getFullAddress() != null) {

            user.setVerified(true);
            repo.save(user);
        }
    }
}
