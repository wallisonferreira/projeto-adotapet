package br.ufac.adotapet.dto.requests;

import java.io.Serializable;

import br.ufac.adotapet.model.Color;
import br.ufac.adotapet.model.Race;
import br.ufac.adotapet.model.Size;
import br.ufac.adotapet.model.Specie;
import br.ufac.adotapet.model.User;
import lombok.Data;

@Data
public class PetForAdoptionRequestDTO implements Serializable {
    private String name;
    private String tag;
    private String description;
    private Integer age;
    private Boolean hasOwner;
    private Boolean lost;
    private Boolean active;
    private String profilePicture;
    private User ong;
    private Color color;
    private Size size;
    private Race race;
    private Specie specie;
    private String sex;
    private Double weight;
    private Boolean neutered;
    private Boolean dewormed;
}
