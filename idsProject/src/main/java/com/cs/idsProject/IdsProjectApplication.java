package com.cs.idsProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
		(scanBasePackages = {"controller","service","entity", "repository"})
public class IdsProjectApplication {

	public static void main(String[] args)  {
		SpringApplication.run(IdsProjectApplication.class, args);
	}

}