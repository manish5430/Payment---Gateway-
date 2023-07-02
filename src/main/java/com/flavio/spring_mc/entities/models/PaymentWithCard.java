package com.flavio.spring_mc.entities.models;

import com.flavio.spring_mc.entities.enums.StatusPayment;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serial;

@Entity
@Table(name = "tb_payment_card")
public class PaymentWithCard extends Payment{
    @Serial
    private static final long serialVersionUID=1L;

    private Integer numberOfInstallments;

    public PaymentWithCard() {
    }

    public PaymentWithCard(Integer id, StatusPayment statusPayment, Order order, Integer numberOfInstallments) {
        super(id, statusPayment, order);
        this.numberOfInstallments = numberOfInstallments;
    }

    public Integer getNumberOfInstallments() {
        return numberOfInstallments;
    }

    public void setNumberOfInstallments(Integer numberOfInstallments) {
        this.numberOfInstallments = numberOfInstallments;
    }


}
