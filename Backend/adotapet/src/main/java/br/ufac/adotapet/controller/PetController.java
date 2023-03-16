package br.ufac.adotapet.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.ufac.adotapet.dto.reponses.PetFeedDTO;
import br.ufac.adotapet.dto.reponses.PetFeedNonLoggedDTO;
import br.ufac.adotapet.dto.reponses.PetFilterOptions;
import br.ufac.adotapet.dto.reponses.PetRegisteredDTO;
import br.ufac.adotapet.dto.reponses.ResponseDataGeneral;
import br.ufac.adotapet.dto.reponses.ResponseDataImage;
import br.ufac.adotapet.dto.reponses.ResponseDataVaccine;
import br.ufac.adotapet.dto.reponses.ResponsePetRegisterDTO;
import br.ufac.adotapet.dto.requests.RequestPetRegisterDTO;
import br.ufac.adotapet.dto.responses.ResponseData;
import br.ufac.adotapet.model.Color;
import br.ufac.adotapet.model.EPetSex;
import br.ufac.adotapet.model.Image;
import br.ufac.adotapet.model.Pet;
import br.ufac.adotapet.model.Race;
import br.ufac.adotapet.model.Size;
import br.ufac.adotapet.model.Specie;
import br.ufac.adotapet.model.VaccinationRecord;
import br.ufac.adotapet.repository.criteria.params.PetFilterMultiParam;
import br.ufac.adotapet.repository.criteria.params.PetFilterParam;
import br.ufac.adotapet.security.services.UserDetailsImpl;
import br.ufac.adotapet.service.ColorService;
import br.ufac.adotapet.service.ImageService;
import br.ufac.adotapet.service.PetService;
import br.ufac.adotapet.service.RaceService;
import br.ufac.adotapet.service.SizeService;
import br.ufac.adotapet.service.SpecieService;
import br.ufac.adotapet.service.VaccineRecordService;
import br.ufac.adotapet.traits.ValidationTraits;

@RestController
@RequestMapping("/pet")
public class PetController implements IController<Pet> {

    @Autowired
    private ServletContext context;

    private static String pathPetProfileImages = "src/main/java/br/ufac/adotapet/storage/pets/";
    private static String pathPetGallery = "src/main/java/br/ufac/adotapet/storage/pets-gallery/";
    private static String pathPetVaccine = "src/main/java/br/ufac/adotapet/storage/pets-vaccine/";

    private final PetService petService;
    private final ColorService colorService;
    private final RaceService raceService;
    private final SizeService sizeService;
    private final SpecieService specieService;
    private final ImageService imageService;
    private final VaccineRecordService vaccineService;

    public PetController(
            PetService petService,
            ColorService colorService,
            RaceService raceService,
            SizeService sizeService,
            SpecieService specieService,
            ImageService imageService,
            VaccineRecordService vaccineService) {

        this.petService = petService;
        this.colorService = colorService;
        this.raceService = raceService;
        this.sizeService = sizeService;
        this.specieService = specieService;
        this.imageService = imageService;
        this.vaccineService = vaccineService;
    }

