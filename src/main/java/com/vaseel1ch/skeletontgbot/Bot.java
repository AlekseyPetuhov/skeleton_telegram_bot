package com.vaseel1ch.skeletontgbot;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.starter.SpringWebhookBot;


import java.io.IOException;

@Slf4j
@Getter
@Setter
public class Bot extends SpringWebhookBot {

    String botPath;
    String botUsername;
    String botToken;

    public Bot(SetWebhook setWebhook) {
        super(setWebhook);
    }


    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        try {
            return handleUpdate(update);
        } catch (IllegalArgumentException e) {
            return new SendMessage(update.getMessage().getChatId().toString(), "Error");
        } catch (Exception e) {
            return new SendMessage(update.getMessage().getChatId().toString(), "Error");
        }
    }

    private BotApiMethod<?> handleUpdate(Update update) throws IOException {
        Message message = update.getMessage();
        if (message != null) {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(update.getMessage().getChatId());
            sendMessage.setText("Hello");
            return sendMessage;
        }
        return null;
    }
}