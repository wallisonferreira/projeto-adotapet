package br.ufac.adotapet.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

@Entity
public class Size implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    @Column(name = "size_name", nullable = false)
    private String sizeName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getsizeName() {
        return sizeName;
    }

    public void setsizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    @PrePersist
    public void setDefaultId() {
        if (id == null || id <= 0L) {
            id = 1L;
        }
    }
}
