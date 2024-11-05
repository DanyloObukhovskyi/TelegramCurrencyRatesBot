package com.currency.telegram;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.interfaces.LongPollingUpdateConsumer;
import org.telegram.telegrambots.longpolling.starter.SpringLongPollingBot;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

import com.currency.telegram.Repository.ExchangeRatesHistory;
import com.currency.telegram.Repository.ExchangeRatesHistoryRepository;

import java.time.LocalDate;

@Component
public class TelegramBot implements SpringLongPollingBot, LongPollingSingleThreadUpdateConsumer {

    private final String telegramToken;

    private final TelegramClient telegramClient;

    @Autowired
    private ExchangeRatesHistoryRepository exchangeRatesHistoryRepository;

    public TelegramBot(@Value("${telegram.token}") String telegramToken) {
        this.telegramToken = telegramToken;
        this.telegramClient = new OkHttpTelegramClient(getBotToken());
    }

    @Override
    public String getBotToken() {
        return this.telegramToken;
    }

    @Override
    public LongPollingUpdateConsumer getUpdatesConsumer() {
        return this;
    }

    @Override
    public void consume(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()
                && update.getMessage().getText().equals("/getTodayRates")) {
            Iterable<ExchangeRatesHistory> exchangerates = exchangeRatesHistoryRepository.findByDate(LocalDate.now());
            StringBuilder message_text = new StringBuilder();
            for (ExchangeRatesHistory exchangeRate : exchangerates) {
                message_text.append("Currency : ");
                message_text.append(exchangeRate.getCurrency());
                message_text.append(" Bid : ");
                message_text.append(exchangeRate.getBid());
                message_text.append(" Ask : ");
                message_text.append(exchangeRate.getAsk());
                message_text.append("\n");
            }
            long chat_id = update.getMessage().getChatId();

            SendMessage message = SendMessage
                    .builder()
                    .chatId(chat_id)
                    .text(message_text.toString())
                    .build();
            try {
                telegramClient.execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}
