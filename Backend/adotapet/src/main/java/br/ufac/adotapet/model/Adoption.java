package br.ufac.adotapet.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.ufac.adotapet.model.Auditable.Auditable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "user_requests_adoption")
public class Adoption extends Auditable implements Serializable {

    public Adoption() {
    }

    public Adoption(User userOwner, Pet petAdopted) {
        this.userOwner = userOwner;
        this.petAdopted = petAdopted;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id_owner", referencedColumnName = "id")
    private User userOwner;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "pet_id", referencedColumnName = "id")
    private Pet petAdopted;

    private String reqCode;

    private String reqStatus;

    private LocalDate adoptionDate;

    private Boolean adoptionActive = false;

    private String reason;

    @JsonManagedReference
    @OneToMany(mappedBy = "adoption", fetch = FetchType.LAZY)
    private List<Answer> answers = new ArrayList<>();

    public void addAnswer(Answer answer) {
        answers.add(answer);
        answer.setAdoption(this);
    }

    public void removeAnswer(Answer answer) {
        answers.remove(answer);
        answer.setAdoption(null);
    }
}
