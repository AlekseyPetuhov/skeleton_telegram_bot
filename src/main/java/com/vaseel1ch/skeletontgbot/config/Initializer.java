package com.vaseel1ch.skeletontgbot.config;

import com.vaseel1ch.skeletontgbot.Bot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;

@Slf4j
@Configuration
public class Initializer {

    final BotConfig config;

    public Initializer(BotConfig config) {
        this.config = config;
    }

    @Bean
    public SetWebhook setWebhookInstance() {
        return SetWebhook.builder().url(config.getWebhook()).build();
    }

    @Bean
    public Bot springWebhookBot(SetWebhook setWebhook) {
        Bot bot = new Bot(setWebhook);

        bot.setBotPath(config.getWebhook());
        bot.setBotUsername(config.getBotName());
        bot.setBotToken(config.getToken());

        return bot;
    }
}
