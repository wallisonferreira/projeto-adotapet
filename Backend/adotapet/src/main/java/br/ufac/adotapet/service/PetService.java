package br.ufac.adotapet.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;

import org.hibernate.Hibernate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.ufac.adotapet.dto.mappers.PetPropertyMap;
import br.ufac.adotapet.dto.mappers.PetRegisteredPropertyMap;
import br.ufac.adotapet.dto.reponses.PetFeedDTO;
import br.ufac.adotapet.dto.reponses.PetFeedNonLoggedDTO;
import br.ufac.adotapet.dto.reponses.PetRegisteredDTO;
import br.ufac.adotapet.dto.reponses.PetWithOwnerDTO;
import br.ufac.adotapet.dto.reponses.ResponsePetRegisterDTO;
import br.ufac.adotapet.dto.requests.RequestPetRegisterDTO;
import br.ufac.adotapet.model.EPetSex;
import br.ufac.adotapet.model.Pet;
import br.ufac.adotapet.model.User;
import br.ufac.adotapet.model.VaccinationRecord;
import br.ufac.adotapet.repository.PetRepository;
import br.ufac.adotapet.repository.UserRepository;
import br.ufac.adotapet.repository.VaccinationRecordRepository;
import br.ufac.adotapet.repository.criteria.params.PetFilterMultiParam;
import br.ufac.adotapet.repository.criteria.params.PetFilterParam;

@Service
public class PetService implements ICrudService<Pet> {

    @Autowired
    private ServletContext context;

    private static String pathPetVaccine = "src/main/java/br/ufac/adotapet/storage/pets-vaccine/";

    private final PetRepository petRepository;
    private final UserRepository userRepository;
    private final VaccinationRecordRepository vaccinationRecordRepository;

    public PetService(
            PetRepository petRepository,
            UserRepository userRepository,
            VaccinationRecordRepository vaccinationRecordRepository) {

        this.petRepository = petRepository;
        this.userRepository = userRepository;
        this.vaccinationRecordRepository = vaccinationRecordRepository;
    }

    public boolean verificarSeUsuarioCurtiuAnimal(Long animalId, Long usuarioId) {
        Pet pet = petRepository.findById(animalId).orElse(null);
        if (pet == null) {
            throw new IllegalArgumentException("Pet not found");
        }
        User user = userRepository.findById(usuarioId).orElse(null);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }

