package com.flavio.spring_mc.entities.models;

import com.flavio.spring_mc.entities.enums.StatusPayment;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "tb_payment")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Payment implements Serializable {
    @Serial
    private static final long serialVersionUID=1L;

    @Id
    private Integer id;
    private Integer statusPayment;

    @OneToOne
    @MapsId //Combinando o ID
    @JoinColumn(name = "order_id")
    private Order order;

    public Payment() {
    }

    public Payment(Integer id, StatusPayment statusPayment, Order order) {
        this.id = id;
        this.statusPayment = statusPayment.getCod();
        this.order = order;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public StatusPayment getStatusPayment() {
        return StatusPayment.toEnum(statusPayment);
    }

    public void setStatusPayment(StatusPayment statusPayment) {
        this.statusPayment = statusPayment.getCod();
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment payment)) return false;

        return getId() != null ? getId().equals(payment.getId()) : payment.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}
