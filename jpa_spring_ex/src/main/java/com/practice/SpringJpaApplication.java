package com.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author Shivy
 *
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringJpaApplication
{
	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

}
