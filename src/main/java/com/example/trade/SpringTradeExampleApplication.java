package com.example.trade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan({ "com.example.trade"})
public class SpringTradeExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringTradeExampleApplication.class, args);
	}

}
