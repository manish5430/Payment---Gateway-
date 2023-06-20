package com.flavio.spring_mc.entities.models;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
public class Cidade implements Serializable{
    @Serial
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    private Estado estado;

    public Cidade() {
    }

    public Cidade(Integer id, String name, Estado estado) {
        this.id = id;
        this.name = name;
        this.estado = estado;
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cidade cidade)) return false;

        if (getId() != null ? !getId().equals(cidade.getId()) : cidade.getId() != null) return false;
        if (getName() != null ? !getName().equals(cidade.getName()) : cidade.getName() != null) return false;
        return getEstado() != null ? getEstado().equals(cidade.getEstado()) : cidade.getEstado() == null;
    }
    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getEstado() != null ? getEstado().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Cidade{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", estado=" + estado +
                '}';
    }

}