        return pet.getUsersWhoLiked().contains(user);
    }

    /**
     * Pet profile feed by non-logged user.
     */
    public List<PetFeedNonLoggedDTO> getPetFeedNonLogged() {
        List<Pet> pets = petRepository.findAllUnownedAndActiveOrderedByCreatedAtDesc()
                .stream()
                .peek(p -> Hibernate.initialize(p.getUsersWhoLiked()))
                .collect(Collectors.toList());

        List<PetFeedNonLoggedDTO> feed = new ArrayList<>();
        for (Pet pet : pets) {
            PetFeedNonLoggedDTO dto = new PetFeedNonLoggedDTO();
            dto.setId(pet.getId());
            dto.setName(pet.getName());
            dto.setTag(pet.getTag());
            dto.setDescription(pet.getDescription());
            dto.setAge(pet.getAge());
            dto.setHasOwner(pet.getHasOwner());
            dto.setLost(pet.getLost());
            dto.setActive(pet.getActive());
            dto.setProfilePicture(pet.getProfilePicture());
            dto.setDeletedAt(pet.getDeletedAt());
            dto.setOng(pet.getUser());
            dto.setColor(pet.getColor());
            dto.setSize(pet.getSize());
            dto.setRace(pet.getRace());
            dto.setSpecie(pet.getSpecie());
            dto.setSex(pet.getSex());
            dto.setWeight(pet.getWeight());
            dto.setNeutered(pet.getNeutered());
            dto.setDewormed(pet.getDewormed());
            dto.setImages(pet.getImages());
            dto.setCreatedAt(pet.getCreatedAt());
            dto.setUpdatedAt(pet.getUpdatedAt());

            feed.add(dto);
        }

        return feed;
    }

    /**
     * Mapeia os objetos pets para o dto de pet para usuário não logado
     */
    public List<PetFeedNonLoggedDTO> mapPetsToFeedPetDTOs(List<Pet> pets) {

        List<PetFeedNonLoggedDTO> feed = new ArrayList<>();
        for (Pet pet : pets) {
            PetFeedNonLoggedDTO dto = new PetFeedNonLoggedDTO();
            dto.setId(pet.getId());
            dto.setName(pet.getName());
            dto.setTag(pet.getTag());
            dto.setDescription(pet.getDescription());
            dto.setAge(pet.getAge());
            dto.setHasOwner(pet.getHasOwner());
            dto.setLost(pet.getLost());
            dto.setActive(pet.getActive());
            dto.setProfilePicture(pet.getProfilePicture());
            dto.setDeletedAt(pet.getDeletedAt());
            dto.setOng(pet.getUser());
            dto.setColor(pet.getColor());
            dto.setSize(pet.getSize());
            dto.setRace(pet.getRace());
            dto.setSpecie(pet.getSpecie());
            dto.setSex(pet.getSex());
            dto.setWeight(pet.getWeight());
            dto.setNeutered(pet.getNeutered());
            dto.setDewormed(pet.getDewormed());
            dto.setImages(pet.getImages());
            dto.setCreatedAt(pet.getCreatedAt());
            dto.setUpdatedAt(pet.getUpdatedAt());

            feed.add(dto);
        }

        return feed;
    }

    /**
     * Mapeia os objetos pets para o dto de pet para usuário não logado
     */
    public List<PetFeedDTO> mapPetsToFeedPetDTOsLoggedUser(List<Pet> pets, Long usuarioId) {

        List<PetFeedDTO> feed = new ArrayList<>();
        for (Pet pet : pets) {
            PetFeedDTO dto = new PetFeedDTO();
            dto.setId(pet.getId());
            dto.setName(pet.getName());
            dto.setTag(pet.getTag());
            dto.setDescription(pet.getDescription());
            dto.setAge(pet.getAge());
            dto.setHasOwner(pet.getHasOwner());
            dto.setLost(pet.getLost());
            dto.setActive(pet.getActive());
            dto.setProfilePicture(pet.getProfilePicture());
            dto.setDeletedAt(pet.getDeletedAt());
            dto.setOng(pet.getUser());
            dto.setColor(pet.getColor());
            dto.setSize(pet.getSize());
            dto.setRace(pet.getRace());
            dto.setSpecie(pet.getSpecie());
            dto.setSex(pet.getSex());
            dto.setWeight(pet.getWeight());
            dto.setNeutered(pet.getNeutered());
            dto.setDewormed(pet.getDewormed());
            dto.setImages(pet.getImages());
            dto.setCreatedAt(pet.getCreatedAt());
            dto.setUpdatedAt(pet.getUpdatedAt());
            dto.setIsLiked(verificarSeUsuarioCurtiuAnimal(pet.getId(), usuarioId));
            dto.setUsersWhoLiked(pet.getUsersWhoLiked());
            dto.setCountLikes(pet.getLikesCount());

            feed.add(dto);
        }

        return feed;
    }

    /**
     * Pet profile feed by logged user
     */
    public List<PetFeedDTO> getPetFeed(Long usuarioId) {
        List<Pet> pets = petRepository.findAllUnownedAndActiveOrderedByCreatedAtDesc()
                .stream()
                .peek(p -> Hibernate.initialize(p.getUsersWhoLiked()))
                .collect(Collectors.toList());

        List<PetFeedDTO> feed = new ArrayList<>();
        for (Pet pet : pets) {
            PetFeedDTO dto = new PetFeedDTO();
            dto.setId(pet.getId());
            dto.setName(pet.getName());
            dto.setTag(pet.getTag());
            dto.setDescription(pet.getDescription());
            dto.setAge(pet.getAge());
            dto.setHasOwner(pet.getHasOwner());
            dto.setLost(pet.getLost());
            dto.setActive(pet.getActive());
            dto.setProfilePicture(pet.getProfilePicture());
            dto.setDeletedAt(pet.getDeletedAt());
            dto.setOng(pet.getUser());
            dto.setColor(pet.getColor());
            dto.setSize(pet.getSize());
            dto.setRace(pet.getRace());
            dto.setSpecie(pet.getSpecie());
            dto.setSex(pet.getSex());
            dto.setWeight(pet.getWeight());
            dto.setNeutered(pet.getNeutered());
            dto.setDewormed(pet.getDewormed());
            dto.setImages(pet.getImages());
            dto.setCreatedAt(pet.getCreatedAt());
            dto.setUpdatedAt(pet.getUpdatedAt());
            dto.setIsLiked(verificarSeUsuarioCurtiuAnimal(pet.getId(), usuarioId));
            dto.setUsersWhoLiked(pet.getUsersWhoLiked());
            dto.setCountLikes(pet.getLikesCount());

            feed.add(dto);
        }

        return feed;
    }

    // ------------------------------------------ registered pets

    public PetRegisteredDTO getPetByIdOrTag(Long id, String tag) {
        Pet pet = petRepository.findByIdOrTag(id, tag);

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PetRegisteredPropertyMap());
        if (pet == null) {
            throw new IllegalArgumentException("Pet not found");
        }
        return modelMapper.map(pet, PetRegisteredDTO.class);
    }

    /**
     * Get pets registered by a particular owner user (Registered)
     */
    public List<PetRegisteredDTO> getPetsRegistered(Long userId) {

        List<Pet> pets = petRepository.findByUserAndHasOwnerIsTrueAndUserRoleIsUser(userId);

        List<PetRegisteredDTO> petRegisteredDto = new ArrayList<>();
        for (Pet pet : pets) {
            PetRegisteredDTO dto = new PetRegisteredDTO();
            dto.setId(pet.getId());
            dto.setName(pet.getName());
            dto.setTag(pet.getTag());
            dto.setDescription(pet.getDescription());
            dto.setAge(pet.getAge());
            dto.setProfilePicture(pet.getProfilePicture());
            dto.setOwner(pet.getUser());
            dto.setColor(pet.getColor());
            dto.setSize(pet.getSize());
            dto.setRace(pet.getRace());
            dto.setSpecie(pet.getSpecie());
            dto.setSex(pet.getSex().name());
            dto.setWeight(pet.getWeight());
            dto.setLost(pet.getLost());
            dto.setNeutered(pet.getNeutered());
            dto.setDewormed(pet.getDewormed());
            dto.setImages(pet.getImages());
            dto.setCreatedAt(pet.getCreatedAt());
            dto.setUpdatedAt(pet.getUpdatedAt());

            petRegisteredDto.add(dto);
        }

        return petRegisteredDto;
    }

    public ResponsePetRegisterDTO registerPet(
            RequestPetRegisterDTO petRegisterDTO,
            Long userOwnerId) {

        User user = userRepository.findById(userOwnerId)
                .orElseThrow();

        // register a new pet
        Pet pet = new Pet();
        pet.setName(petRegisterDTO.getName());
        if (petRegisterDTO.getTag() == null) {
            pet.setTag(UUID.randomUUID().toString());
        } else {
            pet.setTag(petRegisterDTO.getTag());
        }
        pet.setDescription(petRegisterDTO.getDescription());
        pet.setAge(petRegisterDTO.getAge());
        pet.setUser(user);
        pet.setColor(petRegisterDTO.getColor());
        pet.setSize(petRegisterDTO.getSize());
        pet.setRace(petRegisterDTO.getRace());
        pet.setSpecie(petRegisterDTO.getSpecie());
        pet.setSex(EPetSex.valueOf(petRegisterDTO.getSex()));
        pet.setWeight(petRegisterDTO.getWeight());
        pet.setNeutered(petRegisterDTO.getNeutered());
        pet.setDewormed(petRegisterDTO.getDewormed());

        // tell if animal is lost
        if (petRegisterDTO.getLost() == null) {
            pet.setLost(false);
        } else {
            pet.setLost(petRegisterDTO.getLost());
        }

        // properties of a registered animal
        pet.setHasOwner(true);
        pet.setActive(true);

        try {
            Pet petSaved = petRepository.save(pet);

            ModelMapper modelMapper = new ModelMapper();

            // preencher valores em pet
            ResponsePetRegisterDTO dto = modelMapper.map(petSaved, ResponsePetRegisterDTO.class);
            dto.setOwner(petSaved.getUser());
            return dto;
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro ao persistir animal.");
        }
    }

    public List<PetFeedNonLoggedDTO> getNonLoggedFilter(
            PetFilterMultiParam params) {

        List<Pet> pets = petRepository.getWithMultiFilter(params);
        List<PetFeedNonLoggedDTO> petsNonLogged = this.mapPetsToFeedPetDTOs(pets);
        return petsNonLogged;
    }

    public List<PetFeedDTO> getAllFilter(
            PetFilterMultiParam params,
            Long userId) {

        List<Pet> pets = petRepository.getWithMultiFilter(params);
        List<PetFeedDTO> petsLogged = this.mapPetsToFeedPetDTOsLoggedUser(pets, userId);
        return petsLogged;
    }

    public List<VaccinationRecord> getVaccineByPetId(Long petId) {
        return vaccinationRecordRepository.findByPetId(petId);
    }

    public void saveVaccinationRecords(List<MultipartFile> files, Long petId) throws IOException {

        // get pet
        Pet pet = petRepository.findById(petId).orElseThrow();

        for (MultipartFile file : files) {

            byte[] bytes = file.getBytes();

            // give a new name for file
            String nameFile = UUID.randomUUID().toString();

            String filePath = nameFile + ".pdf";
            String fullPath = context.getContextPath() + pathPetVaccine + nameFile + ".pdf";

            Path path = Paths.get(fullPath);
            Files.write(path, bytes);

            VaccinationRecord vaccinationRecord = new VaccinationRecord();

            vaccinationRecord.setPet(pet);
            vaccinationRecord.setPath(filePath);
            vaccinationRecordRepository.save(vaccinationRecord);
        }
    }

    /**
     * Um usuário logado pega um animal
     */
    public PetFeedDTO getByIdLogged(Long id, Long userId) {
        Pet pet = petRepository.findById(id).orElse(null);

        PetFeedDTO dto = new PetFeedDTO();
        dto.setId(pet.getId());
        dto.setName(pet.getName());
        dto.setTag(pet.getTag());
        dto.setDescription(pet.getDescription());
        dto.setAge(pet.getAge());
        dto.setHasOwner(pet.getHasOwner());
        dto.setLost(pet.getLost());
        dto.setActive(pet.getActive());
        dto.setProfilePicture(pet.getProfilePicture());
        dto.setDeletedAt(pet.getDeletedAt());
        dto.setOng(pet.getUser());
        dto.setColor(pet.getColor());
        dto.setSize(pet.getSize());
        dto.setRace(pet.getRace());
        dto.setSpecie(pet.getSpecie());
        dto.setSex(pet.getSex());
        dto.setWeight(pet.getWeight());
        dto.setNeutered(pet.getNeutered());
        dto.setDewormed(pet.getDewormed());
        dto.setImages(pet.getImages());
        dto.setCreatedAt(pet.getCreatedAt());
        dto.setUpdatedAt(pet.getUpdatedAt());
        dto.setIsLiked(verificarSeUsuarioCurtiuAnimal(pet.getId(), userId));
        dto.setUsersWhoLiked(pet.getUsersWhoLiked());
        dto.setCountLikes(pet.getLikesCount());

        return dto;
    }

    // ------------------------------------------ lost pets

    /**
     * Gets a feed of pets lost (Lost)
     */
    public List<PetRegisteredDTO> getFeedPetsLost() {

        List<Pet> pets = petRepository.findByLostOrderByCreatedAtDesc(true);

        List<PetRegisteredDTO> petRegisteredDto = new ArrayList<>();
        for (Pet pet : pets) {
            PetRegisteredDTO dto = new PetRegisteredDTO();
            dto.setId(pet.getId());
            dto.setName(pet.getName());
            dto.setTag(pet.getTag());
            dto.setDescription(pet.getDescription());
            dto.setAge(pet.getAge());
            dto.setProfilePicture(pet.getProfilePicture());
            dto.setOwner(pet.getUser());
            dto.setColor(pet.getColor());
            dto.setSize(pet.getSize());
            dto.setRace(pet.getRace());
            dto.setSpecie(pet.getSpecie());
            dto.setSex(pet.getSex().name());
            dto.setWeight(pet.getWeight());
            dto.setLost(pet.getLost());
            dto.setNeutered(pet.getNeutered());
            dto.setDewormed(pet.getDewormed());
            dto.setImages(pet.getImages());
            dto.setCreatedAt(pet.getCreatedAt());
            dto.setUpdatedAt(pet.getUpdatedAt());

            petRegisteredDto.add(dto);
        }

        return petRegisteredDto;
    }

    /**
     * Um usuário não logado pega um animal
     */
    public PetFeedNonLoggedDTO getByIdNonLogged(Long id) {

        Pet pet = petRepository.findById(id).orElse(null);

        PetFeedNonLoggedDTO dto = new PetFeedNonLoggedDTO();
        dto.setId(pet.getId());
        dto.setName(pet.getName());
        dto.setTag(pet.getTag());
        dto.setDescription(pet.getDescription());
        dto.setAge(pet.getAge());
        dto.setHasOwner(pet.getHasOwner());
        dto.setLost(pet.getLost());
        dto.setActive(pet.getActive());
        dto.setProfilePicture(pet.getProfilePicture());
        dto.setDeletedAt(pet.getDeletedAt());
        dto.setOng(pet.getUser());
        dto.setColor(pet.getColor());
        dto.setSize(pet.getSize());
        dto.setRace(pet.getRace());
        dto.setSpecie(pet.getSpecie());
        dto.setSex(pet.getSex());
        dto.setWeight(pet.getWeight());
        dto.setNeutered(pet.getNeutered());
        dto.setDewormed(pet.getDewormed());
        dto.setImages(pet.getImages());
        dto.setCreatedAt(pet.getCreatedAt());
        dto.setUpdatedAt(pet.getUpdatedAt());

        return dto;
    }

    public Pet changeStatus(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public List<Pet> getAll() {
        return petRepository.findAll();
    }

    public List<Pet> getAll(PetFilterParam params, Long userId) {
        List<Pet> pets = petRepository.findAll();
        return pets;
    }

    @Override
    public List<Pet> getByAll(String term) {
        return petRepository.findByAll(term);
    }

    @Override
    public Pet getById(Long id) {
        return petRepository.findById(id).orElse(null);
    }

    @Override
    public Pet save(Pet object) {
        return petRepository.save(object);
    }

    @Override
    public Pet save(Pet object, Long id) {
        object.setId(id);
        return petRepository.save(object);
    }

    @Override
    public void delete(Long id) {
        petRepository.deleteById(id);
    }

    Pet findByName(String term) {
        return petRepository.findByName(term);
    }
}
