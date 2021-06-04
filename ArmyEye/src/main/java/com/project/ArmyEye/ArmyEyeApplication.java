package com.project.ArmyEye;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.kafka.annotation.EnableKafka;

@Configuration
@EnableKafka
@SpringBootApplication
@EntityScan(basePackages = {"com.project.ArmyEye.Models"})
@EnableJpaRepositories(basePackages = {"com.project.ArmyEye.repository"})
public class ArmyEyeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArmyEyeApplication.class, args);
	}

}
