package com.lbg.cmc.config;

import com.lbg.cmc.services.MicrosoftTokenService;
import feign.RequestInterceptor;
import feign.form.spring.SpringFormEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class ConfluentConfig {

    private static final String AUTHORIZATION_HEADER="Authorization";
    private static final String CONFLUENT_IDENTITY_POOL="Confluent-Identity-Pool-Id";
    private static final String TOKEN_TYPE = "Bearer";


    @Autowired
    private MicrosoftTokenService microsoftTokenService;

    @Autowired
    private PropertyConfig propertyConfig;

    @Autowired
    ObjectFactory<HttpMessageConverters> messageConverters;

    @Bean
    @Scope("prototype")
    public feign.codec.Encoder multipartFormEncoder() {
        return new SpringFormEncoder(new SpringEncoder(messageConverters));
    }


    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header(AUTHORIZATION_HEADER, String.format("%s %s", TOKEN_TYPE, microsoftTokenService.getToken()));
            requestTemplate.header(CONFLUENT_IDENTITY_POOL, propertyConfig.getIdentityPool());
            requestTemplate.header("Content-Type", "application/json");
        };
    }
}
