package com.yfsanchez.telegram.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import com.yfsanchez.telegram.app.system.YfsanchezBot;

@SpringBootApplication
public class BotTelegramJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BotTelegramJavaApplication.class, args);
		try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new YfsanchezBot());
            
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
	}

}
