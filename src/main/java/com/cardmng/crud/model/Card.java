package com.cardmng.crud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Double limitCard;
    private Double invoice;

    public Card() {
    }

    public Card(String name, Double limitCard, Double invoice) {
        this.name = name;
        this.limitCard = limitCard;
        this.invoice = invoice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLimitCard() {
        return limitCard;
    }

    public void setLimitCard(Double limitCard) {
        this.limitCard = limitCard;
    }

    public Double getInvoice() {
        return invoice;
    }

    public void setInvoice(Double invoice) {
        this.invoice = invoice;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(id, card.id) && Objects.equals(name, card.name) && Objects.equals(limitCard, card.limitCard) && Objects.equals(invoice, card.invoice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, limitCard, invoice);
    }
}
