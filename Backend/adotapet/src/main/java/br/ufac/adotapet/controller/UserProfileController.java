package br.ufac.adotapet.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.math.BigDecimal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.ufac.adotapet.dto.reponses.PetFeedDTO;
import br.ufac.adotapet.dto.reponses.PetFeedNonLoggedDTO;
import br.ufac.adotapet.dto.reponses.PetRegisteredDTO;
import br.ufac.adotapet.dto.reponses.ResponseAdoptionDTO;
import br.ufac.adotapet.dto.reponses.ResponseDataGeneral;
import br.ufac.adotapet.dto.reponses.ResponsePetRegisterDTO;
import br.ufac.adotapet.dto.requests.RequestAdoptionDTO;
import br.ufac.adotapet.dto.requests.RequestPetRegisterDTO;
import br.ufac.adotapet.model.Adoption;
import br.ufac.adotapet.model.ESex;
import br.ufac.adotapet.model.Like;
import br.ufac.adotapet.model.Pet;
import br.ufac.adotapet.model.User;
import br.ufac.adotapet.security.services.UserDetailsImpl;
import br.ufac.adotapet.service.AdoptionService;
import br.ufac.adotapet.service.ImageService;
import br.ufac.adotapet.service.LikeService;
import br.ufac.adotapet.service.PetService;
import br.ufac.adotapet.service.UserAdoptionPetService;
import br.ufac.adotapet.service.UserProfileService;
import br.ufac.adotapet.traits.ValidationTraits;

@RestController
@RequestMapping("/user/profile")
public class UserProfileController {

    private UserProfileService userService;
    private LikeService likeService;
    private PetService petService;
    private ImageService imageService;
    private UserAdoptionPetService userAdoptionPetService;
    private AdoptionService adoptionService;

    public UserProfileController(
            UserProfileService userService,
            LikeService likeService,
            PetService petService,
            ImageService imageService,
            UserAdoptionPetService userAdoptionPetService,
            AdoptionService adoptionService) {

        this.userService = userService;
        this.likeService = likeService;
        this.petService = petService;
        this.imageService = imageService;
        this.userAdoptionPetService = userAdoptionPetService;
        this.adoptionService = adoptionService;
    }

