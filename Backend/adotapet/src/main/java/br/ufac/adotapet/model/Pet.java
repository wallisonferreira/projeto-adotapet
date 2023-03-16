package br.ufac.adotapet.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.ufac.adotapet.model.Auditable.Auditable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Pet extends Auditable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    private String name;
    private String tag;
    private String qrCodePath;

    @Column(columnDefinition = "mediumtext")
    private String description;

    private Integer age;

    @Column(nullable = false)
    private Boolean hasOwner = false;

    @Column(name = "is_lost", nullable = false)
    private Boolean lost = false;

    @Column(name = "is_active", nullable = false)
    private Boolean active = true;

    @Column(name = "profile_picture", columnDefinition = "mediumtext")
    private String profilePicture;

    @Column(name = "deleted_at")
    private LocalDate deletedAt;

    @ManyToOne(optional = true)
    @JoinColumn(name = "user_id_creator")
    private User user;

    @ManyToOne(optional = true)
    private Color color;

    @ManyToOne(optional = true)
    private Size size;

    @ManyToOne(optional = true)
    private Race race;

    @ManyToOne(optional = true)
    private Specie specie;

    @Enumerated(EnumType.STRING)
    private EPetSex sex;

    private Double weight;

    // pet has undergone sterilization
    private Boolean neutered = null;

    // pet has been treated for worms
    private Boolean dewormed = null;

    @JsonManagedReference
    @OneToMany(mappedBy = "pet")
    private List<Image> images;

    // @JsonBackReference
    // @OneToMany(mappedBy = "pet")
    // private List<Like> likes;

    @JsonIgnoreProperties("usersWhoLiked")
    @ManyToMany
    @JoinTable(name = "user_liked_pet", joinColumns = {
            @JoinColumn(name = "pet_id") }, inverseJoinColumns = {
                    @JoinColumn(name = "user_id") })
    private Set<User> usersWhoLiked = new HashSet<>();

    public int getLikesCount() {
        return usersWhoLiked.size();
    }
}
