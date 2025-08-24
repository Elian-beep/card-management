package com.cardmng.crud.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private BigDecimal limitCard;
    @OneToMany(mappedBy = "card")
    private List<Management> managements = new ArrayList<>();
    public Card() {
    }

    public Card(String name, BigDecimal limitCard) {
        this.name = name;
        this.limitCard = limitCard;
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

    public BigDecimal getLimitCard() {
        return limitCard;
    }

    public void setLimitCard(BigDecimal limitCard) {
        this.limitCard = limitCard;
    }

    public List<Management> getManagements() {
        return managements;
    }

    public void setManagements(List<Management> managements) {
        this.managements = managements;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(id, card.id) && Objects.equals(name, card.name) && Objects.equals(limitCard, card.limitCard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, limitCard);
    }
}
