package com.currency.telegram.repository;

import org.springframework.data.repository.CrudRepository;

import com.currency.telegram.entity.ExchangeRatesHistory;

import java.time.LocalDate;

public interface ExchangeRatesHistoryRepository extends CrudRepository<ExchangeRatesHistory, Integer> {
    Iterable<ExchangeRatesHistory> findByDate(LocalDate date);
}
