package com.surgeon.eye;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value="com.surgeon.eye")
public class EyeTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(EyeTestApplication.class, args);

	}
}
