package com.flavio.spring_mc.entities.models;

import jakarta.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity()
public class Estado implements Serializable {
    @Serial
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "estado")
    private List<Cidade> cidades = new ArrayList<>();

    public Estado() {
    }

    public Estado(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Estado estado)) return false;

        if (getId() != null ? !getId().equals(estado.getId()) : estado.getId() != null) return false;
        if (getName() != null ? !getName().equals(estado.getName()) : estado.getName() != null) return false;
        return getCidades() != null ? getCidades().equals(estado.getCidades()) : estado.getCidades() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getCidades() != null ? getCidades().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cidades=" + cidades +
                '}';
    }
}
