package br.ufac.adotapet.dto.reponses;

import br.ufac.adotapet.model.Color;
import br.ufac.adotapet.model.Race;
import br.ufac.adotapet.model.Size;
import br.ufac.adotapet.model.Specie;
import br.ufac.adotapet.model.User;
import lombok.Data;

@Data
public class ResponsePetRegisterDTO {

    private Long id;
    private String name;
    private String tag;
    private String description;
    private Integer age;
    private Boolean hasOwner = true;
    // private Boolean lost = false;
    // private Boolean active = true;
    private User owner;
    private Color color;
    private Size size;
    private Race race;
    private Specie specie;
    private String sex;
    private Double weight = null;
    private Boolean neutered = null;
    private Boolean dewormed = null;
}
