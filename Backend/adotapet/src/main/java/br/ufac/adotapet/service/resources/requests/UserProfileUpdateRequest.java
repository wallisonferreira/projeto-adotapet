package br.ufac.adotapet.service.resources.requests;

import java.sql.Date;

import br.ufac.adotapet.model.ESex;
import lombok.Data;

@Data
public class UserProfileUpdateRequest {
    private String name;

    private String cpf;

    private String phone;

    private Date birthDate;

    private String job;

    private String income;

    private String typeResidence;

    private String freeTime;

    private Boolean childAtHome;

    private Boolean petAtHome;

    private Integer age;

    private ESex sex;
}
