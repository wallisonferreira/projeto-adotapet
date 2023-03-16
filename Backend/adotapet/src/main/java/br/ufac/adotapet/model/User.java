package br.ufac.adotapet.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import br.ufac.adotapet.model.Auditable.Auditable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class User extends Auditable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    @JsonProperty(access = Access.WRITE_ONLY)
    private String password;

    // -------- questions to activate user --------

    private String name;

    private String cpf;

    private String phone;

    private LocalDate birthDate;

    private String job;

    private BigDecimal income;

    private String typeResidence;

    private Integer freeTime;

    private Boolean childAtHome;

    private Boolean petAtHome;

    // -------- end questions to activate user --------

    private Integer age;

    @Enumerated(EnumType.STRING)
    private ESex sex;

    @Column(name = "is_verified", nullable = false)
    private boolean verified = false;

    @Column(name = "is_active", nullable = false)
    private boolean active = true;

    @Column(name = "profile_picture", columnDefinition = "mediumtext")
    private String profilePicture;

    @Column(name = "deleted_at")
    private LocalDate deletedAt;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ERole role = ERole.ROLE_USER;

    // Address

    private String localTitle;

    private String fullAddress;

    @Column(columnDefinition = "mediumtext")
    private String description;

    @Column(columnDefinition = "varchar(10)")
    private String cep;

    @Column(columnDefinition = "float(10,6)")
    private Double latitude;

    @Column(columnDefinition = "float(10,6)")
    private Double longitude;

    @ManyToOne(optional = true)
    private City city;

    public User() {

    }

    public User(String username, String email, String password) {
        this.name = username;
        this.email = email;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        setPassword(password, true);
    }

    public void setPassword(String password, boolean encrypt) {
        if (password != null && encrypt) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            password = passwordEncoder.encode(password);
        }
        this.password = password;
    }
}
