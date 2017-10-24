package com.example.config;


import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @Author : while
 * @Date : 2017/10/24
 * @Describe : Spring Boot 整合Spring Session 的配置文件 需要启动本地的redis服务
 */
@EnableRedisHttpSession
public class HttpSessionConfig {

}
