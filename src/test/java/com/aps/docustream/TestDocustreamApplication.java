package com.aps.docustream;

import org.springframework.boot.SpringApplication;

public class TestDocustreamApplication {

	public static void main(String[] args) {
		SpringApplication.from(DocustreamApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
