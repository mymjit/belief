package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;

/**
 * @Author : while
 * @Date : 2017/10/25
 * @Describe : SpringBoot整合SpringSession
 */
@EnableRedisHttpSession(
        maxInactiveIntervalInSeconds = 100,
        redisNamespace = "redis"
)
public class HttpSessionConfig {

    @Bean
    public HttpSessionStrategy httpSessionStrategy(){
        return new HeaderHttpSessionStrategy();
    }
}
