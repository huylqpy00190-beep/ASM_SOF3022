package com.poly.ASM;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.poly.ASM")
public class AsmApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsmApplication.class, args);
	}

}
