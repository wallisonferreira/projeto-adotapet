package br.ufac.adotapet.dto.requests;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import br.ufac.adotapet.model.City;
import br.ufac.adotapet.model.ESex;
import lombok.Data;

@Data
public class UserRegistrationDTO implements Serializable {

    private Long id;
    private String email;
    private String password;
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
    private Integer age;
    private ESex sex;
    private String localTitle;
    private String fullAddress;
    private String description;
    private String cep;
    private Double latitude;
    private Double longitude;
    private City city;
}
