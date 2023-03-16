package br.ufac.adotapet.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.ufac.adotapet.dto.requests.UserRegistrationDTO;
import br.ufac.adotapet.model.User;
import br.ufac.adotapet.security.services.UserDetailsImpl;
import br.ufac.adotapet.service.UserService;

@RestController
@RequestMapping("/config/user")
public class UserController implements IController<User> {

    @Autowired
    private ServletContext context;

    private static String pathUserProfileImages = "src/main/java/br/ufac/adotapet/storage/users/";

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Upload profile image for users
     * 
     * @param file
     * @param authentication
     * @return
     */
    @PostMapping("/image")
    public ResponseEntity<User> saveImage(@RequestParam("file") MultipartFile file, Authentication authentication) {

        UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authentication.getPrincipal();

        User user = userService.getById(userDetailsImpl.getId());

        try {
            if (!file.isEmpty()) {
                byte[] bytes = file.getBytes();
                Path path = Paths.get(
                        context.getContextPath() + pathUserProfileImages
                                + String.valueOf(userDetailsImpl.getId())
                                + file.getOriginalFilename());
                Files.write(path, bytes);

                user.setProfilePicture(String.valueOf(user.getId()) + file.getOriginalFilename());
                User updatedUser = userService.save(user);
                return new ResponseEntity<>(updatedUser, HttpStatus.CREATED);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/image/{image}")
    public ResponseEntity<byte[]> getImage(@PathVariable("image") String image)
            throws IOException {
        File imageFile = new File(context.getContextPath() + pathUserProfileImages + image);

        if (image != null) {
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(Files.readAllBytes(imageFile.toPath()));
        }

        return null;
    }

    @Override
    @GetMapping("/")
    public ResponseEntity<List<User>> getAll() {
        List<User> users = userService.getAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable("id") Long id) {
        User user = userService.getById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "searchRole", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getByRole(@RequestParam("term") String term) {
        List<User> users = userService.getByRole(term);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @Override
    @RequestMapping(value = "searchUser", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getByAll(@RequestParam("term") String term) {
        List<User> users = userService.getByAll(term);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody UserRegistrationDTO object) {
        User user = userService.registerUser(object);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @Override
    @PostMapping("/")
    public ResponseEntity<User> insert(@RequestBody User object) {
        User user = userService.save(object);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable("id") Long id, @RequestBody User object) {
        User user = userService.save(object, id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
