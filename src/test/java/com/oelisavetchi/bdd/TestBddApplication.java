package com.oelisavetchi.bdd;

import org.springframework.boot.SpringApplication;

public class TestBddApplication {

	public static void main(String[] args) {
		SpringApplication.from(BddApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
