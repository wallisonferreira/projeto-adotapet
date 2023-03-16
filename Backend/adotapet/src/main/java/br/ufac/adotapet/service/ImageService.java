package br.ufac.adotapet.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.ufac.adotapet.model.Image;
import br.ufac.adotapet.model.Pet;
import br.ufac.adotapet.model.User;
import br.ufac.adotapet.repository.ImageRepository;
import br.ufac.adotapet.repository.PetRepository;
import br.ufac.adotapet.repository.UserRepository;
import br.ufac.adotapet.traits.ImageTrait;
import br.ufac.adotapet.traits.ValidationTraits;

@Service
public class ImageService {

    @Autowired
    private ServletContext context;

    private static String pathPetProfileImages = "src/main/java/br/ufac/adotapet/storage/pets/";

    private static String pathUserProfileImages = "src/main/java/br/ufac/adotapet/storage/users/";

    private static String pathPetGallery = "src/main/java/br/ufac/adotapet/storage/pets-gallery/";

    private ImageRepository imageRepository;
    private PetRepository petRepository;
    private UserRepository userRepository;

    public ImageService(
            ImageRepository imageRepository,
            PetRepository petRepository,
            UserRepository userRepository) {
        this.imageRepository = imageRepository;
        this.petRepository = petRepository;
        this.userRepository = userRepository;
    }

    public Boolean isLink(String path) {
        List<String> strings = Arrays.asList("http", "https");
        for (String str : strings) {
            if (path.startsWith(str)) {
                return true;
            }
        }
        return false;
    }

    public void removesIfExists(String path, String nameFile) {
        Path oldPath = Paths.get(
                context.getContextPath() + path + nameFile);

        if (Files.exists(oldPath)) {
            try {
                Files.delete(oldPath);
            } catch (IOException e) {
                e.getStackTrace();
            }
        }
    }

    public void removesOldFile(String type, String nameFile) {

        if (type.equals("pet")) {
            String path = pathPetProfileImages;
            removesIfExists(path, nameFile);
        }

        if (type.equals("user")) {
            String path = pathUserProfileImages;
            removesIfExists(path, nameFile);
        }

        if (type.equals("pet-gallery")) {
            String path = pathPetGallery;
            removesIfExists(path, nameFile);
        }
    }

    public Pet saveImageForPet(
            Long petId,
            MultipartFile file) throws IOException {

        Pet pet = petRepository.findById(petId).orElseThrow();

        try {

            // generates new filename
            String newFileName = UUID.randomUUID().toString();

            StringBuilder partialPath = new StringBuilder();
            partialPath.append(newFileName);
            partialPath.append(".webp");

            // creates fullPath
            StringBuilder fullPath = new StringBuilder();
            fullPath.append(context.getContextPath());
            fullPath.append(pathPetProfileImages);
            fullPath.append(partialPath.toString());

            // Convert and save image in webp format
            try {
                ImageTrait.convertImageToWebpWithLossyCompression(
                        file,
                        pathPetProfileImages,
                        newFileName);

            } catch (Exception e) {
                e.getStackTrace();
            }

            String oldFile = pet.getProfilePicture();
            if (oldFile != null && !isLink(oldFile)) {
                removesOldFile("pet", oldFile);
            }

            pet.setProfilePicture(partialPath.toString());

            return petRepository.save(pet);

        } catch (Exception e) {
            throw new IllegalArgumentException(
                    "A imagem não pôde ser tratada. \n" + e.getMessage());
        }
    }

    public User saveImageForUser(
            Long userId,
            MultipartFile file) throws IOException {

        User user = userRepository.findById(userId).orElseThrow();

        // get image
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
        fullPath.append(pathUserProfileImages);
        fullPath.append(partialPath.toString());

        Path path = Paths.get(fullPath.toString());
        Files.write(path, bytes);

        String oldFile = user.getProfilePicture();
        if (oldFile != null && !isLink(oldFile)) {
            removesOldFile("user", oldFile);
        }

        user.setProfilePicture(partialPath.toString());

        return userRepository.save(user);
    }

    /** adds images for pet gallery */
    public Image saveImageForPetGallery(
            Long petId,
            MultipartFile file) throws IOException {

        Pet pet = petRepository.findById(petId)
                .orElseThrow();

        // instantiates a new image
        Image image = new Image();

        // generates new filename
        String newFileName = UUID.randomUUID().toString();

        StringBuilder partialPath = new StringBuilder();
        partialPath.append(newFileName);
        partialPath.append(".webp");

        // creates fullPath
        StringBuilder fullPath = new StringBuilder();
        fullPath.append(context.getContextPath());
        fullPath.append(pathPetGallery);
        fullPath.append(partialPath.toString());

        // Convert and save image in webp format
        try {
            ImageTrait.convertImageToWebpWithLossyCompression(
                    file,
                    pathPetGallery,
                    newFileName);

        } catch (Exception e) {
            e.getStackTrace();
        }

        image.setPath(partialPath.toString());
        image.setPet(pet);

        return imageRepository.save(image);
    }
}
