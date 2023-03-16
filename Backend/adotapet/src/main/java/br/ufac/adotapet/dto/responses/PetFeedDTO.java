package br.ufac.adotapet.dto.responses;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import br.ufac.adotapet.model.Color;
import br.ufac.adotapet.model.EPetSex;
import br.ufac.adotapet.model.Image;
import br.ufac.adotapet.model.Race;
import br.ufac.adotapet.model.Size;
import br.ufac.adotapet.model.Specie;
import br.ufac.adotapet.model.User;
import lombok.Data;

@Data
public class PetFeedDTO implements Serializable {

    private Long id;
    private String name;
    private String tag;
    private String description;
    private Integer age;
    private Boolean hasOwner;
    private Boolean lost;
    private Boolean active;
    private String profilePicture;
    private LocalDate deletedAt;
    private User ong;
    private Color color;
    private Size size;
    private Race race;
    private Specie specie;
    private EPetSex sex;
    private Double weight;
    private Boolean neutered;
    private Boolean dewormed;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private Boolean isLiked;
    private Set<User> usersWhoLiked;
    private int countLikes;
    private List<Image> images;
}
