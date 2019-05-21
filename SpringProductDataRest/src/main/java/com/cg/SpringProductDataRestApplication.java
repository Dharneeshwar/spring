package com.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages="com.*")
@EntityScan(basePackages="com.*")
@ComponentScan(basePackages="com.*")
@EnableAutoConfiguration
public class SpringProductDataRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringProductDataRestApplication.class, args);
	}

}
