package com.currency.telegram.NpbService;

public class NpbArrayOfExchangeRatesTable {
    private NpbExchangeRatesTable npbExchangeRatesTable;

    public NpbArrayOfExchangeRatesTable() {
    }

    public NpbArrayOfExchangeRatesTable(NpbExchangeRatesTable npbExchangeRatesTable) {
        this.npbExchangeRatesTable = npbExchangeRatesTable;
    }

    public NpbExchangeRatesTable getNpbExchangeRatesTable() {
        return npbExchangeRatesTable;
    }

    public void setNpbExchangeRatesTable(NpbExchangeRatesTable npbExchangeRatesTable) {
        this.npbExchangeRatesTable = npbExchangeRatesTable;
    }
}
