package com.vaseel1ch.skeletontgbot.config;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@PropertySource("bot.properties")
public class BotConfig {
    @Value("${bot.name}") String botName;
    @Value("${bot.token}") String token;
    @Value("${webhook}") String webhook;

}