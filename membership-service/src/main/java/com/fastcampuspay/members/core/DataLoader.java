package com.fastcampuspay.members.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class DataLoader implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(DataLoader.class);

    @Value("${spring.profiles.active}")
    private String activeProfile;

    @Override
    public void run(String... args) {
        logActiveProfile();
    }

    private void logActiveProfile() {
        logger.info(">>> Active Spring Profile: " + activeProfile);
    }
}