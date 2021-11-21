package com.udp.consumer;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.integration.config.EnableIntegration;

@SpringBootApplication
public class UdpConsumerApplication {

	public static void main(String[] args) {
		ApplicationContext context = new SpringApplicationBuilder()
				.bannerMode(Banner.Mode.OFF)
				.sources(UdpConsumerApplication.class)
				.run(args);
	}


}
