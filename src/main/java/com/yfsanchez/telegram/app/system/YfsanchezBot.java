package com.yfsanchez.telegram.app.system;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class YfsanchezBot extends TelegramLongPollingBot{

	public void onUpdateReceived(Update update) {
		// TODO Auto-generated method stub
		System.out.println(update.getMessage().getText());
		System.out.println(update.getMessage().getChatId());
		
		// We check if the update has a message and the message has text
	    if (update.hasMessage() && update.getMessage().hasText()) {
	    	
	    	SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
	    	message.setChatId(update.getMessage().getChatId().toString());

	    	String messageText = update.getMessage().getText();
	    	
	    	if (messageText.equals("inicio")) {
	    		
	    		message.setText("Hola, eres mi primer cliente.");
	    		
			} else {
				
				message.setText(update.getMessage().getText());
				
			}
	        
	        try {
	            execute(message); // Call method to send the message
	        } catch (TelegramApiException e) {
	            e.printStackTrace();
	        }
	    }
		
	}

	public String getBotUsername() {
		// TODO Auto-generated method stub
		return "ManagerMLBBot";
	}

	@Override
	public String getBotToken() {
		// TODO Auto-generated method stub
		return "1784474668:AAG6DffL1G2VBkzzMH1X74ZEBQGsii9i8-Y";
	}

}
