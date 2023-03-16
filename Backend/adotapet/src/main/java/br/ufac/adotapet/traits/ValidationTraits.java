package br.ufac.adotapet.traits;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.web.multipart.MultipartFile;

public class ValidationTraits {

    public static boolean isImageFile(MultipartFile file) {
        try {
            BufferedImage image = ImageIO.read(file.getInputStream());
            if (image == null) {
                return false;
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static String getFileExtension(MultipartFile file) {
        String originalFileName = file.getOriginalFilename();
        int dotIndex = originalFileName.lastIndexOf(".");
        return (dotIndex == -1) ? "" : originalFileName.substring(dotIndex + 1);
    }
}
