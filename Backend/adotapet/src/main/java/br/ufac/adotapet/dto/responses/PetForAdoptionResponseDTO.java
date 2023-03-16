package br.ufac.adotapet.dto.responses;

import java.io.Serializable;
import java.time.LocalDate;

import br.ufac.adotapet.model.Color;
import br.ufac.adotapet.model.Race;
import br.ufac.adotapet.model.Size;
import br.ufac.adotapet.model.Specie;
import br.ufac.adotapet.model.User;
import lombok.Data;

@Data
public class PetForAdoptionResponseDTO implements Serializable {
    private Long id;
    private String name;
    private String tag;
    private String description;
    private Integer age;
    private Boolean hasOwner = false;
    private Boolean lost = false;
    private Boolean active = true;
    private String profilePicture;
    private User ong;
    private Color color;
    private Size size;
    private Race race;
    private Specie specie;
    private String sex;
    private Double weight;
    private Boolean neutered = null;
    private Boolean dewormed = null;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private LocalDate deletedAt;
}
