package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableCaching
@EnableScheduling
@SpringBootApplication
@ServletComponentScan //扫描自定义的注解
public class BelifeApplication {
    public static void main(String[] args) {
        SpringApplication.run(
                BelifeApplication.class, args);
    }
}

