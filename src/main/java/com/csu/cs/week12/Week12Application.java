package com.csu.cs.week12;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Properties;

@SpringBootApplication

public class Week12Application {
	public static final Properties defaultProperties = new Properties();
	public static void main(String[] args) {
		SpringApplication.run(Week12Application.class, args);
	}



}
