package br.ufac.adotapet.dto.reponses;

import br.ufac.adotapet.model.Adoption;

public class ResponseDataAdoption {

    private final Adoption adoption;
    private final String message;

    public ResponseDataAdoption(Adoption adoption, String message) {
        this.adoption = adoption;
        this.message = message;
    }

    public Adoption getAdoption() {
        return adoption;
    }

    public String getMessage() {
        return message;
    }
}
