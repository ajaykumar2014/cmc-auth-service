package com.lbg.cmc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.archaius.ArchaiusAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableFeignClients
@EnableSwagger2
@EnableAutoConfiguration(exclude = ArchaiusAutoConfiguration.class)
public class CmcOauthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CmcOauthServiceApplication.class, args);
	}

}
