package br.ufac.adotapet.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import br.ufac.adotapet.model.Auditable.Auditable;
import lombok.Data;
import lombok.EqualsAndHashCode;

// @JsonIgnoreProperties({ "user", "pet" })
@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "user_liked_pet")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Like extends Auditable implements Serializable {

    public Like() {
    }

    public Like(User user, Pet pet) {
        this.user = user;
        this.pet = pet;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    private UUID id;

    // @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;
}
