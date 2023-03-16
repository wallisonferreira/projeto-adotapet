package br.ufac.adotapet.dto.reponses;

import java.io.Serializable;
import java.util.List;

import br.ufac.adotapet.model.Image;

public class ResponseDataImage implements Serializable {
    private final List<Image> images;
    private final String message;

    public ResponseDataImage(List<Image> images, String message) {
        this.images = images;
        this.message = message;
    }

    public List<Image> getImages() {
        return images;
    }

    public String getMessage() {
        return message;
    }
}
