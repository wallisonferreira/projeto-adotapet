package br.ufac.adotapet.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufac.adotapet.model.Adoption;
import br.ufac.adotapet.model.Pet;
import br.ufac.adotapet.model.User;
import br.ufac.adotapet.security.services.UserDetailsImpl;
import br.ufac.adotapet.service.AdoptionService;
import br.ufac.adotapet.service.PetService;
import br.ufac.adotapet.service.UserAdoptionPetService;
import br.ufac.adotapet.service.UserService;

@RestController
@RequestMapping("/adoption")
public class UserAdoptionPetController {

    public UserAdoptionPetService userAdoptionPetService;
    public AdoptionService adoptionService;
    public PetService petService;
    public UserService userService;

    public UserAdoptionPetController(
            UserAdoptionPetService userAdoptionPetService,
            AdoptionService adoptionService,
            PetService petService,
            UserService userService) {

        this.userAdoptionPetService = userAdoptionPetService;
        this.adoptionService = adoptionService;
        this.petService = petService;
        this.userService = userService;
    }

    @PostMapping("/pet/{id}")
    public ResponseEntity<Adoption> insertAdoption(@PathVariable("id") Long id, Authentication authentication) {
        /**
         * Get object of logged user
         */
        UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authentication.getPrincipal();
        User userOwner = userService.getById(userDetailsImpl.getId());

        /**
         * Get pet by id
         */
        Pet petAdopted = petService.getById(id);

        /**
         * Validates if already exists one requirement for user and pet
         */

        Boolean exists = userAdoptionPetService.existsByUserAndPet(userOwner.getId(), id);

        if (exists == true) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        /**
         * Create an adoption requirement
         */
        Adoption adoption = adoptionService.save(new Adoption(userOwner, petAdopted));

        return new ResponseEntity<>(adoption, HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Adoption>> getUserAdoption(Authentication authentication) {
        UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authentication.getPrincipal();
        User userOwner = userService.getById(userDetailsImpl.getId());

        List<Adoption> adoptionList = userAdoptionPetService.findAdoptionByUserOwner(userOwner);

        return new ResponseEntity<>(adoptionList, HttpStatus.OK);
    }
}
