package com.currency.telegram.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.currency.telegram.entity.ExchangeRatesHistory;
import com.currency.telegram.repository.ExchangeRatesHistoryRepository;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

@Service
public class NpbGetTodayRatesCron {

    private final NpbService npbService;

    private final ExchangeRatesHistoryRepository exchangeRatesHistoryRepository;

    @Autowired
    public NpbGetTodayRatesCron(ExchangeRatesHistoryRepository exchangeRatesHistoryRepository, NpbService npbService) {
        this.exchangeRatesHistoryRepository = exchangeRatesHistoryRepository;
        this.npbService = npbService;
    }

    @Scheduled(cron = "0 0 8 * * *")
    public void execute() {
        NpbExchangeRatesTable npbExchangeRatesTable = npbService.getRates();
        List<NpbRate> rates = npbExchangeRatesTable.getRates();
        List<ExchangeRatesHistory> exchangeRatesHistoryObjects = new ArrayList<>();
        for (NpbRate npbRate : rates) {
            ExchangeRatesHistory exchangeRatesHistoryToSave = new ExchangeRatesHistory();
            exchangeRatesHistoryToSave.setAsk(npbRate.getAsk());
            exchangeRatesHistoryToSave.setBid(npbRate.getBid());
            exchangeRatesHistoryToSave.setCode(npbRate.getCode());
            exchangeRatesHistoryToSave.setCurrency(npbRate.getCurrency());
            exchangeRatesHistoryToSave.setDate(LocalDate.now());
            exchangeRatesHistoryObjects.add(exchangeRatesHistoryToSave);
        }

        exchangeRatesHistoryRepository.saveAll(exchangeRatesHistoryObjects);
    }
}
