package br.ufac.adotapet.dto.reponses;

import br.ufac.adotapet.model.Color;
import br.ufac.adotapet.model.Race;
import br.ufac.adotapet.model.Size;
import br.ufac.adotapet.model.Specie;
import br.ufac.adotapet.model.User;
import lombok.Data;

@Data
public class PetWithOwnerDTO {
    private Long id;
    private String name;
    private String tag;
    private String description;
    private Integer age;
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
