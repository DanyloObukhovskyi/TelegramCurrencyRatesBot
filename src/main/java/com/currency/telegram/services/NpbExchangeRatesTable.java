package com.currency.telegram.services;

import java.util.List;

public class NpbExchangeRatesTable {
    private String table;

    private String no;

    private String tradingDate;

    private String effectiveDate;

    private List<NpbRate> rates;

    public NpbExchangeRatesTable() {
    }

    public NpbExchangeRatesTable(String table, String no, String tradingDate, String effectiveDate,
            List<NpbRate> rates) {
        this.table = table;
        this.no = no;
        this.tradingDate = tradingDate;
        this.effectiveDate = effectiveDate;
        this.rates = rates;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getTradingDate() {
        return tradingDate;
    }

    public void setTradingDate(String tradingDate) {
        this.tradingDate = tradingDate;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public List<NpbRate> getRates() {
        return rates;
    }

    public void setRates(List<NpbRate> rates) {
        this.rates = rates;
    }
}
