package br.ufac.adotapet.traits;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.FileImageOutputStream;

import org.springframework.web.multipart.MultipartFile;

import com.luciad.imageio.webp.WebPWriteParam;

public class ImageTrait {

        public static void convertImageToWebpWithLossyCompression(
                        MultipartFile file,
                        String path,
                        String filename)
                        throws Exception {

                BufferedImage image = ImageIO.read(file.getInputStream());

                ImageWriter writer = ImageIO.getImageWritersByMIMEType(
                                "image/webp").next();

                WebPWriteParam writeParam = new WebPWriteParam(writer.getLocale());
                // Notify encoder to consider WebPWriteParams
                writeParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
                // Set lossy compression
                writeParam.setCompressionType(
                                writeParam.getCompressionTypes()[WebPWriteParam.LOSSY_COMPRESSION]);
                // Set 80% quality. Allowed values are between 0 and 1
                writeParam.setCompressionQuality(0.8f);

                // Save the image
                writer.setOutput(
                                new FileImageOutputStream(new File(path + filename + ".webp")));
                writer.write(null, new IIOImage(
                                image,
                                null, null), writeParam);
        }
}
