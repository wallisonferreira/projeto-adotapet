package br.ufac.adotapet.dto.reponses;

import br.ufac.adotapet.model.Color;
import br.ufac.adotapet.model.Image;
import br.ufac.adotapet.model.Race;
import br.ufac.adotapet.model.Size;
import br.ufac.adotapet.model.Specie;
import br.ufac.adotapet.model.User;
import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class PetRegisteredDTO {
    private Long id;
    private String profilePicture;
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
    private Boolean lost = null;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private List<Image> images;
}
