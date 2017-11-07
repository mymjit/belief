package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 *@date     : 2017/11/6
 *@author   : whilte
 *@describe :
 */
@EnableCaching
@EnableScheduling
@SpringBootApplication
@ServletComponentScan
public class BelifeApplication {
    public static void main(String[] args) {
        SpringApplication.run(
                BelifeApplication.class, args);
    }
}

