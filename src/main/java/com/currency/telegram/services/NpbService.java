package com.currency.telegram.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
public class NpbService {

    private final RestTemplate restTemplate = new RestTemplate();

    private final String serviceUrl = "https://api.nbp.pl/api/exchangerates/tables/C";

    public NpbExchangeRatesTable getRates() {
        NpbExchangeRatesTable[] npbExchangeRatesTables = restTemplate.getForObject(
                serviceUrl, NpbExchangeRatesTable[].class);
        return Objects.requireNonNull(npbExchangeRatesTables)[0];
    }
}
