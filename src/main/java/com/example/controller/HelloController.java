package com.example.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 *@date     : 2017/11/6
 *@author   : whilte
 *@describe :
 */
@Controller
public class HelloController {

    private final static Logger logger = LoggerFactory.getLogger(HelloController.class);

    private Integer uniqueVisitor = 0;

    @GetMapping(value = "/")
    public String index(HttpServletRequest request) {
        count();
        String result = "index";
        return result;
    }

    private void count() {
        this.uniqueVisitor++;
        logger.info("HelloController.index visits : {}", uniqueVisitor);
    }

}
