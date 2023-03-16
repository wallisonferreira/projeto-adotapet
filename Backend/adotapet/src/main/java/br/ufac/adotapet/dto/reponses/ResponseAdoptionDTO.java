package br.ufac.adotapet.dto.reponses;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import br.ufac.adotapet.model.Answer;
import br.ufac.adotapet.model.Pet;
import br.ufac.adotapet.model.User;
import lombok.Data;

@Data
public class ResponseAdoptionDTO implements Serializable {

    private Long id;
    private User userOwner;
    private Pet petAdopted;
    private String reqCode;
    private String reqStatus;
    private LocalDate adoptionDate;
    private Boolean adoptionActive;
    private List<Answer> answers;
    private String reason;
}