    /**
     * Upload profile image for pets
     * 
     * @param file
     * @param authentication
     * @return
     */
    @PostMapping("/{id}/profile-image/upload")
    public ResponseEntity<Pet> saveImage(
            @RequestParam("file") MultipartFile file,
            @PathVariable("id") Long id) {

        if (ValidationTraits.isImageFile(file) == false) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            if (!file.isEmpty()) {
                Pet updatedPet = imageService.saveImageForPet(id, file);
                return new ResponseEntity<>(updatedPet, HttpStatus.CREATED);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Get profile image of only one pet
     * 
     * @param nameFile
     * @return ResponseEntity<byte[]>
     */
    @GetMapping("/image/{nameFile}")
    public ResponseEntity<byte[]> getImage(@PathVariable("nameFile") String nameFile)
            throws IOException {
        File imageFile = new File(
                context.getContextPath() + pathPetProfileImages + nameFile);

        if (nameFile != null) {
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(Files.readAllBytes(imageFile.toPath()));
        }

        return null;
    }

    /**
     * Adds a list of item images for a pet slider
     * 
     * @param files
     * @param petId
     * @return
     */
    @PostMapping("/{id}/image-gallery/upload")
    public ResponseEntity<ResponseDataImage> addItemsToSlider(
            @RequestParam("file") List<MultipartFile> files,
            @PathVariable("id") Long petId) {

        List<Image> imageSaved = new ArrayList<>();

        for (MultipartFile file : files) {
            try {
                Image image = imageService.saveImageForPetGallery(petId, file);
                imageSaved.add(image);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new ResponseEntity<>(
                new ResponseDataImage(imageSaved, "Salvo com sucesso"),
                HttpStatus.OK);
    }

    /**
     * Get only one image that is an item of a pet slider
     * 
     * @param nameFile
     * @return
     * @throws IOException
     */
    @GetMapping("/image-gallery/{nameFile}")
    public ResponseEntity<byte[]> getImageGallery(
            @PathVariable("nameFile") String nameFile)
            throws IOException {

        File imageFile = new File(
                context.getContextPath() + pathPetGallery + nameFile);

        if (nameFile != null) {
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(Files.readAllBytes(imageFile.toPath()));
        }

        return null;
    }

    @GetMapping("/{petId}/vaccine")
    public ResponseEntity<List<VaccinationRecord>> getVaccineByPetId(@PathVariable Long petId) {

        List<VaccinationRecord> vaccine = petService.getVaccineByPetId(petId);

        return new ResponseEntity<>(vaccine, HttpStatus.OK);
    }

    /**
     * Get file for a vaccine
     * 
     * @param nameFile
     * @return
     * @throws IOException
     */
    @GetMapping(value = "/file-vaccine/{nameFile}", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> getVaccine(@PathVariable("nameFile") String nameFile) {

        File fileVaccine = new File(context.getContextPath() + pathPetVaccine + nameFile);

        if (fileVaccine.exists()) {
            try {
                byte[] fileContent = Files.readAllBytes(fileVaccine.toPath());
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_PDF);
                headers.setContentDisposition(ContentDisposition.builder("inline").filename(nameFile).build());
                return new ResponseEntity<>(fileContent, headers, HttpStatus.OK);
            } catch (IOException e) {
                e.getMessage();
            }
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Stores vaccines of a pet
     * 
     * @param files
     * @param petId
     * @return
     * @throws IOException
     */
    @PostMapping("/{petId}/vaccine/upload")
    public ResponseEntity<String> saveVaccine(
            @RequestParam("files") List<MultipartFile> files,
            @PathVariable("petId") Long petId)
            throws IOException {

        petService.saveVaccinationRecords(files, petId);

        return new ResponseEntity<>("Salvo com sucesso.",
                HttpStatus.OK);
    }

    /**
     * Get all pets without DTO trait
     */
    @Override
    @GetMapping("/")
    public ResponseEntity<List<Pet>> getAll() {
        List<Pet> pets = petService.getAll();
        return new ResponseEntity<>(pets, HttpStatus.OK);
    }

    /**
     * Get available options for selection and filters.
     * 
     * @return PetFilterOptions
     */
    @GetMapping("/options")
    public ResponseEntity<PetFilterOptions> getOptions() {

        List<EPetSex> sex = new ArrayList<>(
                EnumSet.allOf(EPetSex.class));
        List<Color> color = colorService.getAll();
        List<Race> race = raceService.getAll();
        List<Specie> specie = specieService.getAll();
        List<Size> size = sizeService.getAll();

        PetFilterOptions options = new PetFilterOptions(
                sex, specie, race, size, color);

        return new ResponseEntity<>(options, HttpStatus.OK);
    }

    @PostMapping("/filter")
    public ResponseEntity<List<Pet>> getAll(
            @RequestBody PetFilterParam params,
            Authentication authentication) {
        UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authentication.getPrincipal();
        List<Pet> pets = petService.getAll(params, userDetailsImpl.getId());
        return new ResponseEntity<>(pets, HttpStatus.OK);
    }

    /**
     * Filter pets by a list of various species, races, colors and sizes.
     * 
     * @param petFilterMultiParam
     * @return
     */
    @PostMapping("/filter/multiparam")
    public ResponseEntity<List<PetFeedDTO>> getPetFilterMultiParam(
            @RequestBody PetFilterMultiParam petFilterMultiParam,
            Authentication authentication) {
        UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authentication.getPrincipal();
        List<PetFeedDTO> pets = petService.getAllFilter(
                petFilterMultiParam, userDetailsImpl.getId());
        return new ResponseEntity<>(pets, HttpStatus.OK);
    }

    /**
     * Filter pets by a list of various species, races, colors and sizes for
     * Non-logged user profiles.
     * 
     * @param petFilterMultiParam
     * @return
     */
    @PostMapping("/filter/multiparam/non-logged")
    public ResponseEntity<List<PetFeedNonLoggedDTO>> getPetFilterMultiParamNonLogged(
            @RequestBody PetFilterMultiParam petFilterMultiParam) {
        List<PetFeedNonLoggedDTO> pets = petService.getNonLoggedFilter(petFilterMultiParam);
        return new ResponseEntity<>(pets, HttpStatus.OK);
    }

    /**
     * Get only one pet without DTO trait
     */
    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Pet> getById(@PathVariable("id") Long id) {
        Pet pet = petService.getById(id);
        return new ResponseEntity<>(pet, HttpStatus.OK);
    }

    /**
     * Get only one pet with DTO trait and logged user.
     * 
     * @param id
     * @param authentication
     * @return
     */
    @GetMapping("/{id}/logged")
    public ResponseEntity<PetFeedDTO> getByIdLogged(
            @PathVariable("id") Long id,
            Authentication authentication) {
        UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authentication.getPrincipal();

        PetFeedDTO pet = petService.getByIdLogged(id, userDetailsImpl.getId());
        return new ResponseEntity<>(pet, HttpStatus.OK);
    }

    /**
     * Get only one pet with DTO trait and non-logged user.
     * 
     * @param id
     * @return
     */
    @GetMapping("/{id}/non-logged")
    public ResponseEntity<PetFeedNonLoggedDTO> getByIdNonLogged(
            @PathVariable("id") Long id) {
        PetFeedNonLoggedDTO pet = petService.getByIdNonLogged(id);
        return new ResponseEntity<>(pet, HttpStatus.OK);
    }

    @GetMapping("/feed/lost")
    public ResponseEntity<List<PetRegisteredDTO>> getFeedLost() {
        try {
            List<PetRegisteredDTO> feedLost = petService.getFeedPetsLost();
            return new ResponseEntity<>(feedLost, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Search pets by name
     */
    @Override
    @RequestMapping(value = "search", method = RequestMethod.GET)
    public ResponseEntity<List<Pet>> getByAll(
            @RequestParam("term") String term) {
        List<Pet> pets = petService.getByAll(term);
        return new ResponseEntity<>(pets, HttpStatus.OK);
    }

    /**
     * Store a new pet.
     */
    @Override
    @PostMapping("/")
    public ResponseEntity<Pet> insert(@RequestBody Pet object) {
        Pet pet = petService.save(object);
        return new ResponseEntity<>(pet, HttpStatus.OK);
    }

    /**
     * Updates only one pet.
     */
    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Pet> update(
            @PathVariable("id") Long id,
            @RequestBody Pet object) {
        Pet pet = petService.save(object, id);
        return new ResponseEntity<>(pet, HttpStatus.OK);
    }

    /**
     * Deletes only one pet.
     */
    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(
            @PathVariable("id") Long id) {
        petService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
