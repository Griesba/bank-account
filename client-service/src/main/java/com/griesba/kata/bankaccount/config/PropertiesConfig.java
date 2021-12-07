package com.griesba.kata.bankaccount.config;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "griesba.kata.bankaccount")
public class PropertiesConfig {
    private boolean useCQRS;

    public boolean isUseCQRS() {
        return useCQRS;
    }
}
