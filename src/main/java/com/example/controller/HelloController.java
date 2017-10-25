package com.example.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;


@Controller
public class HelloController {

    private final static Logger logger = LoggerFactory.getLogger( HelloController.class);
    private Integer uniqueVisitor = 0; //实时访问次数

    @GetMapping( value = "/")
    public String index(HttpServletRequest request){

        HttpSession session = request.getSession();
        UUID uuid = (UUID) session.getAttribute("uuid");
        if (uuid == null) {
            uuid = UUID.randomUUID();
        }
        session.setAttribute("uuid", uuid);
        logger.info("Session缓存信息 : {}",session.getAttribute("uuid"));
        count();
        return  "index";
    }

    private void count(){
        this.uniqueVisitor++;
        logger.info("接口实时访问人数: {}",uniqueVisitor);
    }

}
