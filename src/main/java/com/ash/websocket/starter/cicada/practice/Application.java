package com.ash.websocket.starter.cicada.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws InterruptedException{
		SpringApplication.run(Application.class, args);
		System.out.println("Print the application is running");
	}

}
