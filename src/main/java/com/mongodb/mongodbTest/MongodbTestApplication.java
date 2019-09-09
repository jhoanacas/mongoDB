package com.mongodb.mongodbTest;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import javax.annotation.Resource;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages={"com.mongodb.controller", "com.mongodb.services" , "com.mongodb.services.impl"})
@EnableMongoRepositories(basePackages = "com.mongodb.repositories")
@EnableWebSecurity
public class MongodbTestApplication extends WebSecurityConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(MongodbTestApplication.class, args);
	}


	@Resource
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
				.withUser("user").password("{noop}password").roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
				//HTTP Basic authentication
				.httpBasic()
				.and()
				.authorizeRequests()
				.antMatchers(HttpMethod.GET, "/personas/**").hasRole("USER")
				.antMatchers(HttpMethod.POST, "/personas/**").hasRole("USER")
				.antMatchers(HttpMethod.PUT, "/personas/**").hasRole("USER")
				.antMatchers(HttpMethod.PATCH, "/personas/**").hasRole("USER")
				.antMatchers(HttpMethod.DELETE, "/personas/**").hasRole("USER")
				.and()
				.csrf().disable()
				.formLogin().disable();
	}



}
