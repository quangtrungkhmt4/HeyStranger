package com.trung.HeyStranger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HeyStrangerApplication {

	public static void main(String[] args) {
		System.getProperties().put( "server.port", 9999 );
		SpringApplication.run(HeyStrangerApplication.class, args);
	}

}
