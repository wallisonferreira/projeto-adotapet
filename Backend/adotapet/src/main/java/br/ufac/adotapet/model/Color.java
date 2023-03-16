package br.ufac.adotapet.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

@Entity
public class Color implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    @Column(name = "color_name", nullable = false)
    private String colorName;

    @Column(name = "color_hexadecimal")
    private String colorHexadecimal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getColorHexadecimal() {
        return colorHexadecimal;
    }

    public void setColorHexadecimal(String colorHexadecimal) {
        this.colorHexadecimal = colorHexadecimal;
    }

    @PrePersist
    public void setDefaultId() {
        if (id == null || id <= 0L) {
            id = 1L;
        }
    }
}
