package com.readcsvfile.devapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Configuration
@ComponentScan
@PropertySource(value="classpath:application.properties")
public class ReadCsvDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReadCsvDataApplication.class, args);
	}

}
