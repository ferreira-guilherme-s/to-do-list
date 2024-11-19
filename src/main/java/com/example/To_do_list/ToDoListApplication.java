package com.example.To_do_list;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.example.users.entities", "com.example.To_do_list.entities"})
@EnableJpaRepositories({"com.example.users.repositories","com.example.To_do_list.repositories"})
@ComponentScan(basePackages = {"com.example.To_do_list", "com.example.users", "com.example.config"})
public class ToDoListApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToDoListApplication.class, args);
	}

}
