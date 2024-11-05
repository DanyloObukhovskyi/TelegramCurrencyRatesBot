package com.currency.telegram.Repository;

import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;

public interface ExchangeRatesHistoryRepository extends CrudRepository<ExchangeRatesHistory, Integer> {
    Iterable<ExchangeRatesHistory> findByDate(LocalDate date);
}
