package br.ufac.adotapet.dto.requests;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class RequestAdoptionDTO implements Serializable {

    List<QuestionAnswerDTO> questionAnswer;

}
