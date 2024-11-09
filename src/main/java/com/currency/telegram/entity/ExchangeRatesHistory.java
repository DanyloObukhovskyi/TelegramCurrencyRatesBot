package com.currency.telegram.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "exchange_history")
public class ExchangeRatesHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "currency", length = 255, nullable = false, unique = false)
    private String currency;

    @Column(name = "code", length = 255, nullable = false, unique = false)
    private String code;

    @Column(name = "bid", nullable = false, unique = false)
    private Double bid;

    @Column(name = "ask", nullable = false, unique = false)
    private Double ask;

    @Column(name = "date", nullable = false, unique = false)
    private LocalDate date;

    public ExchangeRatesHistory() {
    }

    public ExchangeRatesHistory(String currency, String code, Double bid, Double ask, LocalDate date) {
        this.currency = currency;
        this.code = code;
        this.bid = bid;
        this.ask = ask;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getBid() {
        return bid;
    }

    public void setBid(Double bid) {
        this.bid = bid;
    }

    public Double getAsk() {
        return ask;
    }

    public void setAsk(Double ask) {
        this.ask = ask;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}
