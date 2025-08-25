package com.cardmng.crud.model;

import com.cardmng.crud.model.enums.ManagementStatus;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Management {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private Integer month;
    @Column(nullable = false)
    private Integer year;
    @Column(nullable = false)
    private LocalDate closingDate;
    @Column(nullable = false)
    private LocalDate expirationDate;
    @Column(nullable = false)
    private BigDecimal totalAmount;
    @Column(nullable = false)
    private BigDecimal amountPaid;
    @Column(nullable = false)
    private ManagementStatus managementStatus;
    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public LocalDate getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(LocalDate closingDate) {
        this.closingDate = closingDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(BigDecimal amountPaid) {
        this.amountPaid = amountPaid;
    }

    public ManagementStatus getManagementStatus() {
        return managementStatus;
    }

    public void setManagementStatus(ManagementStatus managementStatus) {
        this.managementStatus = managementStatus;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Management that = (Management) o;
        return Objects.equals(id, that.id) && Objects.equals(month, that.month) && Objects.equals(year, that.year) && Objects.equals(closingDate, that.closingDate) && Objects.equals(expirationDate, that.expirationDate) && Objects.equals(totalAmount, that.totalAmount) && Objects.equals(amountPaid, that.amountPaid) && managementStatus == that.managementStatus && Objects.equals(card, that.card);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, month, year, closingDate, expirationDate, totalAmount, amountPaid, managementStatus, card);
    }
}
