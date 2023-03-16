package br.ufac.adotapet.dto.requests;

import java.io.Serializable;

import br.ufac.adotapet.model.Question;
import lombok.Data;

@Data
public class QuestionAnswerDTO implements Serializable {

    private Question question;
    private String text;
}