    public static LocalDate convertToLocalDate(String birthDateStr) {
        return LocalDate.parse(birthDateStr, DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public static BigDecimal convertToBigDecimal(Object incomeStr) {
        return BigDecimal.valueOf(Double.parseDouble(incomeStr.toString()));
    }

    public static Integer convertToInt(Object str) {
        return Integer.valueOf(str.toString());
    }

    public static Boolean convertToBoolean(Object obj) {
        Integer integerValue = Integer.parseInt(obj.toString());
        return integerValue != 0;
    }

    /**
     * Upload profile image for user
     * 
     * @param file
     * @param authentication
     * @return
     */
    @PostMapping("/profile-image")
    public ResponseEntity<User> saveImage(
            @RequestParam("file") MultipartFile file,
            Authentication authentication) {

        UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authentication.getPrincipal();

        if (ValidationTraits.isImageFile(file) == false) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            if (!file.isEmpty()) {
                User updatedUser = imageService.saveImageForUser(
                        userDetailsImpl.getId(), file);
                return new ResponseEntity<>(updatedUser, HttpStatus.CREATED);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/pet/likes")
    public ResponseEntity<List<Pet>> getLikes(Authentication authentication) {

        UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authentication.getPrincipal();

        List<Pet> petsLiked = likeService.getPetsLikedByUserId(userDetailsImpl.getId());

        return new ResponseEntity<>(petsLiked, HttpStatus.OK);
    }

    /**
     * Feed de usuário não logado
     * 
     * @param authentication
     * @return
     */
    @GetMapping("/pet/feed-non-logged")
    public ResponseEntity<List<PetFeedNonLoggedDTO>> getPetFeed() {

        List<PetFeedNonLoggedDTO> feedPets = petService.getPetFeedNonLogged();

        return new ResponseEntity<>(feedPets, HttpStatus.OK);
    }

    /**
     * Feed de usuário logado
     * 
     * @param authentication
     * @return
     */
    @GetMapping("/pet/feed")
    public ResponseEntity<List<PetFeedDTO>> getPetFeed(Authentication authentication) {

        UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authentication.getPrincipal();

        List<PetFeedDTO> feedPets = petService.getPetFeed(userDetailsImpl.getId());

        return new ResponseEntity<>(feedPets, HttpStatus.OK);
    }

    @PostMapping("/pet/{id}/like")
    public ResponseEntity<Like> likePet(Authentication authentication, @PathVariable("id") Long id) {

        UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authentication.getPrincipal();
        User user = userService.getById(userDetailsImpl.getId());
        Pet pet = petService.getById(id);

        if (likeService.existsByUserIdAndPetId(user.getId(), id) == true) {
            try {
                Like like = likeService.getByUserIdAndPetId(user.getId(), id);
                likeService.deleteLike(like);
                return new ResponseEntity<>(HttpStatus.OK);
            } catch (Exception e) {
                throw new IllegalArgumentException("Insconsistência na busca de curtida. \n" + e.getMessage());
            }
        }

        try {
            Like like = new Like(user, pet);
            Like savedLike = likeService.saveLike(like);
            return new ResponseEntity<>(savedLike, HttpStatus.OK);
        } catch (Exception e) {
            throw new IllegalArgumentException("Insconsistência na inserção de curtida. \n" + e.getMessage());
        }
    }

    @GetMapping("/details")
    public ResponseEntity<User> getDetails(Authentication authentication) {

        UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authentication.getPrincipal();

        User user = userService.getById(userDetailsImpl.getId());

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateResource(Authentication authentication,
            @RequestBody Map<String, Object> updates) {

        UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authentication.getPrincipal();

        User user = userService.getById(userDetailsImpl.getId());

        updates.entrySet().stream()
                .filter(entry -> entry.getValue() != null)
                .forEach(entry -> {
                    String key = entry.getKey();
                    if (key.equals("name")) {
                        user.setName((String) entry.getValue());
                    }
                    if (key.equals("cpf")) {
                        user.setCpf((String) entry.getValue());
                    }
                    if (key.equals("phone")) {
                        user.setPhone((String) entry.getValue());
                    }
                    if (key.equals("birthDate")) {
                        user.setBirthDate((LocalDate) convertToLocalDate(entry.getValue().toString()));
                    }
                    if (key.equals("job")) {
                        user.setJob((String) entry.getValue());
                    }
                    if (key.equals("income")) {
                        user.setIncome(convertToBigDecimal(entry.getValue()));
                    }
                    if (key.equals("typeResidence")) {
                        user.setTypeResidence((String) entry.getValue());
                    }
                    if (key.equals("freeTime")) {
                        user.setFreeTime((Integer) convertToInt(entry.getValue()));
                    }
                    if (key.equals("childAtHome")) {
                        user.setChildAtHome((Boolean) entry.getValue());
                    }
                    if (key.equals("petAtHome")) {
                        user.setPetAtHome((Boolean) entry.getValue());
                    }
                    if (key.equals("age")) {
                        user.setAge((Integer) entry.getValue());
                    }
                    if (key.equals("sex")) {
                        String sexValue = (String) entry.getValue();
                        for (ESex sex : ESex.values()) {
                            if (sex.name().equalsIgnoreCase(sexValue)) {
                                user.setSex(sex);
                            }
                        }
                    }

                    // não pode ser nulo
                    if (key.equals("localTitle")) {
                        user.setLocalTitle((String) entry.getValue());
                    }
                    if (key.equals("fullAddress")) {
                        user.setFullAddress((String) entry.getValue());
                    }
                    if (key.equals("description")) {
                        user.setDescription((String) entry.getValue());
                    }
                    if (key.equals("cep")) {
                        user.setCep((String) entry.getValue());
                    }
                    if (key.equals("latitude")) {
                        user.setLatitude((Double) entry.getValue());
                    }
                    if (key.equals("longitude")) {
                        user.setLongitude((Double) entry.getValue());
                    }
                });
        userService.updateVerifiedStatus(user.getId());
        User updatedResource = userService.save(user);
        return new ResponseEntity<>(updatedResource, HttpStatus.OK);
    }

    @PostMapping("/pet/{id}/adoption-requests")
    public ResponseEntity<ResponseAdoptionDTO> adoptionRequest(
            @PathVariable("id") Long id,
            Authentication authentication,
            @RequestBody RequestAdoptionDTO requestAdoption) {

        // Get object of logged user
        UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authentication.getPrincipal();
        User userOwner = userService.getById(userDetailsImpl.getId());

        // Get pet by id
        Pet petAdopted = petService.getById(id);

        // Validates if already exists one request for user and pet
        Boolean exists = adoptionService.existsByUserAndPet(userOwner.getId(), id);
        if (Boolean.TRUE.equals(exists)) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        // Create an adoption requirement
        ResponseAdoptionDTO adoptionSaved = adoptionService.createAdoption(
                userOwner,
                petAdopted,
                requestAdoption);

        return new ResponseEntity<>(adoptionSaved, HttpStatus.CREATED);
    }

    @GetMapping("/list-adoption-requests")
    public ResponseEntity<List<Adoption>> getUserAdoption(Authentication authentication) {
        UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authentication.getPrincipal();
        User userOwner = userService.getById(userDetailsImpl.getId());

        List<Adoption> adoptionList = userAdoptionPetService.findAdoptionByUserOwner(userOwner);

        return new ResponseEntity<>(adoptionList, HttpStatus.OK);
    }

    // ------------------------------------- My Pets registered

    @GetMapping("/pets/tag/{idOrTag}")
    public ResponseEntity<PetRegisteredDTO> getPetByIdOrTag(@PathVariable("idOrTag") String idOrTag) {
        Long id = null;
        String tag = null;
        try {
            id = Long.parseLong(idOrTag);
        } catch (NumberFormatException ex) {
            tag = idOrTag;
        }
        PetRegisteredDTO petDTO = petService.getPetByIdOrTag(id, tag);
        return ResponseEntity.ok(petDTO);
    }

    @GetMapping("/list-registered")
    public ResponseEntity<List<PetRegisteredDTO>> getListRegistered(
            Authentication authentication) {
        UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authentication.getPrincipal();

        List<PetRegisteredDTO> listRegistered = petService.getPetsRegistered(userDetailsImpl.getId());

        return new ResponseEntity<>(listRegistered, HttpStatus.OK);
    }

    @PostMapping("/register-pet")
    public ResponseEntity<ResponsePetRegisterDTO> registerPet(
            Authentication authentication,
            @RequestBody RequestPetRegisterDTO object) {

        UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authentication.getPrincipal();

        ResponsePetRegisterDTO petRegisterDTO = petService.registerPet(
                object, userDetailsImpl.getId());

        return new ResponseEntity<>(petRegisterDTO, HttpStatus.OK);
    }

    // ------------------------------------- Lost management
    @PostMapping("/pet-registered/{id}/make-lost")
    public ResponseEntity<Map<String, Object>> makeRegisterPetLost(@PathVariable("id") Long id) {

        Pet pet = petService.getById(id);

        if (pet.getLost()) {
            try {
                pet.setLost(false);
                Pet petSaved = petService.changeStatus(pet);
                Map<String, Object> response = new HashMap<>();
                response.put("id", petSaved.getId());
                response.put("name", petSaved.getName());
                response.put("lost", petSaved.getLost());
                return new ResponseEntity<>(response, HttpStatus.OK);
            } catch (Exception e) {
                throw new IllegalArgumentException("Inconsistência na marcação de não-perdido. \n" + e.getMessage());
            }
        }

        try {
            pet.setLost(true);
            Pet petSaved = petService.changeStatus(pet);
            Map<String, Object> response = new HashMap<>();
            response.put("id", petSaved.getId());
            response.put("name", petSaved.getName());
            response.put("lost", petSaved.getLost());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            throw new IllegalArgumentException("Inconsistência na marcação de perdido.\n" + e.getMessage());
        }
    }
}
