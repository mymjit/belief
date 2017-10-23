package com.example.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class HelloController {

    private final static Logger logger = LoggerFactory.getLogger( HelloController.class);
    private Integer uniqueVisitor = 0; //实时访问次数

    @GetMapping( value = "/")
    public String index(){
        count();
        System.out.println("sss");
        return  "index";
    }

    private void count(){
        this.uniqueVisitor++;
        logger.info("methodAccessTimes : {}",uniqueVisitor);
    }

}
