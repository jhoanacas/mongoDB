package com.mongodb.mongodbTest;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableAutoConfiguration(exclude = { SecurityAutoConfiguration.class })
@ComponentScan(basePackages="com.mongodb.services")
@EnableMongoRepositories(basePackages = "com.mongodb.repositories")
public class MongodbTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongodbTestApplication.class, args);
	}
}
