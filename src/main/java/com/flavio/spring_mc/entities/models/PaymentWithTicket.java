package com.flavio.spring_mc.entities.models;

import com.flavio.spring_mc.entities.enums.StatusPayment;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serial;
import java.time.Instant;
//import java.time.LocalDate;

@Entity
@Table(name = "tb_payment_ticket")
public class PaymentWithTicket extends Payment{
    @Serial
    private static final long serialVersionUID=1L;

    private Instant expirationDate;
    private Instant datePayment;

    public PaymentWithTicket() {
    }

    public PaymentWithTicket(Integer id, StatusPayment statusPayment, Order order, Instant expirationDate, Instant datePayment) {
        super(id, statusPayment, order);
        this.expirationDate = expirationDate;
        this.datePayment = datePayment;
    }

    public Instant getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Instant expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Instant getDatePayment() {
        return datePayment;
    }

    public void setDatePayment(Instant datePayment) {
        this.datePayment = datePayment;
    }
}
