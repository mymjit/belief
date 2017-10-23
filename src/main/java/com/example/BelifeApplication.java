package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan //扫描自定义的注解
public class BelifeApplication {
	public static void main(String[] args) {
		SpringApplication.run(
				BelifeApplication.class, args);
	}
}
