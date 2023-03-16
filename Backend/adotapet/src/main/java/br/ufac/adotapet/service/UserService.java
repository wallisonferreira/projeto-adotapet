package br.ufac.adotapet.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufac.adotapet.dto.requests.UserRegistrationDTO;
import br.ufac.adotapet.model.User;
import br.ufac.adotapet.repository.UserRepository;

@Service
public class UserService implements ICrudService<User> {

    private final UserRepository repo;
    private final ModelMapper modelMapper;

    @Autowired
    public UserService(
            UserRepository repo,
            ModelMapper modelMapper) {
        this.repo = repo;
        this.modelMapper = modelMapper;
    }

    public User registerUser(UserRegistrationDTO userRegistrationDTO) {
        User user = modelMapper.map(userRegistrationDTO, User.class);
        return repo.save(user);
    }

    @Override
    public List<User> getAll() {
        return repo.findAll();
    }

    @Override
    public User getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<User> getByAll(String term) {
        return repo.findByAll(term);
    }

    public List<User> getByRole(String term) {
        return repo.findAllByRole(term);
    }

    @Override
    public User save(User object) {

        object.setPassword(object.getPassword(), false);

        return repo.save(object);
    }

    @Override
    public User save(User object, Long id) {
        if (object.getPassword() == null) {
            User user = repo.findById(id).orElse(null);
            if (user != null) {
                object.setPassword(user.getPassword(), false);
                object.setId(id);
            }
        }
        return repo.save(object);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    public User getByName(String term) {
        User user = repo.findByName(term);
        return user;
    }

    public User getByEmail(String term) {
        User user = repo.findByEmail(term);
        return user;
    }
}
