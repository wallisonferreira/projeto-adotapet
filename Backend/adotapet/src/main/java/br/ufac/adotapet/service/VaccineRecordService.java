package br.ufac.adotapet.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.ufac.adotapet.model.Pet;
import br.ufac.adotapet.model.VaccinationRecord;
import br.ufac.adotapet.repository.PetRepository;
import br.ufac.adotapet.repository.VaccinationRecordRepository;
import br.ufac.adotapet.traits.ValidationTraits;

@Service
public class VaccineRecordService {

    @Autowired
    private ServletContext context;

    private static String pathPetVaccines = "src/main/java/br/ufac/adotapet/storage/pets-vaccine/";

    VaccinationRecordRepository vaccineRepository;
    PetRepository petRepository;

    public VaccineRecordService(
            PetRepository petRepository,
            VaccinationRecordRepository vaccineRepository) {
        this.vaccineRepository = vaccineRepository;
        this.petRepository = petRepository;
    }

    /** adds vaccines for pet gallery */
    public VaccinationRecord saveVaccineForPet(
            Long petId,
            MultipartFile file) throws IOException {

        Pet pet = petRepository.findById(petId)
                .orElse(null);

        // instantiates a new image
        VaccinationRecord vaccine = new VaccinationRecord();

        // get vaccine
        byte[] bytes = file.getBytes();

        // get extension
        String extension = ValidationTraits.getFileExtension(file);

        // generates new filename
        String newFileName = UUID.randomUUID().toString();

        StringBuilder partialPath = new StringBuilder();
        partialPath.append(newFileName);
        partialPath.append("." + extension);

        // creates fullPath
        StringBuilder fullPath = new StringBuilder();
        fullPath.append(context.getContextPath());
        fullPath.append(pathPetVaccines);
        fullPath.append(partialPath.toString());

        Path path = Paths.get(fullPath.toString());
        Files.write(path, bytes);

        vaccine.setPath(partialPath.toString());
        vaccine.setPet(pet);

        VaccinationRecord vaccineSaved = vaccineRepository.save(vaccine);

        return vaccineSaved;
    }

}
