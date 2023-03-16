package br.ufac.adotapet.dto.requests;

import br.ufac.adotapet.model.Color;
import br.ufac.adotapet.model.Race;
import br.ufac.adotapet.model.Size;
import br.ufac.adotapet.model.Specie;
import lombok.Data;

@Data
public class RequestPetRegisterDTO {

    private String name;
    private String tag;
    private String description;
    private Integer age;
    private Boolean lost = false;
    private Color color;
    private Size size;
    private Race race;
    private Specie specie;
    private String sex;
    private Double weight = null;
    private Boolean neutered = null;
    private Boolean dewormed = null;

    // private Boolean hasOwner = false;
    // private Boolean active = true;
    // private User user;
}
