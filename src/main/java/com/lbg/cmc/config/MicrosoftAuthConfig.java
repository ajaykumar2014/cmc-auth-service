package com.lbg.cmc.config;

import feign.codec.Encoder;
import feign.form.FormEncoder;
import org.springframework.context.annotation.Bean;

public class MicrosoftAuthConfig {

    @Bean
    public Encoder encoder() {
        return new FormEncoder();
    }
}
