package com.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.demo.service.ServiceImpl;

@SpringBootApplication
@EntityScan(basePackages = {"com.entity"})
public class Application implements CommandLineRunner {
	
	private final ServiceImpl impl;

	public Application(ServiceImpl impl) {
		this.impl = impl;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("...");
		impl.test();		
	}

}
